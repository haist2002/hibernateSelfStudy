package service;

import static org.junit.Assert.*;
import hello.domain.Message;
import hello.domain.MessageBox;
import hello.service.MessageBoxService;
import hello.service.MessageService;
import org.hibernate.SessionFactory;
import org.junit.Before;
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

    @Autowired
    private MessageService messageService;

    @Before
    @Test
    public void testMessaeBox_save_and_confirm() throws Exception {
        MessageBox messageBox = new MessageBox("심부름내역");

        messageBoxService.saveMessageBoxJPA(messageBox);

        assertEquals(messageBoxService.getMessageBoxJPA(1).getLabel(),"심부름내역");
    }

    @Test
    public void testMessage_save_and_confirm() throws Exception {
        Message message = new Message();
        message.setText("담배사와라!!!! 레종1mg로~~~");

        MessageBox mb = messageBoxService.getMessageBox(1);
        message.setMessageBox(mb);

        messageService.saveMessageJPA(message);

        assertNotNull(messageBoxService.getMessageBoxJPA(1).getMessages().size());

        assertNotNull(messageService.getMessageJPA(1).getMessageBox());
    }

}
