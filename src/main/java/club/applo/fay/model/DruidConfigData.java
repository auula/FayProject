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
 * @date: 2018-12-18 12:41
 * @version：1.0
 * @Github：https://github.com/coding1618
 * @TODO: DRUID配置参数
 * ==========================
 */
//@ConfigurationProperties(prefix = "user")
@Component
@Data
public class DruidConfigData implements Serializable {
    private static final long serialVersionUID = -2300472103525431147L;

    @Value("${DruidInfo.allowIP}")
    private String allowIP;

    @Value("${DruidInfo.denyIP}")
    private String denyIP;

    @Value("${DruidInfo.user}")
    private String user;

    @Value("${DruidInfo.passwd}")
    private String passwd;

    @Value("${DruidInfo.resetEnable}")
    private String resetEnable;

    @Value("${DruidInfo.contextPath}")
    private String contextPath;

}
