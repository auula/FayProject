package club.applo.fay.service.implement;

import club.applo.fay.mapper.PayCodeMapper;
import club.applo.fay.mapper.UserInfoMapper;
import club.applo.fay.pojo.PayCode;
import club.applo.fay.pojo.UserInfo;
import club.applo.fay.service.GoodsService;
import club.applo.fay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-28 15:22
 * @TODO: 支持实现
 * ==========================
 */
@Service
public class PayServiceImplement implements PayService {

    @Autowired
    PayCodeMapper payCodeMapper;

    @Autowired
    GoodsService goodsService;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public boolean topUP(long uid,String paycode) {
        PayCode effective = payCodeMapper.isEffective(paycode);
        if (effective != null) {
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(uid);
            userInfo.setDueTime((System.currentTimeMillis()+Long.parseLong("2592000000"))+"");
            String key = goodsService.getKey();

            if (key == null) {
                return false;
            }
            //移除这个卡密已经被使用了
            int i = payCodeMapper.removePayCode(effective.getPid());
            if(i==0){
                return false;
            }
            userInfo.setNowKey(key);
            userInfoMapper.updateByPrimaryKey(userInfo);
            return true;
        }
        return false;
    }
}
