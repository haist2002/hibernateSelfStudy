package hello.service;

import hello.domain.Message;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12. 2. 5
 * Time: 오후 11:15
 * To change this template use File | Settings | File Templates.
 */
public interface MessageService {
    void saveMessage(Message message);

    Message getMessage(Integer id);

    Message getMessageJPA(Integer id);

    void saveMessageJPA(Message message);
}
