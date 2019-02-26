package club.applo.fay.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-20 14:59
 * @TODO: 登录拦截器
 * ==========================
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object login_user_key = request.getSession().getAttribute("LOGIN_USER_KEY");
        if (login_user_key == null || login_user_key.equals("")) {
            response.sendRedirect("/");
            return false;
        }
        return true;
    }
}
