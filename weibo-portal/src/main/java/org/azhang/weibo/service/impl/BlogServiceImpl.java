package org.azhang.weibo.service.impl;

import org.azhang.weibo.dao.BlogDao;
import org.azhang.weibo.dto.*;
import org.azhang.weibo.mapper.*;
import org.azhang.weibo.model.*;
import org.azhang.weibo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;
    @Autowired
    BlogPictureMapper blogPictureMapper;
    @Autowired
    BlogDao blogDao;
    @Autowired
    BlogRepostMapper blogRepostMapper;
    @Autowired
    BlogLikeMapper blogLikeMapper;
    @Autowired
    BlogCollectMapper blogCollectMapper;

    @Override
    public BlogDetailResult insertBlog(PostBlogParam postBlogParam) {
        List<String> pictureUrlArray = postBlogParam.getPictureUrlArray();

        if (postBlogParam.getText().length() > 140) {
            postBlogParam.setText(postBlogParam.getText().substring(0, 140));
        }
        Blog blog = new Blog();
        blog.setPostLocation(postBlogParam.getPostLocation());
        blog.setPostTerminal(postBlogParam.getPostTerminal());
        blog.setText(postBlogParam.getText());
        blog.setUserId(postBlogParam.getUserId());
        Integer type = 0;
        if (pictureUrlArray != null && pictureUrlArray.size() > 0) type += 1;
        if (postBlogParam.getSourceBlogId() != null) type += 2;
        blog.setType(type);

        List<Long> flatBlogIdList = new ArrayList<>();

        try {
            blogMapper.insertSelective(blog);
            Long blogId = blog.getId();
            flatBlogIdList.add(blogId);
            if (pictureUrlArray != null && pictureUrlArray.size() > 0) {
                BlogPicture blogPicture = new BlogPicture();
                for (String url : pictureUrlArray) {
                    blogPicture.setBlogId(blogId);
                    blogPicture.setUrl(url);
                    blogPictureMapper.insert(blogPicture);
                }
            }
            if (postBlogParam.getSourceBlogId() != null) {
                BlogRepost blogRepost = new BlogRepost();
                blogRepost.setBlogId(blogId);
                blogRepost.setSourceBlogId(postBlogParam.getSourceBlogId());
                blogRepost.setLeafBlogId(postBlogParam.getLeafBlogId());
                blogRepostMapper.insert(blogRepost);
                flatBlogIdList.add(postBlogParam.getSourceBlogId());
            }

            List<BlogDetailResult> blogDetailResultList = blogDao.getBlogListDetailById(flatBlogIdList, postBlogParam.getUserId());
            for (BlogDetailResult b : blogDetailResultList) {
                b.setRepostCount(0);
            }
            if (blogDetailResultList.size() == 1) return blogDetailResultList.get(0);
            if (blogDetailResultList.get(0).getBlogId() == blogId) {
                blogDetailResultList.get(0).setSourceBlogDetail(blogDetailResultList.get(1));
                return blogDetailResultList.get(0);
            } else {
                blogDetailResultList.get(1).setSourceBlogDetail(blogDetailResultList.get(0));
                return blogDetailResultList.get(1);
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    @Override
    public List<BlogDetailResult> getTimelineBlog(Long userId, Long lastBlogId, Long lastBlogTimestamp) {
        try {
            List<BlogIdRelationResult> blogIdRelationResultList = blogDao.getTimelineBlogIdRelation(userId, lastBlogId, lastBlogTimestamp / 1000);
            if (blogIdRelationResultList == null || blogIdRelationResultList.size() == 0) {
                System.out.println(blogIdRelationResultList);
                return new ArrayList<>(); // 这里代表已经查询到时间线底部了
            }
            List<Long> flatBlogIdList = new ArrayList<>();
            for (BlogIdRelationResult b : blogIdRelationResultList) {
                flatBlogIdList.add(b.getId());
                Long sourceBlogId = b.getSourceBlogId();
                if (sourceBlogId != null) {
                    flatBlogIdList.add(sourceBlogId);
                }
            }
            List<BlogDetailResult> flatBlogDetailResultList = blogDao.getBlogListDetailById(flatBlogIdList, userId);
            Map<Long, BlogDetailResult> flatBlogDetailTransferMap = new HashMap<>();
            for (BlogDetailResult b : flatBlogDetailResultList) {
                b.setRepostCount(blogDao.getRepostCountByBlogId(b.getBlogId()));
                flatBlogDetailTransferMap.put(b.getBlogId(), b);
            }
            List<BlogDetailResult> blogDetailResultList = new ArrayList<>();
            for (BlogIdRelationResult b : blogIdRelationResultList) {
                BlogDetailResult blogDetailResult = flatBlogDetailTransferMap.get(b.getId());
                Long sourceBlogId = b.getSourceBlogId();
                if (sourceBlogId != null) {
                    blogDetailResult.setSourceBlogDetail(flatBlogDetailTransferMap.get(sourceBlogId));
                }
                blogDetailResultList.add(blogDetailResult);
            }
            return blogDetailResultList;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }


    @Override
    public Boolean insertBlogLike(BlogLike blogLike) {
        try {
            blogLikeMapper.insertSelective(blogLike);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Boolean deleteBlogLike(BlogLike blogLike) {
        try {
            BlogLikeExample blogLikeExample = new BlogLikeExample();
            blogLikeExample.createCriteria().andBlogIdEqualTo(blogLike.getBlogId());
            blogLikeExample.createCriteria().andUserIdEqualTo(blogLike.getUserId());
            blogLikeMapper.deleteByExample(blogLikeExample);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Boolean insertCollect(BlogCollect blogCollect) {
        try {
            blogCollectMapper.insertSelective(blogCollect);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Boolean deleteCollect(BlogCollect blogCollect) {
        try {
            BlogCollectExample blogCollectExample = new BlogCollectExample();
            blogCollectExample.createCriteria().andBlogIdEqualTo(blogCollect.getBlogId());
            blogCollectExample.createCriteria().andUserIdEqualTo(blogCollect.getUserId());
            blogCollectMapper.deleteByExample(blogCollectExample);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }


}
