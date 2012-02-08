package hello.service;

import hello.domain.MessageBox;

/**
 * Created by IntelliJ IDEA.
 * User: haist2002
 * Date: 12. 2. 7.
 * Time: 오후 3:12
 * To change this template use File | Settings | File Templates.
 */
public interface MessageBoxService {
    void saveMessageBox(MessageBox messageBox);

    MessageBox getMessageBox(Integer no);

    void saveMessageBoxJPA(MessageBox messageBox);

    MessageBox getMessageBoxJPA(Integer no);

    void modifyMessageBox(MessageBox messageBox);
}
