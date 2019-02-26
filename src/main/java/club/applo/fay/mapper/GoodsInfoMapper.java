package club.applo.fay.mapper;

import club.applo.fay.pojo.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsInfoMapper {

    int deleteByPrimaryKey(Long gid);

    int insert(GoodsInfo record);

    GoodsInfo getKey();
    int removeKey(long gid);
    int insertSelective(GoodsInfo record);

    GoodsInfo selectByPrimaryKey(Long gid);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);
}