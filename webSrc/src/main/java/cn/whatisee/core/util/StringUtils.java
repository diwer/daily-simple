package cn.whatisee.core.util;


import java.util.Collection;
import java.util.Random;

/**
 * Created by ppc on 2016/3/21.
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {

    private static String baseString="1234567890abcdefghigklmnopqrstuvwxyxz";
    private static Random random=new Random();
    public static String getStringByList(Collection<String> collection) {
        if (CollectionUtil.isEmpty(collection)) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (String str : collection) {
            builder.append(str);
        }

        return builder.toString();
    }
    public static String getRandomString(int num){

        String result="";
        for (int i=0;i<num ;i++){
            int index=random.nextInt(36);
            result+=baseString.substring(index,index+1);

        }
        return result;
    }
}
