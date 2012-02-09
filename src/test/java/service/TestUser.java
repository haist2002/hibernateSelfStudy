package service;

import static org.junit.Assert.*;
import hello.domain.User;
import hello.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

    @Test
    public void test_User_Save() throws Exception {
        User user = new User();
        user.setUserid("haist2002");
        user.setName("안병휘");
        userService.saveUser(user);

        User temp_user = userService.getUser("haist2002");

        assertEquals(user.getName(),temp_user.getName());
    }
}
