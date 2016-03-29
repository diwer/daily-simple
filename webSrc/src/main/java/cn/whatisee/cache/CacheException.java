package cn.whatisee.cache;

import cn.whatisee.core.exception.BaseException;

/**
 * Created by ppc on 2016/3/28.
 */
public class CacheException extends BaseException {

    private static final long serialVersionUID = -5470554552540361106L;

    public CacheException() {
    }

    public CacheException(String message, Throwable cause) {
        super(message, cause);
    }

    public CacheException(String message) {
        super(message);
    }

    public CacheException(Throwable cause) {
        super(cause);
    }
}
