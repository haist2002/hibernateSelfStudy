package hello.service;

import hello.domain.User;
import hello.repository.jpaRepository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: haist2002
 * Date: 12. 2. 8.
 * Time: 오후 3:48
 * To change this template use File | Settings | File Templates.
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserJpaRepository userJpaRepository;

    public User saveUser(User user) {
        return userJpaRepository.save(user);
    }

    public User getUser(String userid) {
        return userJpaRepository.findOne(userid);
    }
}
