package service;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

import hello.domain.Message;
import hello.domain.MessageBox;
import hello.repository.MessageBoxRepository;
import hello.service.MessageBoxService;
import hello.service.MessageService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanConstructorResultTransformer;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

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

    @Autowired
    private SessionFactory sessionFactory;

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

        assertThat(messageBox.getLabel(), is("메모"));

        messageBox.setLabel("심부름내역");
        messageBoxService.modifyMessageBox(messageBox);

        assertThat(messageBoxService.getMessageBox(1).getLabel(), is("심부름내역"));

        messageBoxService.dropMessageBox(messageBox);

        assertThat(messageBoxService.getMessageBox(1),is(nullValue()));
    }

    @Test
    public void test_MessageBox_Load() throws Exception {


        MessageBox messageBox = messageBoxService.getMessageBox(1);
        assertEquals(messageBox.getLabel(), "메모");

        messageBox.setLabel("할일내역");

        assertThat(messageBoxService.getMessageBox(1).getLabel(), is("할일내역"));

    }

    @Test
    public void test_Persistence_Test() throws Exception {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        MessageBox messageBox = (MessageBox)session.get(MessageBox.class,1);
        assertThat(messageBox.getLabel(),is("메모"));

        messageBox.setLabel("할일내역");

        tx.commit();
        session.close();

        assertThat(messageBoxService.getMessageBox(1).getLabel(),is("할일내역"));

    }

    @Test
    public void test_Criteria_Test() throws Exception {
        MessageBox temp_messageBox = messageBoxService.getMessageBox(1);
        for (int i=0; i< 10 ; i++){
            Message temp_message = new Message();
            temp_message.setText(String.valueOf(i));
            temp_message.setMessageBox(temp_messageBox);
            messageService.saveMessage(temp_message);
        }

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(Message.class);

        ArrayList<Message> messageList = (ArrayList<Message>)criteria.list();
        assertThat(messageList.size(),is(10));

        tx.commit();
        session.close();

    }

    @Test
    public void test_Criteria_Projection_Test() throws Exception {
        MessageBox temp_messageBox = messageBoxService.getMessageBox(1);
        for (int i=0; i< 10 ; i++){
            Message temp_message = new Message();
            temp_message.setText(String.valueOf(i));
            temp_message.setMessageBox(temp_messageBox);
            messageService.saveMessage(temp_message);
        }

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(Message.class);

        /*
        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.property("text").as("text"));

        criteria.setProjection(projectionList);
        criteria.setResultTransformer(new AliasToBeanResultTransformer(Message.class));
        */

        criteria.add(Restrictions.eq("text","1"));

        ArrayList<Message> messageList = (ArrayList<Message>)criteria.list();
        assertThat(messageList.size(),is(1));

        tx.commit();
        session.close();

    }

}
