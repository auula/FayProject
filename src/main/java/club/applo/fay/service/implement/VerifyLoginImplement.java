package club.applo.fay.service.implement;

import club.applo.fay.config.LoginConfig;
import club.applo.fay.mapper.UserInfoMapper;
import club.applo.fay.model.LoginData;
import club.applo.fay.pojo.UserInfo;
import club.applo.fay.service.LOGService;
import club.applo.fay.service.LoginService;
import club.applo.fay.utils.IPAddressUtil;
import club.applo.fay.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @author: ding
 * @email：coding1618@gmail.com
 * @date: 2018-12-08 15:30
 * @version：1.0
 * @Github：https://github.com/coding1618
 * @TODO: 登录业务实现
 * ==========================
 */
@Service
public class VerifyLoginImplement implements LoginService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    HttpServletRequest request;

    @Autowired
    LOGService logService;

    @Override
    public boolean verifyLogin(LoginData loginData) {
        UserInfo userInfo = userInfoMapper.selectByEmailAndPassword(loginData.getEmail(), MD5.GetMD5Code(loginData.getPassword()));
        if (userInfo != null) {
            HttpSession session = request.getSession();
            session.setAttribute(LoginConfig.LOGIN_USER_KEY,userInfo);
            //记录日志操作
            logService.loginSuccess(userInfo.getUid(),IPAddressUtil.getIpAddr(request),System.currentTimeMillis());
            return true;
        }
        //登录失败
        UserInfo userInfo1 = userInfoMapper.selectByEmail(loginData.getEmail());
        if(userInfo1 != null){
            logService.loginFail(userInfo1.getUid(),IPAddressUtil.getIpAddr(request),System.currentTimeMillis());
        }
        return false;
    }
}
