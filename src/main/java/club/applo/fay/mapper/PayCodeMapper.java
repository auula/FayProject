package club.applo.fay.mapper;

import club.applo.fay.pojo.PayCode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayCodeMapper {

    int deleteByPrimaryKey(Long pid);

    int insert(PayCode record);

    //检查支付码是否有效
    PayCode isEffective(String payCode);
    //使用了就移除
    int removePayCode(long pid);
    int insertSelective(PayCode record);

    PayCode selectByPrimaryKey(Long pid);

    int updateByPrimaryKeySelective(PayCode record);

    int updateByPrimaryKey(PayCode record);
}