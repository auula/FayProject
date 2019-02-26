package club.applo.fay.pojo;

public class UserLOG {
    private Long logid;

    private String loginIp;

    private Long uid;

    private String event;

    private String updateTime;

    public UserLOG(Long uid,String loginIp, String event, String updateTime) {
        this.loginIp = loginIp;
        this.uid = uid;
        this.event = event;
        this.updateTime = updateTime;
    }

    public UserLOG() {
    }

    @Override
    public String toString() {
        return "UserLOG{" +
                "logid=" + logid +
                ", loginIp='" + loginIp + '\'' +
                ", uid=" + uid +
                ", event='" + event + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }

    public Long getLogid() {
        return logid;
    }

    public void setLogid(Long logid) {
        this.logid = logid;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event == null ? null : event.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}