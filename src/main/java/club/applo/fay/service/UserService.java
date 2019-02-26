package club.applo.fay.service;

import club.applo.fay.pojo.UserInfo;

import java.util.List;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @author: ding
 * @email：coding1618@gmail.com
 * @date: 2018-12-18 18:45
 * @version：1.0
 * @Github：https://github.com/coding1618
 * @TODO: 用户Service接口
 * ==========================
 */
public interface UserService {


    UserInfo selectByUid(Long uid);

    int insertUser(UserInfo userInfo);

    List<UserInfo> selectAllUsers();

    UserInfo verifyExpirationTime(long uid);

    boolean verifyEmail(String email);

    UserInfo selectByEmail(String m);
    boolean updatePWD(long uid,String pwd);
}
