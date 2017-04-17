package am.test.data;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by karlen on 4/16/17.
 */
public class BaseTest {

    protected static ApplicationContext applicationContext;

    @BeforeClass
    public static void setUp() {
        applicationContext = new ClassPathXmlApplicationContext("spring/application.xml");
    }
}
