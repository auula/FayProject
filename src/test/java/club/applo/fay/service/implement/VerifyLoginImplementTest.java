package club.applo.fay.service.implement;

import club.applo.fay.FayApplication;
import club.applo.fay.mapper.UserInfoMapper;
import club.applo.fay.model.LoginData;
import club.applo.fay.pojo.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-19 15:50
 * @TODO: 登录服务测试
 * ==========================
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FayApplication.class)
@WebAppConfiguration
public class VerifyLoginImplementTest {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Test
    public void verifyLogin() {
        LoginData loginData =new LoginData();
        loginData.setEmail("admin@xx.com");
        loginData.setPassword("xxxx");
        UserInfo userInfo = userInfoMapper.selectByEmailAndPassword(loginData.getEmail(),loginData.getPassword());
        System.out.println(userInfo.getEmail());
    }
}