package hello.repository.jpaRepository;

import hello.domain.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12. 2. 9
 * Time: 오후 10:03
 * To change this template use File | Settings | File Templates.
 */
public interface UserDetailJpaRepository extends JpaRepository<UserDetail,Integer>{
}
