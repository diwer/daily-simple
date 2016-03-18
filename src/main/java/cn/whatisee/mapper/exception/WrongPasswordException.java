package cn.whatisee.mapper.exception;

/**
 * Created by ppc on 2016/3/14.
 */
public class WrongPasswordException extends Exception {
    public WrongPasswordException(String message){
        super(message);
    }
}
