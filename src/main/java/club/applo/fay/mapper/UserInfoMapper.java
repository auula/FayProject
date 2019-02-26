package club.applo.fay.mapper;

import club.applo.fay.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018/12/19 - 15:47
 * @TODO: 用户数据交互接口
 * ==========================
 */
@Mapper
public interface UserInfoMapper {

    List<UserInfo> selectAllUsers();

    UserInfo selectByEmailAndPassword(String email,String password);

    UserInfo selectByEmail(String email);

    List<UserInfo> selectByExpirationUser(String nowTime);

    UserInfo selectByExpirationTime(Map hashMap);

    void updateUserKey(Long uid);

    int updatePWD(Map HashMap);

    int deleteByPrimaryKey(Long uid);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long uid);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}