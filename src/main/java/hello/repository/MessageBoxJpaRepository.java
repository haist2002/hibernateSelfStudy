package hello.repository;

import hello.domain.MessageBox;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * User: haist2002
 * Date: 12. 2. 7.
 * Time: 오전 11:34
 * To change this template use File | Settings | File Templates.
 */
public interface MessageBoxJpaRepository extends JpaRepository<MessageBox,String>{
}
