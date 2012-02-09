package service;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

import hello.domain.Message;
import hello.domain.MessageBox;
import hello.repository.MessageBoxRepository;
import hello.service.MessageBoxService;
import hello.service.MessageService;
import org.junit.Before;
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
    private MessageBoxService messageBoxService;

    @Autowired
    private MessageService messageService;


    @Before
    @Test
    public void test_MessageBox_Save_and_Confirm() throws Exception {
        MessageBox messageBox = new MessageBox("메모");

        messageBoxService.saveMessageBox(messageBox);

        assertEquals(messageBoxService.getMessageBox(1).getLabel(),"메모");

    }

    @Test
    public void test_MessageBox_Input_Message() throws Exception {

        assertEquals(messageBoxService.getMessageBox(1).getLabel(),"메모");
        Message message = new Message();
        message.setText("Hello Hibernate");
        message.setMessageBox(messageBoxService.getMessageBox(1));

        messageService.saveMessage(message);

        assertEquals(messageService.getMessage(1).getText(),"Hello Hibernate");
        assertNotNull(messageBoxService.getMessageBox(1).getMessages());
        assertEquals(messageBoxService.getMessageBox(1).getMessages().size(),1);

    }

    @Test
    public void test_MessageBox_Update_and_Delete() throws Exception {
        MessageBox messageBox = messageBoxService.getMessageBox(1);

        assertThat(messageBox.getLabel(),is("메모"));

        messageBox.setLabel("심부름내역");
        messageBoxService.modifyMessageBox(messageBox);

        assertThat(messageBoxService.getMessageBox(1).getLabel(), is("심부름내역"));

        messageBoxService.dropMessageBox(messageBox);

        assertThat(messageBoxService.getMessageBox(1),is(nullValue()));
    }

    @Test
    public void test_MessageBox_Load() throws Exception {


        MessageBox messageBox = messageBoxService.getMessageBox(1);
        messageBox.setLabel("할일내역");

        assertThat(messageBoxService.getMessageBox(1).getLabel(),is("할일내역"));

    }

}
