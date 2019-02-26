package club.applo.fay.service;

import club.applo.fay.pojo.UserLOG;

import java.util.List;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-24 15:10
 * @TODO: 日志Service
 * ==========================
 */
public interface LOGService {
    void loginSuccess(long uid,String IP,Long time);
    void loginFail(long uid,String IP,Long time);
    void topUP(long uid,String IP,Long time);
    void resetPWD(long uid,String IP,Long time);
    List<UserLOG> getLOGData(long uid);
}
