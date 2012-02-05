package hello.repository;

import hello.domain.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12. 2. 6
 * Time: 오전 12:14
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Transactional
public class MessageRepositoryImpl implements MessageRepository{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public void insertMessage(Message message) {
        getSession().save(message);
    }

    public Message selectMessage(Integer id) {
        return (Message) getSession().get(Message.class,id);
    }
}
