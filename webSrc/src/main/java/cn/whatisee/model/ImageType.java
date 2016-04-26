package cn.whatisee.model;

/**
 * Created by mingsheng on 16/4/7.
 */
public enum ImageType{

    Daily(1,"日记照片"),
    Avatar(2,"头像照片");



    private int index;
    private String name;

    private ImageType(int index,String name){
        this.index=index;
        this.name=name;
    }

    public static String getName(int index) {
        for (ImageType s : ImageType.values()) {
            if (s.index == index)
                return s.name;
        }
        return null;
    }

    public int getIndex() {
        return index;
    }


    public String getName() {
        return name;
    }

}

