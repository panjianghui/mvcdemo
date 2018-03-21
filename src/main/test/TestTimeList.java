import com.jh.service.UserService;
import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTimeList extends TestCase {

    public void testGetTimeList(){
        System.setProperty("java.net.preferIPv4Stack","true");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        context.start();
        UserService user = (UserService)context.getBean("userService");
        user.getTimeList();
    }
}
