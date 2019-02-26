package club.applo.fay.controller;

import club.applo.fay.model.JsonData;
import club.applo.fay.pojo.UserInfo;
import club.applo.fay.service.RegisterService;
import club.applo.fay.service.UserService;
import club.applo.fay.utils.AccountValidatorUtil;
import club.applo.fay.utils.MD5;
import club.applo.fay.utils.ShareCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-26 13:24
 * @TODO: 注册控制器
 * ==========================
 */
@Slf4j
@RestController
public class RegisterController {
    @Autowired
    HttpServletRequest request;

    @Autowired
    RegisterService registerService;

    @Autowired
    UserService userService;

    @PostMapping("{time}/user/register")
    public JsonData Register(String email, String password, String code, String icode, @PathVariable long time) {
        long l = System.currentTimeMillis();
        //如果提交表单时间是在当前系统时间的前20秒提交就处理,防止请求伪造,另外拦截器验证token
        if (!(time > (l - 30000L) && time < l)) {
            return JsonData.error("客户端时间不一致,表单被拒绝!");
        }
        if (!AccountValidatorUtil.isEmail(email) || email == null) {
            return JsonData.error("邮箱不合法!");
        }
        if (!AccountValidatorUtil.isPassword(password) || password == null) {
            return JsonData.error("密码强度不安全!");
        }
        if (icode == null) {
            return JsonData.error("邀请码不知道可以填写0000!");
        }
        if (!userService.verifyEmail(email)) {
            return JsonData.error("这个邮箱已经注册!");
        }
        //获取之前存储在session中的验证码值
        String captcha = request.getSession().getAttribute("captcha").toString();
        //验证验证码
        if (code.equals(captcha)) {
            //验证码正确就去执行登录业务
            String ntime = System.currentTimeMillis() + "";
            //邀请码
            String s = ShareCodeUtil.toSerialCode(System.currentTimeMillis());
            UserInfo userInfo = new UserInfo(email,MD5.GetMD5Code(password), ntime, "null", ntime, Byte.valueOf("1"), s, ntime);
            return registerService.register(userInfo) ? JsonData.succes("注册成功!") : JsonData.error("注册失败!");
        } else {
            //错误了直接返回
            return JsonData.error("验证码错误!");
        }

    }


}
