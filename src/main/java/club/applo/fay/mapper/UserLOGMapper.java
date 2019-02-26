package club.applo.fay.mapper;

import club.applo.fay.pojo.UserLOG;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserLOGMapper {
    int deleteByPrimaryKey(Long logid);

    int insert(UserLOG record);

    List<UserLOG> selectByUid(long uid);

    int insertSelective(UserLOG record);

    UserLOG selectByPrimaryKey(Long logid);

    int updateByPrimaryKeySelective(UserLOG record);

    int updateByPrimaryKey(UserLOG record);
}