package club.applo.fay.mapper;

import club.applo.fay.FayApplication;
import club.applo.fay.pojo.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-26 20:28
 * @TODO: 类描述
 * ==========================
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FayApplication.class)
@WebAppConfiguration
public class UserInfoMapperTest {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Test
    public void selectByExpirationTime() {
        Map<String,Object> map =new HashMap();
        map.put("UID","14");
        map.put("nowTime",System.currentTimeMillis()+"");
        UserInfo userInfo = userInfoMapper.selectByExpirationTime(map);
        System.out.println(userInfo.toString());
    }
}