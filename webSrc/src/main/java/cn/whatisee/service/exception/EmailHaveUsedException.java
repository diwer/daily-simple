package cn.whatisee.service.exception;

import cn.whatisee.core.util.StringUtils;

/**
 * Created by ppc on 2016/3/21.
 */
public class EmailHaveUsedException extends HaveUsedException {

    public EmailHaveUsedException(String email){
        super(email);
    }
    @Override
    public  String getMessage(){
        return  "该邮箱已经注册："+this.getHaveUsed();
    }
    public String getEmail() {
        return this.getHaveUsed();
    }


}
