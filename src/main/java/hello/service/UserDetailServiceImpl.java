package hello.service;

import hello.domain.UserDetail;
import hello.repository.jpaRepository.UserDetailJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12. 2. 9
 * Time: 오후 10:02
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserDetailServiceImpl implements UserDetailService{

    @Autowired
    private UserDetailJpaRepository userDetailJpaRepository;

    public UserDetail saveUserDetail(UserDetail userDetail) {
       return userDetailJpaRepository.save(userDetail);
    }
}
