package club.applo.fay.pojo;

public class UserInfo {
    private Long uid;

    private String email;

    private String password;

    private String createTime;

    private String nowKey;

    private String dueTime;

    private Byte status;

    private String inviteCode;

    private String updateTime;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getNowKey() {
        return nowKey;
    }

    public void setNowKey(String nowKey) {
        this.nowKey = nowKey == null ? null : nowKey.trim();
    }

    public String getDueTime() {
        return dueTime;
    }

    public void setDueTime(String dueTime) {
        this.dueTime = dueTime == null ? null : dueTime.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode == null ? null : inviteCode.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public UserInfo() {
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uid=" + uid +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createTime='" + createTime + '\'' +
                ", nowKey='" + nowKey + '\'' +
                ", dueTime='" + dueTime + '\'' +
                ", status=" + status +
                ", inviteCode='" + inviteCode + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }

    public UserInfo(String email, String password, String createTime, String nowKey, String dueTime, Byte status, String inviteCode, String updateTime) {
        this.email = email;
        this.password = password;
        this.createTime = createTime;
        this.nowKey = nowKey;
        this.dueTime = dueTime;
        this.status = status;
        this.inviteCode = inviteCode;
        this.updateTime = updateTime;
    }
}