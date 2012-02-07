package service;

import static org.junit.Assert.*;
import hello.domain.Message;
import hello.domain.MessageBox;
import hello.service.MessageBoxService;
import org.junit.Ignore;
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
    private MessageBoxService messageBoxService;

    @Test
    public void testMessae_메시지박스_생성_후_저장() throws Exception {
        MessageBox messageBox = new MessageBox("심부름내역");
        messageBoxService.saveMessageBoxJPA(messageBox);

        assertEquals(messageBoxService.getMessageBoxJPA("심부름내역").getLabel(),"심부름내역");
    }

    @Test
    public void testMessage_메시지_생성후_저장() throws Exception {
        Message message = new Message();
        message.setText("담배사와라!!!! 레종1mg로~~~");
        MessageBox mb = messageBoxService.getMessageBox("심부름내역");
        mb.getMessages().add(message);

        messageBoxService.saveMessageBoxJPA(mb);

        assertNotNull(messageBoxService.getMessageBoxJPA("심부름내역").getMessages());

        assertEquals(messageBoxService.getMessageBoxJPA("심부름내역").getMessages().size(),1);
    }

    @Test
    @Ignore
    public void test이그노어() throws Exception {

    }
}
