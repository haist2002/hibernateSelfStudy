package hello.service;

import hello.domain.Message;
import hello.repository.MessageRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12. 2. 5
 * Time: 오후 11:15
 * To change this template use File | Settings | File Templates.
 */
@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageRepository messageRepositroy;

    public void saveMessage(Message message) {
        messageRepositroy.insertMessage(message);

    }

    public Message getMessage(Integer id) {
       return messageRepositroy.selectMessage(id);
    }
}
