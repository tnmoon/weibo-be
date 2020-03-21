package org.azhang.weibo.service.impl;

import org.azhang.weibo.dao.CommentDao;
import org.azhang.weibo.dto.CommentDetailParam;
import org.azhang.weibo.dto.CommentDetailResult;
import org.azhang.weibo.dto.CommentIdRelationResult;
import org.azhang.weibo.mapper.CommentLikeMapper;
import org.azhang.weibo.mapper.CommentMapper;
import org.azhang.weibo.model.Comment;
import org.azhang.weibo.model.CommentLike;
import org.azhang.weibo.model.CommentLikeExample;
import org.azhang.weibo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;
    @Autowired
    CommentDao commentDao;
    @Autowired
    CommentLikeMapper commentLikeMapper;

    @Override
    public CommentDetailResult insertComment(String text, Long ownerId, Integer commentType, Long userId) {
        try {
            if (commentType != 1 && commentType != 2) {
                throw new Exception("commentType字段校验错误");
            }
            if (text.length() > 140) {
                text = text.substring(0, 140);
            }
            Comment comment = new Comment();
            comment.setOwnerId(ownerId);
            comment.setCommentType(commentType);
            comment.setText(text);
            comment.setUserId(userId);
            commentMapper.insertSelective(comment);

            List<Long> commentIdList = new ArrayList<>();
            commentIdList.add(comment.getId());
            List<CommentDetailResult> commentDetailResultList = commentDao.getCommentListDetailById(userId, commentIdList);

            CommentDetailResult commentDetailResult = commentDetailResultList.get(0);
            commentDetailResult.setLikeCount(0);
            commentDetailResult.setReplyCount(0);
            commentDetailResult.setCommentPostTime(commentMapper.selectByPrimaryKey(comment.getId()).getCommentTime());

            return commentDetailResult;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Boolean insertCommentLike(CommentLike commentLike) {
        try {
            commentLikeMapper.insertSelective(commentLike);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Boolean deleteCommentLike(CommentLike commentLike) {
        try {
            CommentLikeExample commentLikeRelationExample = new CommentLikeExample();
            commentLikeRelationExample.createCriteria().andCommentIdEqualTo(commentLike.getCommentId());
            commentLikeRelationExample.createCriteria().andUserIdEqualTo(commentLike.getUserId());
            commentLikeMapper.deleteByExample(commentLikeRelationExample);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public List<CommentDetailResult> getCommentByBlogId(CommentDetailParam commentDetailParam) {

        try {
            List<CommentIdRelationResult> commentIdRelationResultList = commentDao.getCommentIdRelationByBlogId(commentDetailParam);
            if (commentIdRelationResultList == null || commentIdRelationResultList.size() == 0) {
                return new ArrayList<>();
            }
            List<Long> flatCommentIdList = new ArrayList<>();
            for (CommentIdRelationResult mc : commentIdRelationResultList) {
                flatCommentIdList.add(mc.getCommentId());
                for (CommentIdRelationResult rc : mc.getReplyList()) {
                    flatCommentIdList.add(rc.getCommentId());
                }
            }
            List<CommentDetailResult> flatCommentDetailResultList = commentDao.getCommentListDetailById(commentDetailParam.getUserId(), flatCommentIdList);
            Map<Long, CommentDetailResult> commentDetailResultMap = new HashMap<>();
            for (CommentDetailResult cm : flatCommentDetailResultList) {
                commentDetailResultMap.put(cm.getCommentId(), cm);
            }
            for (CommentIdRelationResult cid : commentIdRelationResultList) {
                CommentDetailResult c = commentDetailResultMap.get(cid.getCommentId());
                c.setReplyList(new ArrayList<>());
                c.setCommentPostTime(cid.getCommentPostTime());
                c.setLikeCount(cid.getLikeCount());
                c.setReplyCount(cid.getReplyCount());
            }
            List<CommentDetailResult> commentDetailResultList = new ArrayList<>();
            for (CommentIdRelationResult mcid : commentIdRelationResultList) {
                CommentDetailResult mainCommentDetailResult = commentDetailResultMap.get(mcid.getCommentId());
                mainCommentDetailResult.setReplyList(new ArrayList<>());
                mainCommentDetailResult.setReplyCount(mcid.getReplyCount());
                mainCommentDetailResult.setCommentPostTime(mcid.getCommentPostTime());
                mainCommentDetailResult.setLikeCount(mcid.getLikeCount());
                if (mcid.getReplyList() != null) {
                    for (CommentIdRelationResult rcid : mcid.getReplyList()) {
                        CommentDetailResult replyCommentDetailResult = commentDetailResultMap.get(rcid.getCommentId());
                        replyCommentDetailResult.setCommentPostTime(rcid.getCommentPostTime());
                        replyCommentDetailResult.setLikeCount(rcid.getLikeCount());
                        mainCommentDetailResult.getReplyList().add(replyCommentDetailResult);
                    }
                }
                commentDetailResultList.add(mainCommentDetailResult);
            }
            return commentDetailResultList;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
