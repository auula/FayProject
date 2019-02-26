package club.applo.fay.model;

import club.applo.fay.utils.ExecUtil;

import java.io.File;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-26 16:40
 * @TODO: 命令实体
 * ==========================
 */
public class Shell {
    private String cmd;
    private File file;

    public Shell() {
        super();
    }

    /**
     * 执行系统命令, 返回执行结果
     *
     * @param cmd
     *            要执行的命令
     */
    public Shell(String cmd) {
        super();
        this.cmd = cmd;
        this.file = null;
    }

    /**
     *
     * @param cmd
     *            命令
     * @param file
     *            在哪个路径执行
     */
    public Shell(String cmd, File file) {
        super();
        this.cmd = cmd;
        this.file = file;
    }

    public String exec() {
        try {
            return ExecUtil.execCMD(cmd, file);
        } catch (Exception e) {
            return e.getMessage();
        }

    }
}
