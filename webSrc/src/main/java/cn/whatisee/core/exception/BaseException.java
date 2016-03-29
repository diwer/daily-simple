package cn.whatisee.core.exception;

import java.io.Serializable;

/**
 * Created by ppc on 2016/3/28.
 */
public class BaseException extends Exception implements Serializable {

    private static final long serialVersionUID = 461101730352507726L;


    public BaseException() {
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}
