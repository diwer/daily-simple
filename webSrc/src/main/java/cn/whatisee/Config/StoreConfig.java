package cn.whatisee.Config;


/**
 * Created by mingsheng on 16/4/6.
 */
public enum StoreConfig {

    Image("imageWhatIsee", 1),
    Video("videoWhatIsee", 2),
    Audio("audioWhatIsee", 3);

    private String name;
    private int index;

    private StoreConfig(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (StoreConfig s : StoreConfig.values()) {
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

