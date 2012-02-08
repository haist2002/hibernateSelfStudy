package hello.service;

import hello.domain.User;

/**
 * Created by IntelliJ IDEA.
 * User: haist2002
 * Date: 12. 2. 8.
 * Time: 오후 3:45
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    void saveUser(User user);

    User getUser(String userid);
}
