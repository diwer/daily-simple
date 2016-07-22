package cn.whatisee.web.model;

/**
 * Created by mingsheng on 16/4/27.
 */
public class LoginModel {
    private String email;
    private String phone;
    private String password;
    private String validCode;
    private int loginCount;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(int loginCount) {
        this.loginCount = loginCount;
    }

    public String getValidCode() {
        return validCode;
    }
}
