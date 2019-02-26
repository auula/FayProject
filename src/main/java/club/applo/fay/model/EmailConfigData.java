package club.applo.fay.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.io.Serializable;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @author: ding
 * @email：coding1618@gmail.com
 * @date: 2018-12-18 20:39
 * @version：1.0
 * @Github：https://github.com/coding1618
 * @TODO: 邮箱服务器配置
 * ==========================
 */
@Component
@Data
public class EmailConfigData implements Serializable {

    private static final long serialVersionUID = -7699998496557693528L;

    @Value("${Email.host}")
    private String Host;

    @Value("${Email.port}")
    private String Port;

    @Value("${Email.account}")
    private String Account;

    @Value("${Email.password}")
    private String Password;


}
