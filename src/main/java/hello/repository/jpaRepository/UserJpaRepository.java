package hello.repository.jpaRepository;

import hello.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * User: haist2002
 * Date: 12. 2. 8.
 * Time: 오후 3:51
 * To change this template use File | Settings | File Templates.
 */
public interface UserJpaRepository extends JpaRepository<User,String>{
}
