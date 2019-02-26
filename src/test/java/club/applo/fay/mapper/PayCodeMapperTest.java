package club.applo.fay.mapper;

import club.applo.fay.FayApplication;
import club.applo.fay.pojo.PayCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.UUID;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-28 14:40
 * @TODO: 插入支付代码
 * ==========================
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FayApplication.class)
@WebAppConfiguration
public class PayCodeMapperTest {
    @Autowired
    PayCodeMapper payCodeMapper;
    @Test
    public void insert() {

        for (int i = 0; i < 100; i++) {
            String s = UUID.randomUUID().toString();
            payCodeMapper.insert(new PayCode(s.replaceAll("-",""),Byte.parseByte("1"),System.currentTimeMillis()+""));
        }
    }
}