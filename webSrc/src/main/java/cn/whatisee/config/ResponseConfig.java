package cn.whatisee.config;

/**
 * Created by mingsheng on 16/4/6.
 */
public enum ResponseConfig {
    Nomal(0, "正常"),
    UploadFail(1, "上传失败"),
    NoLogin(2,"未登录");


    private int index;
    private String name;

    private ResponseConfig(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public static String getName(int index) {
        for (ResponseConfig s : ResponseConfig.values()) {
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
