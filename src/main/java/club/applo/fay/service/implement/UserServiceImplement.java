package club.applo.fay.service.implement;

import club.applo.fay.mapper.UserInfoMapper;
import club.applo.fay.pojo.UserInfo;
import club.applo.fay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018/12/19 - 14:20
 * @TODO: 用户操作业务接口实现
 * ==========================
 */
@Service
public class UserServiceImplement implements UserService {


    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public int insertUser(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }

    /**
     * @Description: 使用说明
     * @param: 没有参数
     * @return: 用户list
     * @Author: Ding / 2018/12/19 14:15
     */
    @Override
    public List<UserInfo> selectAllUsers() {
        return userInfoMapper.selectAllUsers();
    }


    @Override
    public UserInfo selectByUid(Long uid) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(uid);
        return userInfo != null ? userInfo : null;
    }

    @Override
    public UserInfo verifyExpirationTime(long uid) {
        Map<String, Object> map = new HashMap();
        map.put("UID", uid);
        map.put("nowTime", System.currentTimeMillis() + "");
        UserInfo userInfo = userInfoMapper.selectByExpirationTime(map);
        if (userInfo != null) {
            return userInfo;
        }
        return null;
    }

    /**
     * 检查用户邮箱是否存在
     *
     * @param email
     * @return false表示不存在
     */
    @Override
    public boolean verifyEmail(String email) {
        UserInfo userInfo = userInfoMapper.selectByEmail(email);
        return userInfo != null ? false : true;
    }

    @Override
    public UserInfo selectByEmail(String m) {
        UserInfo userInfo = userInfoMapper.selectByEmail(m);
        if (userInfo==null){
            return null;
        }
        return userInfo;
    }

    @Override
    public boolean updatePWD(long uid, String pwd) {
        Map<String,Object> map = new HashMap<>();
        map.put("uid",uid);
        map.put("pwd",pwd);
        int i = userInfoMapper.updatePWD(map);
        return i > 0 ? true : false;
    }
}
