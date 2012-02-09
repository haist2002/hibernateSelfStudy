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
public class MessageBoxRepositoryImpl implements MessageBoxRepository{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
       return sessionFactory.getCurrentSession();

    }

    public void save(MessageBox messageBox) {
      getSession().save(messageBox);
    }

    public MessageBox getMessageBox(Integer no) {
        return  (MessageBox) getSession().get(MessageBox.class,no);
    }

    public void updateMessageBox(MessageBox messageBox) {
        getSession().update(messageBox);
    }

    public void deleteMessageBox(MessageBox messageBox) {
        getSession().delete(messageBox);
    }

    public MessageBox loadMessageBox(Integer no) {
        return (MessageBox) getSession().load(MessageBox.class,no);
    }

}
