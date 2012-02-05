package service;
import static org.junit.Assert.*;

import hello.domain.Message;
import hello.domain.MessageBox;
import hello.service.MessageBoxFactory;
import hello.service.MessageService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * Created by IntelliJ IDEA.
 * User: haist2002
 * Date: 12. 1. 2.
 * Time: 오후 11:14
 * To change thistemplate use File | Settings | File Templates.
*/

   @RunWith(SpringJUnit4ClassRunner.class)
   @ContextConfiguration(locations={"file:web/WEB-INF/spring/applicationContext.xml"})
   public class TestMessage {
    @Autowired
    private MessageBoxFactory messageBoxFactory;

    @Autowired
    private MessageService messageService;

    @Test
    public void test_메시지박스_생성_후_저장() throws Exception {
        MessageBox messageBox = new MessageBox();
        messageBox.setLabel("메모");
        messageBoxFactory.saveMessageBox(messageBox);

        assertEquals(messageBoxFactory.getMessageBox("메모").getLabel(),"메모");

    }

    @Test
    public void test_메시지박스에_메시지넣기() throws Exception {
        MessageBox messageBox = new MessageBox();
        messageBox.setLabel("메모");
        messageBoxFactory.saveMessageBox(messageBox);

        assertEquals(messageBoxFactory.getMessageBox("메모").getLabel(),"메모");
        Message message = new Message();
        message.setText("Hello Hibernate");
        message.setMessageBox(messageBox);

        messageService.saveMessage(message);

        assertEquals(messageService.getMessage(1).getText(),"Hello Hibernate");
        assertNotNull(messageBoxFactory.getMessageBox("메모").getMessage());
        assertEquals(messageBoxFactory.getMessageBox("메모").getMessage().size(),1);
    }
}
