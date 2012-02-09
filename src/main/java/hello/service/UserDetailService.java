package hello.service;

import hello.domain.UserDetail;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12. 2. 9
 * Time: 오후 10:01
 * To change this template use File | Settings | File Templates.
 */
public interface UserDetailService {
    UserDetail saveUserDetail(UserDetail userDetail);
}
