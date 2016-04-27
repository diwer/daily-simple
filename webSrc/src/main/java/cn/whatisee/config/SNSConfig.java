package cn.whatisee.config;

/**
 * Created by mingsheng on 16/4/7.
 */
public enum SnsConfig {
    ForgetPassword(0,"忘记密码"),

    Validate(1,"验证手机"),

    ChangePassword(2,"修改密码");


    private int index;
    private String name;

    private SnsConfig(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public static String getName(int index) {
        for (SnsConfig s : SnsConfig.values()) {
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
}
