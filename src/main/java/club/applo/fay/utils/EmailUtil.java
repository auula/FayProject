package club.applo.fay.utils;


import club.applo.fay.model.MailInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.util.ArrayList;
import java.util.List;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-31 14:23
 * @TODO: 邮件工具类
 * ==========================
 */
@Slf4j
public class EmailUtil {


	//邮箱
	private static String mailServerHost = "mail.applo.club";
	private static String mailSenderAddress = "admin@applo.club";
	private static String mailSenderNick = "Fay平台管理员账号";
	private static String mailSenderUsername = "admin@applo.club";
	private static String mailSenderPassword = "dingshuo.6";



	public static  MailInfo buildMailInfo(String TO,String subject,String content){
		MailInfo mailInfo= new MailInfo();
		List<String> toList = new ArrayList<String>();
		toList.add(TO);
		mailInfo.setToAddress(toList);//收件人
		mailInfo.setSubject(subject);
		mailInfo.setContent(content);
		return mailInfo;
	}

	/**
	 * 发送 邮件方法 (支持Html格式，支持附件)
	 *
	 * @return void
	 */
	public static void sendEmail(MailInfo mailInfo) {

		try {
			HtmlEmail email = new HtmlEmail();
			// 配置信息
			email.setHostName(mailServerHost);
			email.setFrom(mailSenderAddress,mailSenderNick);
			email.setAuthentication(mailSenderUsername,mailSenderPassword);
			email.setCharset("UTF-8");
			email.setSubject(mailInfo.getSubject());
			email.setHtmlMsg(mailInfo.getContent());

			// 添加附件
			List<EmailAttachment> attachments = mailInfo.getAttachments();
			if (null != attachments && attachments.size() > 0) {
				for (int i = 0; i < attachments.size(); i++) {
					email.attach(attachments.get(i));
				}
			}

			// 收件人
			List<String> toAddress = mailInfo.getToAddress();
			if (null != toAddress && toAddress.size() > 0) {
				for (int i = 0; i < toAddress.size(); i++) {
					email.addTo(toAddress.get(i));
				}
			}
			// 抄送人
			List<String> ccAddress = mailInfo.getCcAddress();
			if (null != ccAddress && ccAddress.size() > 0) {
				for (int i = 0; i < ccAddress.size(); i++) {
					email.addCc(ccAddress.get(i));
				}
			}
			//邮件模板 密送人
			List<String> bccAddress = mailInfo.getBccAddress();
			if (null != bccAddress && bccAddress.size() > 0) {
				for (int i = 0; i < bccAddress.size(); i++) {
					email.addBcc(ccAddress.get(i));
				}
			}
			email.send();
		} catch (EmailException e) {
			log.error("邮件发送异常{}",e.getMessage());
		}

	}

}
