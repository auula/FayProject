package club.applo.fay.utils;

import lombok.extern.slf4j.Slf4j;
import org.hyperic.sigar.*;

import java.text.DecimalFormat;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-23 13:58
 * @TODO: 系统工具类
 * ==========================
 */
@Slf4j
public class SystemUtil {


    private static Sigar sigar = null;
    private static DecimalFormat df = new DecimalFormat(".00");

    /**
     * 获取负载百分比
     * @return
     * @throws SigarException
     */
    private static String getLoad() throws SigarException {
        CpuPerc perc = sigar.getCpuPerc();
        //获取当前cpu的占用率
        return CpuPerc.format(perc.getCombined()).replaceAll("%","");
    }

    /**
     * @Description: CPU占用百分比
     * @param:
     * @return: 当前的CPU占用百分比
     * @Author: Ding / 2018/12/23 14:40
     */
    private static String getCpuPerc() throws SigarException {
        CpuPerc cpuList[] = null;
        cpuList = sigar.getCpuPercList();
        if (cpuList == null) {
            return "0";
        }
        //不管几个CPU，就获取第一个CPU的使用频率
        return CpuPerc.format(cpuList[0].getCombined()).replaceAll("%","");
    }

    /**
     * @Description: 获取系统内存使用率
     * @param:
     * @return: 内存使用率
     * @Author: Ding / 2018/12/23 14:40
     */
    private static String getFreePercent() throws SigarException {
        Mem mem = sigar.getMem();
        if (mem == null) {
            return "0";
        }
        //只能保留2位小数
        return df.format(mem.getUsedPercent());
    }
    /**
     * @Description: io使用率
     * @param:
     * @return: 使用率
     * @Author: Ding / 2018/12/23 14:39
     */
    private static String getIO() throws SigarException {
        double usePercent = 0D;
        FileSystem fslist[] = sigar.getFileSystemList();
        for (int i = 0; i < fslist.length; i++) {
            FileSystem fs = fslist[i];
            FileSystemUsage usage = null;
            usage = sigar.getFileSystemUsage(fs.getDirName());
            switch (fs.getType()) {
                case 0: // TYPE_UNKNOWN ：未知
                    break;
                case 1: // TYPE_NONE
                    break;
                case 2: // TYPE_LOCAL_DISK : 本地硬盘
                    // 文件系统资源的利用率
                    usePercent = usage.getUsePercent() * 100D;
                    break;
                case 3:// TYPE_NETWORK ：网络
                    break;
                case 4:// TYPE_RAM_DISK ：闪存
                    break;
                case 5:// TYPE_CDROM ：光驱
                    break;
                case 6:// TYPE_SWAP ：页面交换
                    break;
            }
        }
        return df.format(usePercent).replaceAll("%","");
    }

    public static String[] build(){
        sigar = new Sigar();
        String[] data =new String[4];
        try {
            data[0] = getCpuPerc();
            data[1] = getFreePercent();
            data[2] = getIO();
            data[3] = getLoad();
        } catch (SigarException e) {
            log.error("获取系统硬件参数异常!{}",e.getMessage());
        }
        return data;
    }
}
