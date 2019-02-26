package club.applo.fay.model;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2018-12-26 16:36
 * @TODO: outline对象
 * ==========================
 */
public class OutlineData {

    private static final String API = "https://157.230.46.211:50504/Xdfd_wdqQgnMgHThZS9sqw/access-keys/";



    public String addKey(){
        return new Shell(String.format("curl --insecure -X POST %s", API)).exec();
    }

}
