package club.applo.fay.pojo;

public class PayCode {
    private Long pid;

    private String payCode;

    private Byte status;

    private String createTime;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode == null ? null : payCode.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public PayCode(String payCode, Byte status, String createTime) {
        this.payCode = payCode;
        this.status = status;
        this.createTime = createTime;
    }

    public PayCode() {
    }
}