package hello.repository;

import hello.domain.MessageBox;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12. 2. 5
 * Time: 오후 3:17
 * To change this template use File | Settings | File Templates.
 */
public interface MessageBoxRepository {
    void save(MessageBox messageBox);

    MessageBox getMessageBox(Integer no);

    void updateMessageBox(MessageBox messageBox);
}
