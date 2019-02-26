package club.applo.fay.config;

import club.applo.fay.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-20 15:06
 * @TODO: 登录拦截器配置类
 * ==========================
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {

    public final static String LOGIN_USER_KEY = "LOGIN_USER_KEY";
    /**
     * 不需要登录拦截的url
     */
    private final String[] notLoginInterceptPaths = {"/", "/error/**", "/login","/register"};
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/system/**").excludePathPatterns(notLoginInterceptPaths);
    }
}
