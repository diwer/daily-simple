package cn.whatisee.core.util;

/**
 * Created by mingsheng on 16/4/6.
 */
import java.util.UUID;

public class UUIDUtil {
    public UUIDUtil() {
    }

    public static synchronized String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 8) + uuid.substring(9, 13) + uuid.substring(14, 18) + uuid.substring(19, 23) + uuid.substring(24);
    }
}
