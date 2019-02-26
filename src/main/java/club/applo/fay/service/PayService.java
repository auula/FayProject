package club.applo.fay.service;

import org.springframework.stereotype.Service;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-28 15:20
 * @TODO: 支付相关接口
 * ==========================
 */

public interface PayService {
    boolean topUP(long uid,String paycode);
}
