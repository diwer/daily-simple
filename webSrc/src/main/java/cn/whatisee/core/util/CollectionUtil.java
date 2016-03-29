package cn.whatisee.core.util;

import java.util.Collection;
import java.util.Map;

/**
 * Created by ppc on 2016/3/28.
 */
public class CollectionUtil {

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }
}
