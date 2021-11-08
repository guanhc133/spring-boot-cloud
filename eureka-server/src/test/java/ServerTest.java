import org.itguan.EurekaServerApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = EurekaServerApplication.class)
public class ServerTest {

    @Test
    public void test() {
        System.out.println("test-------");
    }

}
