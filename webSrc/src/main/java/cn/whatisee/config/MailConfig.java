package cn.whatisee.config;

/**
 * Created by mingsheng on 16/4/7.
 */
public enum MailConfig {
    ForgetPassword(0, "忘记密码","mailConfig/forgetPasswordMail.vm"),
    Validate(1, "验证邮箱","mailConfig/validateMail.vm"),
    ChangePassword(2, "修改密码","mailConfig/changePasswordMail.vm");


    private int index;
    private String name;
    private String vmPath;

    private MailConfig(int index, String name,String vmPath) {
        this.index = index;
        this.name = name;
        this.vmPath=vmPath;
    }

    public static String getName(int index) {
        for (MailConfig s : MailConfig.values()) {
            if (s.index == index)
                return s.name;
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public int getIndex() {
        return this.index;
    }

    public String getVmPath() {
        return vmPath;
    }
}
