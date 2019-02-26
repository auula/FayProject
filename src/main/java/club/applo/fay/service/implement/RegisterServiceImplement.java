package club.applo.fay.service.implement;

import club.applo.fay.mapper.UserInfoMapper;
import club.applo.fay.pojo.UserInfo;
import club.applo.fay.service.EmailService;
import club.applo.fay.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-26 14:04
 * @TODO: 注册接口实现
 * ==========================
 */
@Service
public class RegisterServiceImplement implements RegisterService {

    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    EmailService emailService;

    @Override
    public boolean register(UserInfo userInfo) {
        if (userInfo == null) {
            return false;
        }
        int insert = userInfoMapper.insert(userInfo);
        emailService.sendRegisterEMail(userInfo.getEmail());
        return insert > 0 ? true : false;
    }
}
