package cn.whatisee.model;

/**
 * Created by mingsheng on 16/4/6.
 */
public class BaseJsonModel extends BaseModel {

    private static final long serialVersionUID = 3775599649622189685L;

    private  int ErrCode;
    private String ErrMessage;

    private String ErrBody;

    private Object ReponseObj;

    public int getErrCode() {
        return ErrCode;
    }

    public void setErrCode(int errCode) {
        ErrCode = errCode;
    }

    public String getErrMessage() {
        return ErrMessage;
    }

    public void setErrMessage(String errMessage) {
        ErrMessage = errMessage;
    }

    public String getErrBody() {
        return ErrBody;
    }

    public void setErrBody(String errBody) {
        ErrBody = errBody;
    }

    public Object getReponseObj() {
        return ReponseObj;
    }

    public void setReponseObj(Object reponseObj) {
        ReponseObj = reponseObj;
    }
}
