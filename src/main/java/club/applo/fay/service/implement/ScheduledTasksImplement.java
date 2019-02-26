package club.applo.fay.service.implement;

import club.applo.fay.mapper.UserInfoMapper;
import club.applo.fay.pojo.UserInfo;
import club.applo.fay.service.EmailService;
import club.applo.fay.service.ScheduledTasks;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-27 18:18
 * @TODO: 定时任务实现
 * ==========================
 */
@Slf4j
@Service
@Component
public class ScheduledTasksImplement implements ScheduledTasks {

    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    EmailService emailService;

    @Override
    @Scheduled(fixedRate = 30000)//30秒
    public void OverdueScheduledTasks() {
        long l = System.currentTimeMillis();
        List<UserInfo> userInfos = userInfoMapper.selectByExpirationUser(System.currentTimeMillis()+"");
        for (UserInfo userInfo : userInfos) {
            userInfoMapper.updateUserKey(userInfo.getUid());
            emailService.sendOverdueEMail(userInfo.getEmail());
        }
        long end = System.currentTimeMillis();
        log.info("用户key过期ScheduledTask任务完成{}ms",end-l);
    }
}
