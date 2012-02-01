package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by IntelliJ IDEA.
 * User: haist2002
 * Date: 12. 1. 2.
 * Time: 오후 11:14
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:web/WEB-INF/spring/applicationContext.xml"})
public class TestMessage {

    @Test
    public void testMessage() throws Exception {

    }
}
