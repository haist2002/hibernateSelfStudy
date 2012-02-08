package hello.domain;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: haist2002
 * Date: 12. 2. 8.
 * Time: 오후 1:57
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class User {

    @Id
    private String userid;

    @Column
    private String name;

    public String getUserid() {
        return userid;
    }

    public String getName() {
        return name;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setName(String name) {
        this.name = name;
    }
}
