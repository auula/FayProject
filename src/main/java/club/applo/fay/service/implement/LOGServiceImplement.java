package club.applo.fay.service.implement;

import club.applo.fay.mapper.UserLOGMapper;
import club.applo.fay.pojo.UserLOG;
import club.applo.fay.service.LOGService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-24 15:42
 * @TODO: 日志实现
 * ==========================
 */
@Service
@Slf4j
public class LOGServiceImplement implements LOGService {
    @Autowired
    UserLOGMapper Ulog;

    @Override
    public void loginSuccess(long uid, String IP, Long time) {
        Ulog.insert(new UserLOG(uid,IP,buildGreenText("登录到系统成功!"),time.toString()));
    }

    @Override
    public void loginFail(long uid, String IP, Long time) {
        Ulog.insert(new UserLOG(uid,IP,buildRedText("登录到系统失败!"),time.toString()));
    }

    @Override
    public void topUP(long uid,String IP,Long time) {
        Ulog.insert(new UserLOG(uid,IP,buildBlueText("续费成功!"),time.toString()));
    }

    @Override
    public void resetPWD(long uid, String IP, Long time) {
        Ulog.insert(new UserLOG(uid,IP,buildRedText("重置密码!"),time.toString()));
    }
    @Override
    public List<UserLOG> getLOGData(long uid) {
        return Ulog.selectByUid(uid);
    }

    private String buildRedText(String srt){
        return String.format(new String("\uFEFF<span style=\"color: red;\">%s</span>"), srt);
    }

    private String buildBlueText(String srt){
        return String.format(new String("\uFEFF<span style=\"color: deepskyblue;\">%s</span>"), srt);
    }

    private String buildGreenText(String srt){
        return String.format(new String("\uFEFF<span style=\"color: green;\">%s</span>"), srt);
    }

}
