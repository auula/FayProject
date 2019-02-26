package club.applo.fay.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-26 16:48
 * @TODO: 类描述
 * ==========================
 */
public class OutlineDataTest {

    @Test
    public void addKey() {
        System.out.println(System.currentTimeMillis());
        OutlineData outlineData = new OutlineData();
        System.out.println(outlineData.addKey());
    }
}