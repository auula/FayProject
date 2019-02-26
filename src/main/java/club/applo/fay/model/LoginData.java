package club.applo.fay.model;

import lombok.Data;

import java.io.Serializable;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @author: ding
 * @email：coding1618@gmail.com
 * @date: 2018-12-08 15:12
 * @version：1.0
 * @Github：https://github.com/coding1618
 * @TODO: 登录表单数据
 * ==========================
 */
@Data
public class LoginData implements Serializable {

    private static final long serialVersionUID = -100472103525439247L;

    private String email;

    private String password;

    private String code;


}
