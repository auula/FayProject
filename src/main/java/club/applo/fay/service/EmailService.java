package club.applo.fay.service;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-28 17:24
 * @TODO: 邮件服务接口
 * ==========================
 */
public interface EmailService {
    void sendRegisterEMail(String toEmail);
    void sendRestPWDEMail(String toEmail,String str);
    void sendOverdueEMail(String toEmail);
    void sendKeyEMail(String toEmail,String now_key);
}
