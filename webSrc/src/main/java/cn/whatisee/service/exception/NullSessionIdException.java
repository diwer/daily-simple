package cn.whatisee.service.exception;

/**
 * Created by mingsheng on 16/4/29.
 */
public class NullSessionIdException extends Exception {
    public NullSessionIdException(String message){
        super(message);
    }
}
