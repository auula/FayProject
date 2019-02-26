package club.applo.fay.mapper;

import club.applo.fay.FayApplication;
import club.applo.fay.pojo.UserLOG;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-24 16:58
 * @TODO: 测试查询log日志
 * ==========================
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FayApplication.class)
@WebAppConfiguration
public class UserLOGMapperTest {
    @Autowired
    UserLOGMapper userLOGMapper;
    @Test
    public void getLOGData() {
        List<UserLOG> logData = userLOGMapper.selectByUid(10);
        for (UserLOG logDatum : logData) {
            System.out.println(logDatum);
        }
        System.out.println(logData);
    }
}