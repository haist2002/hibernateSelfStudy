package hello.domain;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: haist2002
 * Date: 12. 2. 8.
 * Time: 오후 3:36
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class UserDetail {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String Email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
