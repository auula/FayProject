package club.applo.fay.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @author: ding
 * @email：coding1618@gmail.com
 * @date: 2018-12-18 21:12
 * @version：1.0
 * @Github：https://github.com/coding1618
 * @TODO: 视图配置
 * ==========================
 */
@Configuration
public class ViewConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/system/main").setViewName("main/main");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/login").setViewName("index");
    }
}
