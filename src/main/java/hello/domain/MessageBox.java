package hello.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12. 2. 5
 * Time: 오후 2:52
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class MessageBox {

    @Id
    private String label;

    @OneToMany(mappedBy = "messageBox")
    private Set<Message> messages;

    public MessageBox(String label){
        this.label = label;
    }

    public MessageBox(){}


    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
