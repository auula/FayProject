package club.applo.fay.service;

import club.applo.fay.pojo.UserInfo;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-26 13:46
 * @TODO: 注册接口
 * ==========================
 */
public interface RegisterService {
    //拿数据去注册
    boolean register(UserInfo userInfo);
}
