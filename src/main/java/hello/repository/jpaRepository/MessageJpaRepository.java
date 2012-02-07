package hello.repository.jpaRepository;

import hello.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * User: haist2002
 * Date: 12. 2. 7.
 * Time: 오전 11:39
 * To change this template use File | Settings | File Templates.
 */
public interface MessageJpaRepository extends JpaRepository<Message,Integer>{
}
