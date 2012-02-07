package hello.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

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
    private List<Message> message;

    public MessageBox(String label){
        this.label = label;
    }

    public MessageBox(){}


    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
