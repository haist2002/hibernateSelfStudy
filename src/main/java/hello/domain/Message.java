package hello.domain;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: haist2002
 * Date: 12. 1. 2.
 * Time: 오후 5:28
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Message {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "label",nullable = false)
    private MessageBox messageBox;


    public MessageBox getMessageBox(){
        return messageBox;
    }

    public void setMessageBox(MessageBox messageBox) {
        this.messageBox = messageBox;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
