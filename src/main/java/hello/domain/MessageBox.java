package hello.domain;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.security.acl.Owner;
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

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer no;

    @Column
    private String label;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "messageBox")
    private Set<Message> messages;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

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
