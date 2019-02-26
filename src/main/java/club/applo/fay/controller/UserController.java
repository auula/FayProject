package club.applo.fay.controller;

import club.applo.fay.model.JsonData;
import club.applo.fay.pojo.UserInfo;
import club.applo.fay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @author: ding
 * @email：coding1618@gmail.com
 * @date: 2018-12-18 20:04
 * @version：1.0
 * @Github：https://github.com/coding1618
 * @TODO: 用户控制器
 * ==========================
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getALL")
    public JsonData getAllUsers(){
        List<UserInfo> userInfos = userService.selectAllUsers();
        return JsonData.succes("👌查询成功!").addData(userInfos.size()+",个用户",userInfos);
    }
}
