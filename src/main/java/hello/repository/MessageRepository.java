package hello.repository;

import hello.domain.Message;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12. 2. 6
 * Time: 오전 12:14
 * To change this template use File | Settings | File Templates.
 */
public interface MessageRepository {
    void insertMessage(Message message);

    Message selectMessage(Integer id);

}
