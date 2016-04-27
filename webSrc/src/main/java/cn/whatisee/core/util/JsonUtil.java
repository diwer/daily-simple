package cn.whatisee.core.util;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;

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
    public static Object toObject(String jsonStr, JavaType type){
        try {
            return mapper.readValue(jsonStr, type);
        }catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

}
