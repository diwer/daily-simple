package cn.whatisee.core.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

/**
 * Created by mingsheng on 16/4/6.
 */
public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();
    private static Logger logger = Logger.getLogger(JsonUtil.class);

    public static String toJson(Object object) {

        try {


            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            logger.error(e);
            return "";
        }
    }

}
