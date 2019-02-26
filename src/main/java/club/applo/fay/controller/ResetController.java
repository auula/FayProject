package club.applo.fay.controller;

import club.applo.fay.model.JsonData;
import club.applo.fay.pojo.UserInfo;
import club.applo.fay.service.EmailService;
import club.applo.fay.service.UserService;
import club.applo.fay.utils.AccountValidatorUtil;
import club.applo.fay.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-31 16:50
 * @TODO: 重置密码控制器
 * ==========================
 */
@Controller
public class ResetController {
    @Autowired
    HttpServletRequest request;

    @Autowired
    UserService userService;
    @Autowired
    EmailService emailService;

    @GetMapping("/reset")
    public String resetview() {
        return "reset";
    }

    @ResponseBody
    @PostMapping("/reset/api")
    public JsonData resetAPI(@RequestParam String email, String code) {


        if (!AccountValidatorUtil.isEmail(email) || email == null) {
            return JsonData.error("邮箱不合法!");
        }

        if (userService.verifyEmail(email)) {
            return JsonData.error("这个邮箱没有注册!");
        }

        //获取之前存储在session中的验证码值
        String captcha = request.getSession().getAttribute("captcha").toString();
        //验证验证码
        if (code.equals(captcha)) {
            //验证码正确就去执行登录业务
            UserInfo userInfo = userService.selectByEmail(email);
            String resetstr = UUID.randomUUID().toString().replaceAll("-","");
            emailService.sendRestPWDEMail(email,resetstr);
            boolean b = userService.updatePWD(userInfo.getUid(),MD5.GetMD5Code(resetstr));
            return b ? JsonData.succes("请去目标邮箱检查邮件！") : JsonData.error("重置密码邮件发送失败!");
        } else {
            //错误了直接返回
            return JsonData.error("验证码错误!");
        }

    }
}
