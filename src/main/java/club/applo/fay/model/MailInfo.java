package club.applo.fay.model;

import org.apache.commons.mail.EmailAttachment;

import java.util.ArrayList;
import java.util.List;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-31 14:34
 * @TODO: 邮箱模型
 * ==========================
 */
public class MailInfo {
    // 收件人
    private List<String> toAddress = null;
    // 抄送人地址
    private List<String> ccAddress = null;
    // 密送人
    private List<String> bccAddress = null;
    // 附件信息
    private List<EmailAttachment> attachments = null;
    // 邮件主题
    private String subject;
    // 邮件的文本内容
    private String content;



    public List<String> getToAddress() {
        return toAddress;
    }

    public void addToAddress(String toAddress) {
        this.toAddress.add(toAddress);
    }

    public void addToAddress(List<String> toAddress) {
        this.toAddress.addAll(toAddress);
    }

    public void addCcAddress(List<String> ccAddress) {
        if (null != ccAddress && ccAddress.size() > 0)
            this.ccAddress.addAll(ccAddress);
    }

    public List<EmailAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<EmailAttachment> attachments) {
        this.attachments = attachments;
    }

    public List<String> getBccAddress() {
        return bccAddress;
    }

    public void setBccAddress(List<String> bccAddress) {
        this.bccAddress = bccAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setToAddress(List<String> toAddress) {
        this.toAddress = toAddress;
    }

    public List<String> getCcAddress() {
        return ccAddress;
    }

    public void setCcAddress(List<String> ccAddress) {
        this.ccAddress = ccAddress;
    }
}
