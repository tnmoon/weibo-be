import org.azhang.weibo.WeiboApplication;
import org.azhang.weibo.controller.BlogController;
import org.azhang.weibo.dao.BlogDao;
import org.azhang.weibo.service.BlogService;
import org.azhang.weibo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeiboApplication.class)
public class UnitTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogDao blogDao;
    @Autowired
    private BlogController blogController;

    @Test
    public void testDatabase() {
//        System.out.println(this.userDetailsService.loadUserByUsername("li895227852").getPassword());
//        System.out.println(this.userService.register("425085731", "000000", "azhang"));
//        System.out.println(this.blogService.getBlogById(13L));
//        System.out.println(blogService.getTimelineBlog(1L, 0L, ));
//        System.out.println(blogDao.getTimelineBlog(1L, 0L, 1581869460L));
//        System.out.println(blogDao.getCommentByBlogId(33L).size());
//        System.out.println(blogDao.getTimelineBlogIdRelation(1L, 0L, 1582442740L));

//        List<CommentDetailResult> b = blogDao.getCommentListDetailById(1l, a);
//        System.out.println(b);
    }

}
