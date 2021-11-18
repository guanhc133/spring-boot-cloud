package org.itguan;

import org.itguan.service.UserServiceFeign;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest {

    @Autowired
    private UserServiceFeign userServiceFeign;
    /**
     * 测试本地调用远程服务（无token）自动获取token（token传递）
     */
    @Test
    public void shouldAnswerWithTrue() {
        System.out.println(userServiceFeign.getUserBasics());
    }
}
