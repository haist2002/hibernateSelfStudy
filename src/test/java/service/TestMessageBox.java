package service;

import hello.domain.MessageBox;
import hello.domain.User;
import hello.service.MessageBoxService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12. 2. 7
 * Time: 오후 10:42
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:web/WEB-INF/spring/applicationContext.xml"})
public class TestMessageBox {

    @Autowired
    private MessageBoxService messageBoxService;

    @Test
    public void test_메시지박스_생성_후_저장() throws Exception {

        MessageBox messageBox = new MessageBox("메모");
        messageBoxService.saveMessageBox(messageBox);

        assertEquals(messageBoxService.getMessageBox("메모").getLabel(),"메모");

    }

    @Test
    public void testMessageBox_메시지박스_주인_설정_후_업데이트() throws Exception {
        MessageBox messageBox = messageBoxService.getMessageBoxJPA("메모");
        User user = new User();
        user.setName("안병휘");
        user.setUserid("haist2002");
//        messageBox.setOwner(user);
//
//        messageBoxService.modifyMessageBox(messageBox);
//
//        assertEquals(messageBoxService.getMessageBox("메모").getOwner().getName(),"안병휘");



    }

}
