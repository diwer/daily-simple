package cn.whatisee.model;

/**
 * Created by ppc on 2016/3/8.
 */
public enum DailyStatus {

    Normal("正常", 1),
    Reported("被举报", 2);

    private String name;
    private int index;

    private DailyStatus(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (DailyStatus s : DailyStatus.values()) {
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
