package club.applo.fay.controller;

import club.applo.fay.config.LoginConfig;
import club.applo.fay.model.JsonData;
import club.applo.fay.pojo.PayCode;
import club.applo.fay.pojo.UserInfo;
import club.applo.fay.pojo.UserLOG;
import club.applo.fay.service.EmailService;
import club.applo.fay.service.LOGService;
import club.applo.fay.service.PayService;
import club.applo.fay.service.UserService;
import club.applo.fay.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-26 20:01
 * @TODO: 系统API控制器
 * ==========================
 */
@Slf4j
@Controller
@RequestMapping("/system/api")
public class SystemAPIController {

    @Autowired
    HttpServletRequest request;

    @Autowired
    LOGService logService;

    @Autowired
    UserService userService;

    @Autowired
    PayService payService;

    @Autowired
    EmailService emailService;

    @Autowired
    HttpServletResponse response;

    @ResponseBody
    @PostMapping("/getStatus")
    public JsonData outServerInfo() {
        return JsonData.succes("ServerInfo").addData("SI", SystemUtil.build());
    }


    @ResponseBody
    @GetMapping("/getlog")
    public JsonData getlog() {
        UserInfo uinfo = (UserInfo) request.getSession().getAttribute(LoginConfig.LOGIN_USER_KEY);
        List<UserLOG> logData = logService.getLOGData(uinfo.getUid());
        System.out.println(logData);
        if (logData != null) {
            return JsonData.succes(uinfo.getEmail()).addData("log",logData);
        }
        return JsonData.error("权限不足!!");
    }
    @ResponseBody
    @PostMapping("/getkey")
    public JsonData getKey(){
        final UserInfo uinfo = (UserInfo) request.getSession().getAttribute(LoginConfig.LOGIN_USER_KEY);
        //获取最新的数据库的数据
        UserInfo userInfoData = userService.selectByUid(uinfo.getUid());
        return JsonData.succes("OK").addData("key",userInfoData.getNowKey());
    }

    @GetMapping("/qrcode/")
    public void QRCode() throws Exception {
        //这里获取的是登录那一刻的用户数据，如果后期变换了千万不要使用这个数据，所以用户登录就直接保存用户登录的uid就好了
        UserInfo uinfo = (UserInfo) request.getSession().getAttribute(LoginConfig.LOGIN_USER_KEY);
        UserInfo userInfo = userService.verifyExpirationTime(uinfo.getUid());
        if (userInfo!=null){
            //查询到了就说明已经过期了，这里代码后期版本需要优化
            QRCodeUtil.generateQRCode("你的账号已经到期!请你续费！Q2420498526!",response);
        }else {
            //获取最新的数据库的数据
            UserInfo userInfoData = userService.selectByUid(uinfo.getUid());
            QRCodeUtil.generateQRCode(userInfoData.getNowKey(),response);
        }
    }

    @ResponseBody
    @GetMapping("/getinfo")
    public JsonData outUserStatus(){
        UserInfo uinfo = (UserInfo) request.getSession().getAttribute(LoginConfig.LOGIN_USER_KEY);
        UserInfo userInfo = userService.selectByUid(uinfo.getUid());
        Map map = new HashMap<String,String>();
        map.put("overdue",userInfo.getDueTime());
        map.put("status",userInfo.getStatus());
        map.put("icode",userInfo.getInviteCode());
        return JsonData.succes(userInfo.getUid()+"").addData("info",map);
    }

    @ResponseBody
    @GetMapping("/topup")
    public JsonData topUP(@RequestParam String paycode){
        log.info(paycode);
        if (paycode == null) {
            return JsonData.error("卡密不能为空！！！");
        }
        UserInfo uinfo = (UserInfo) request.getSession().getAttribute(LoginConfig.LOGIN_USER_KEY);
        boolean b = payService.topUP(uinfo.getUid(), paycode);
        return b ? JsonData.succes("充值成功!重新刷新页面即可看到最新账户信息~") : JsonData.error("这个卡密不存在或者已经被别人使用了哦~~");
    }

    @GetMapping("/logout")
    public void logout() throws IOException {
        request.getSession().removeAttribute(LoginConfig.LOGIN_USER_KEY);
        response.sendRedirect("/");
    }

    @ResponseBody
    @GetMapping("/reset")
    public JsonData reset(@RequestParam String pwd,String reset){

        if (pwd == null) {
            return JsonData.error("请不要乱来");
        }

        if (reset == null) {
            return JsonData.error("请不要乱来");
        }

        if (!AccountValidatorUtil.isPassword(reset) || reset == null) {
            return JsonData.error("密码强度不安全!");
        }
        UserInfo uinfo = (UserInfo) request.getSession().getAttribute(LoginConfig.LOGIN_USER_KEY);

        if (uinfo.getPassword().equals(MD5.GetMD5Code(pwd))) {
            return userService.updatePWD(uinfo.getUid(),MD5.GetMD5Code(reset)) ? JsonData.succes("重置密码成功!") : JsonData.error("重置密码错误!");
        }


        return JsonData.error("原始密码错误！！！");
    }
}
