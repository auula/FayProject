package club.applo.fay.controller;

import club.applo.fay.config.LoginConfig;
import club.applo.fay.model.JsonData;
import club.applo.fay.pojo.UserInfo;
import club.applo.fay.pojo.UserLOG;
import club.applo.fay.service.LOGService;
import club.applo.fay.utils.SystemUtil;
import lombok.extern.slf4j.Slf4j;
import org.hyperic.sigar.SigarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-20 17:08
 * @TODO: 系统核心操作页面
 * ==========================
 */
@Slf4j
@Controller
@RequestMapping("/system")
public class SystemViewController {


    @GetMapping("/view/{page}")
    public String getView(@PathVariable String page,Model model) {
        model.addAttribute("ok","ok");
        return "view/" + page;
    }



}



