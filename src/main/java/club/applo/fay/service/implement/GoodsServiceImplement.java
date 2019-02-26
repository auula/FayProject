package club.applo.fay.service.implement;

import club.applo.fay.mapper.GoodsInfoMapper;
import club.applo.fay.pojo.GoodsInfo;
import club.applo.fay.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-28 15:47
 * @TODO: 商品
 * ==========================
 */
@Slf4j
@Service
public class GoodsServiceImplement implements GoodsService {

    @Autowired
    GoodsInfoMapper goodsInfoMapper;


    /**
     * 随机获取一个key有效的
     * @return
     */
    @Override
    public String getKey() {
        GoodsInfo key = goodsInfoMapper.getKey();
        if (key == null) {
            return "null";
        }
        int i = goodsInfoMapper.removeKey(key.getGid());
        log.info(i+"");
        return i > 0 ? key.getGoodsKey() : null;
    }
}
