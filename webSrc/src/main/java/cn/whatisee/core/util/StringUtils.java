package cn.whatisee.core.util;


import java.util.Collection;

/**
 * Created by ppc on 2016/3/21.
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {

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
}
