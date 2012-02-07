package hello.repository;

import hello.domain.MessageBox;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12. 2. 5
 * Time: 오후 3:18
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Transactional
public class MessageBoxRepositoryImpl implements MessageBoxRepository{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
       return sessionFactory.getCurrentSession();
    }

    public void save(MessageBox messageBox) {
      getSession().save(messageBox);
    }

    public MessageBox getMessageBox(String label) {
        return  (MessageBox) getSession().get(MessageBox.class,label);
    }
}
