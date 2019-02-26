package club.applo.fay.service.implement;

import club.applo.fay.model.MailInfo;
import club.applo.fay.service.EmailService;
import club.applo.fay.utils.EmailUtil;
import club.applo.fay.utils.TimeUtil;
import org.springframework.stereotype.Service;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-31 15:39
 * @TODO: 邮件业务实现
 * ==========================
 */
@Service
public class EmailServiceImplement implements EmailService {
    @Override
    public void sendRegisterEMail(String toEmail) {
        MailInfo mailInfo = EmailUtil.buildMailInfo(toEmail, "Fay你已经注册成功!", RegHTML());
        EmailUtil.sendEmail(mailInfo);
    }

    @Override
    public void sendRestPWDEMail(String toEmail,String str) {
        MailInfo mailInfo = EmailUtil.buildMailInfo(toEmail, "Fay重置密码邮件!", PWDHTML(str));
        EmailUtil.sendEmail(mailInfo);
    }

    @Override
    public void sendOverdueEMail(String toEmail) {
        MailInfo mailInfo = EmailUtil.buildMailInfo(toEmail, "Fay你的账户已经过期!", DueHTML());
        EmailUtil.sendEmail(mailInfo);
    }

    @Override
    public void sendKeyEMail(String toEmail, String now_key) {
        MailInfo mailInfo = EmailUtil.buildMailInfo(toEmail, "Fay你的连接秘钥!", KeyHTML(now_key));
        EmailUtil.sendEmail(mailInfo);
    }

    private static String RegHTML(){
        return "\uFEFF\n" +
                "<div style=\"text-align: center;font-size: 16px;font-weight:bold;background-color: #4caf50;\n" +
                "    color: #fff;\n" +
                "    overflow: hidden;\n" +
                "    padding-top: 48px;\n" +
                "    position: relative;-webkit-transition: background-color .3s cubic-bezier(.4, 0, .2, 1), color .3s cubic-bezier(.4, 0, .2, 1);\n" +
                "\t\ttransition: background-color .3s cubic-bezier(.4, 0, .2, 1), color .3s cubic-bezier(.4, 0, .2, 1);\">\n" +
                "\t<h1>您好！你已经注册成功！请开始使用吧~</h1>\n" +
                "\n" +
                "</div>\n" +
                "<p style=\"text-align: center;\">"+TimeUtil.getStringDate() +"</p>\n";
    }
    private static String PWDHTML(String str){
        return "\uFEFF\n" +
                "<div style=\"text-align: center;font-size: 12px;font-weight:bold;background-color: #4caf50;\n" +
                "    color: #fff;\n" +
                "    overflow: hidden;\n" +
                "    padding-top: 48px;\n" +
                "    position: relative;-webkit-transition: background-color .3s cubic-bezier(.4, 0, .2, 1), color .3s cubic-bezier(.4, 0, .2, 1);\n" +
                "\t\ttransition: background-color .3s cubic-bezier(.4, 0, .2, 1), color .3s cubic-bezier(.4, 0, .2, 1);\">\n" +
                "\t<h1>您好！系统邮件为你重置密码！请复制登录去后台修改密码！系统重置密码为:"+str+"</h1>\n" +
                "\n" +
                "</div>\n" +
                "<p style=\"text-align: center;\">"+TimeUtil.getStringDate() +"</p>\n";
    }
    private static String DueHTML(){
        return "\uFEFF\n" +
                "<div style=\"text-align: center;font-size: 16px;font-weight:bold;background-color: #4caf50;\n" +
                "    color: #fff;\n" +
                "    overflow: hidden;\n" +
                "    padding-top: 48px;\n" +
                "    position: relative;-webkit-transition: background-color .3s cubic-bezier(.4, 0, .2, 1), color .3s cubic-bezier(.4, 0, .2, 1);\n" +
                "\t\ttransition: background-color .3s cubic-bezier(.4, 0, .2, 1), color .3s cubic-bezier(.4, 0, .2, 1);\">\n" +
                "\t<h1>您好！你账户key已经过期！请你续费!</h1>\n" +
                "\n" +
                "</div>\n" +
                "<p style=\"text-align: center;\">"+TimeUtil.getStringDate() +"</p>\n";
    }
    private static String KeyHTML(String key){
        return "\uFEFF\n" +
                "<div style=\"text-align: center;font-size: 12px;font-weight:bold;background-color: #4caf50;\n" +
                "    color: #fff;\n" +
                "    overflow: hidden;\n" +
                "    padding-top: 48px;\n" +
                "    position: relative;-webkit-transition: background-color .3s cubic-bezier(.4, 0, .2, 1), color .3s cubic-bezier(.4, 0, .2, 1);\n" +
                "\t\ttransition: background-color .3s cubic-bezier(.4, 0, .2, 1), color .3s cubic-bezier(.4, 0, .2, 1);\">\n" +
                "\t<h1>您好！你账户key:"+key+"！请你妥善保管!</h1>\n" +
                "\n" +
                "</div>\n" +
                "<p style=\"text-align: center;\">"+TimeUtil.getStringDate() +"</p>\n";
    }
}
