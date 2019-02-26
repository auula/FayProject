package club.applo.fay.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @author: ding
 * @email：coding1618@gmail.com
 * @date: 2018-12-08 14:58
 * @version：1.0
 * @Github：https://github.com/coding1618
 * @TODO: 返回数据结果集
 * ==========================
 */
public class JsonData implements Serializable {

    private static final long serialVersionUID = -2100472103525439247L;
    private static final int SUCCESS = 200;
    private static final int ERROR = 500;
    private String messages;
    private int status;
    private Map<String, Object> Data = new HashMap<String, Object>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static int getSUCCESS() {
        return SUCCESS;
    }

    public static int getERROR() {
        return ERROR;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, Object> getData() {
        return Data;
    }

    public void setData(Map<String, Object> data) {
        Data = data;
    }

    public static JsonData succes(String messages) {
        JsonData resultsData = new JsonData();
        resultsData.setStatus(SUCCESS);
        resultsData.setMessages(messages);
        return resultsData;
    }
    public static JsonData error(String messages){
        JsonData resultsData = new JsonData();
        resultsData.setMessages(messages);
        resultsData.setStatus(ERROR);
        return resultsData;
    }

    public JsonData addData(String kay,Object object){
        this.getData().put(kay,object);
        return this;
    }
}
