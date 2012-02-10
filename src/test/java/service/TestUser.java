package service;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import hello.domain.User;
import hello.domain.UserDetail;
import hello.service.UserDetailService;
import hello.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: haist2002
 * Date: 12. 2. 8.
 * Time: 오후 3:42
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:web/WEB-INF/spring/applicationContext.xml"})
public class TestUser{

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailService userDetailService;

    @Test
    public void test_User_Save() throws Exception {
        User user = new User();
        user.setUserid("haist2002");
        user.setName("안병휘");
        userService.saveUser(user);

        User temp_user = userService.getUser("haist2002");

        assertEquals(user.getName(),temp_user.getName());
    }

    @Test
    //@Transactional
    public void test_OneToOne_UserDetail() throws Exception {
        User user = new User();
        user.setName("김민경");
        user.setUserid("mk0005");

        UserDetail userDetail = new UserDetail();
        userDetail.setEmail("mk0005@naver.com");
        
        user.setUserDetail(userDetail);

        userDetail = userDetailService.saveUserDetail(userDetail);
        user = userService.saveUser(user);

        assertThat(user.getName(),is("김민경"));

        assertThat(userService.getUser("mk0005").getUserDetail().getEmail(),is("mk0005@naver.com"));

    }
}
