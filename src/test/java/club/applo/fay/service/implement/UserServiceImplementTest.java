package club.applo.fay.service.implement;

import club.applo.fay.FayApplication;
import club.applo.fay.pojo.UserInfo;
import club.applo.fay.service.UserService;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;


/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @author: ding
 * @email：coding1618@gmail.co
 * @date: 2018-12-18 18:50
 * @version：1.0
 * @Github：https://github.com/coding1618
 * @TODO: 用户数据业务测试
 * ==========================
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FayApplication.class)
@WebAppConfiguration
public class UserServiceImplementTest {

    @Autowired
    UserService userService;
    @Test
    public void insertUser() {
        long time = new Date().getTime();
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail("ding@codegc.me");
        userInfo.setPassword("dingshuo.xxxxx");
        userInfo.setStatus(Byte.parseByte("0"));
        userInfo.setCreateTime(String.valueOf(time));
        userInfo.setUpdateTime(String.valueOf(time));
        userInfo.setDueTime(String.valueOf(time+"111231"));
        userInfo.setNowKey("codegc.me");
        System.out.println(userService.insertUser(userInfo));
    }
}