package club.applo.fay.controller;

import club.applo.fay.model.JsonData;
import club.applo.fay.model.LoginData;
import club.applo.fay.service.LoginService;
import club.applo.fay.utils.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @author: ding
 * @email：coding1618@gmail.com
 * @date: 2018-12-08 15:08
 * @version：1.0
 * @Github：https://github.com/coding1618
 * @TODO: 登录验证控制器
 * ==========================
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    HttpServletRequest request;



    @PostMapping("{time}/user/login")
    public JsonData verifyLogin(LoginData loginData,@PathVariable long time) {
        long l = TimeUtil.nowTimeMillis();
        //如果提交表单时间是在当前系统时间的前20秒提交就处理,防止请求伪造,另外拦截器验证token
        if (!(time > (l - 20000L) && time < l)) {
            return JsonData.error("请求超时,表单被拒绝!");
        }
        try {
            for (Field f : loginData.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                //判断字段是否为空，并且对象属性中的基本都会转为对象类型来判断
                if (f.get(loginData) == null) {
                    //这里可以给空字段初始化，及其他操作
                    return JsonData.error("表单所有参数不能为空!");
                }
            }
        } catch (IllegalAccessException e) {
            log.error("表单参数判断校验失败!{}", e.getStackTrace());
            return JsonData.error("表单参数判断校验失败!");
        }
        //获取之前存储在session中的验证码值
        String captcha = request.getSession().getAttribute("captcha").toString();
        //验证验证码
        if (loginData.getCode().equals(captcha)) {
            //验证码正确就去执行登录业务
            return loginService.verifyLogin(loginData) ? JsonData.succes("登录成功!") : JsonData.error("登录邮箱账户或者账户密码错误!请仔细检查！");
        } else {
            //错误了直接返回
            return JsonData.error("验证码错误!");
        }

    }


}
