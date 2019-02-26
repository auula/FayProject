package club.applo.fay.service;

import club.applo.fay.model.LoginData;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @author: ding
 * @email：coding1618@gmail.com
 * @date: 2018-12-08 15:24
 * @version：1.0
 * @Github：https://github.com/coding1618
 * @TODO: 登录业务接口
 * ==========================
 */
public interface LoginService {

    //验证登录
    boolean verifyLogin(LoginData loginData);

}
