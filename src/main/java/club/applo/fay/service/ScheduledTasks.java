package club.applo.fay.service;


/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-27 18:13
 * @TODO: 定时任务接口
 * ==========================
 */

public interface ScheduledTasks {
    /**
     * 每个一小时执行一次过期用户检查
     */
    void OverdueScheduledTasks();
}
