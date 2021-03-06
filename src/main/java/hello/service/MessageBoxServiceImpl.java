package hello.service;

import hello.domain.Message;
import hello.domain.MessageBox;
import hello.repository.MessageBoxRepository;
import hello.repository.jpaRepository.MessageBoxJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12. 2. 5
 * Time: 오후 2:56
 * To change this template use File | Settings | File Templates.
 */
@Service
public class MessageBoxServiceImpl implements MessageBoxService{

    @Autowired
    private MessageBoxRepository messageBoxRepository;

    @Autowired
    private MessageBoxJpaRepository messageBoxJpaRepository;

    public MessageBox getMessageBox(Integer no) {
        return messageBoxRepository.getMessageBox(no);
    }

    public void saveMessageBox(MessageBox messageBox) {
        messageBoxRepository.save(messageBox);
    }

    public void saveMessageBoxJPA(MessageBox messageBox) {
        messageBoxJpaRepository.save(messageBox);
    }

    public MessageBox getMessageBoxJPA(Integer no) {
        return messageBoxJpaRepository.findOne(no);
    }

    public void modifyMessageBox(MessageBox messageBox) {
        messageBoxRepository.updateMessageBox(messageBox);
    }

    public void dropMessageBox(MessageBox messageBox) {
        messageBoxRepository.deleteMessageBox(messageBox);
    }

    public MessageBox loadMessageBox(Integer no) {
        return messageBoxRepository.loadMessageBox(no);
    }
}
