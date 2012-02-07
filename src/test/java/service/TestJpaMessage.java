package service;

import static org.junit.Assert.*;

import hello.domain.Message;
import hello.domain.MessageBox;
import hello.service.MessageBoxServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by IntelliJ IDEA.
 * User: haist2002
 * Date: 12. 2. 7.
 * Time: 오후 1:50
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:web/WEB-INF/spring/applicationContext.xml"})
public class TestJpaMessage {

    @Autowired
    private MessageBoxServiceImpl messageBoxFactory;

    @Test
    public void testMessae_메시지박스_생성_후_저장() throws Exception {
        MessageBox messageBox = new MessageBox("심부름내역");
        messageBoxFactory.saveMessageBoxJPA(messageBox);

        assertEquals(messageBoxFactory.getMessageBoxJPA("심부름내역").getLabel(),"심부름내역");
    }

    @Test
    public void testMessage_메시지_생성후_저장() throws Exception {
        Message message = new Message();
        message.setText("담배사와라!!!! 레종1mg로~~~");
        MessageBox mb = messageBoxFactory.getMessageBox("심부름내역");
        mb.getMessages().add(message);

    }

    @Test
    public void test브런치테스트() throws Exception {
        //To change body of created methods use File | Settings | File Templates.
    }
}
