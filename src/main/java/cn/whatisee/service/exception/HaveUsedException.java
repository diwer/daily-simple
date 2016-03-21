package cn.whatisee.service.exception;

/**
 * Created by ppc on 2016/3/21.
 */
public class HaveUsedException extends  Exception{
    private String haveUsed;
    public HaveUsedException(String usedStr){
        super();
        this.haveUsed=usedStr;
    }

    protected String getHaveUsed() {
        return haveUsed;
    }

    protected void setHaveUsed(String haveUsed) {
        this.haveUsed = haveUsed;
    }
}
