package cn.whatisee.service.exception;

/**
 * Created by ppc on 2016/3/10.
 */
public class NotFindException extends Exception {
    private String findId;
    private String errorClass;
    private String selfMessage;

    public NotFindException(String id, String className) {
        super();
        this.findId = id;
        this.errorClass = className;
        this.selfMessage = String.format("{} not find  id:{}", id, className);
    }

    @Override
    public String getMessage() {
        return selfMessage;
    }

    public String getFindId() {
        return findId;
    }

    public String getErrorClass() {
        return errorClass;
    }
}
