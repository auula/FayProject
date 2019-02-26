package club.applo.fay.model;

import club.applo.fay.FayApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @author: ding
 * @email：coding1618@gmail.com
 * @date: 2018-12-18 16:09
 * @version：1.0
 * @Github：https://github.com/coding1618
 * @TODO: 测试自定义注解的使用
 * ==========================
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FayApplication.class)
@WebAppConfiguration
public class DruidConfigDataTest {

    @Autowired
    DruidConfigData druidConfigData;
    @Test
    public void getAllowIP() {
        System.out.println(druidConfigData.getAllowIP());
    }


}