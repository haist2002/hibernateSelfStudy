package hello.service;

import hello.domain.MessageBox;
import hello.repository.MessageBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12. 2. 5
 * Time: 오후 2:56
 * To change this template use File | Settings | File Templates.
 */
@Service
public class MessageBoxFactory {

    @Autowired
    private MessageBoxRepository messageBoxRepository;

    public MessageBox getMessageBox(String label) {
        return messageBoxRepository.getMessageBox(label);
    }

    public void saveMessageBox(MessageBox messageBox) {
        messageBoxRepository.save(messageBox);
    }
}
