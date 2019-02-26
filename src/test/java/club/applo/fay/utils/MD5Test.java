package club.applo.fay.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-31 20:20
 * @TODO: 类描述
 * ==========================
 */
public class MD5Test {

    @Test
    public void getMD5Code() {
        System.out.println(MD5.GetMD5Code("dingshuo.6"));
    }
}