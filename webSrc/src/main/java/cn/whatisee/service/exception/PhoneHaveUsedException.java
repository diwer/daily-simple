package cn.whatisee.service.exception;

/**
 * Created by ppc on 2016/3/21.
 */
public class PhoneHaveUsedException extends HaveUsedException {

    public PhoneHaveUsedException(String phone){
        super(phone);
    }
    @Override
    public  String getMessage(){
        return  "该手机已经注册："+this.getHaveUsed();
    }
    public String getPhone() {
        return this.getHaveUsed();
    }


}
