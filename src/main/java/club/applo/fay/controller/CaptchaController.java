package club.applo.fay.controller;


import club.applo.fay.utils.TimeUtil;
import com.wf.captcha.Captcha;
import com.wf.captcha.ChineseGifCaptcha;
import com.wf.captcha.SpecCaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;


/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @author: ding
 * @email：coding1618@gmail.com
 * @date: 2018-12-08 14:20
 * @version：1.0
 * @Github：https://github.com/coding1618
 * @TODO: 验证码控制器
 * ==========================
 */
@Slf4j
@Controller
public class CaptchaController {


    /**
     * <p>验证码生成</p>
     *
     * @param time     时间戳防止缓存
     * @param request  session保存验证码
     * @param response io流输出验证码
     */
    @GetMapping("{time}/captcha")
    public void newCaptcha(@PathVariable long time, HttpServletRequest request, HttpServletResponse response) {
        long l = TimeUtil.nowTimeMillis();
        //如果提交表单时间是在当前系统时间的前10秒提交就处理,防止请求伪造
        if (!(time > (l - 10000L) && time < l)) {
            log.info(l + "请求已经超时!");
            return;
        }
        // 三个参数分别为宽、高、位数
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 30, 4);
        // 设置字体
        // 设置字体
        // 生成的验证码
        specCaptcha.setFont(new Font("Verdana", Font.PLAIN, 24));  // 有默认字体，可以不用设置

        // 设置类型，纯数字、纯字母、字母数字混合
        specCaptcha.setCharType(Captcha.TYPE_ONLY_NUMBER);

        // 生成的验证码
        String code = specCaptcha.text();

        HttpSession session = request.getSession();
        session.setAttribute("captcha", code);
        log.info(session.getAttribute("captcha").toString());
        response.setHeader("Content-Type", " image/jpg");
        try {
            // 输出图片流
            specCaptcha.out(response.getOutputStream());
        } catch (IOException e) {
            log.error("验证码输出错误！{}", e.getMessage());
        }
    }

}
