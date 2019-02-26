package club.applo.fay.model;

import club.applo.fay.FayApplication;
import club.applo.fay.utils.EmailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-20 21:00
 * @TODO: 测试Email
 * ==========================
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FayApplication.class)
@WebAppConfiguration
public class EmailConfigDataTest {

    @Autowired
    EmailConfigData emailConfigData;

    @Test
    public void getString() {
        System.out.println(emailConfigData.toString());
    }

    @Test
    public void sendEmail(){
        MailInfo mailInfo = new MailInfo();
        List<String> toList = new ArrayList<String>();
        toList.add("2420498526@qq.com");



        //添加附件
//        EmailAttachment att = new EmailAttachment();
//        att.setPath("g:\\测试.txt");
//        att.setName("测试.txt");
//        List<EmailAttachment> atts = new ArrayList<EmailAttachment>();
//        atts.add(att);
//        mailInfo.setAttachments(atts);

        mailInfo.setToAddress(toList);//收件人

        mailInfo.setSubject("测试主题");
        mailInfo.setContent("\uFEFF\n" +
                "<div style=\"text-align: center;font-size: 18px;font-weight:bold;background-color: #4caf50;\n" +
                "    color: #fff;\n" +
                "    overflow: hidden;\n" +
                "    padding-top: 48px;\n" +
                "    position: relative;-webkit-transition: background-color .3s cubic-bezier(.4, 0, .2, 1), color .3s cubic-bezier(.4, 0, .2, 1);\n" +
                "\t\ttransition: background-color .3s cubic-bezier(.4, 0, .2, 1), color .3s cubic-bezier(.4, 0, .2, 1);\">\n" +
                "\t<h1>您好！你已经注册成功！</h1>\n" +
                "\n" +
                "</div>\n" +
                "<p style=\"text-align: center;\">2018年12月31日15:30:55</p>\n");

        EmailUtil.sendEmail(mailInfo);
    }
}