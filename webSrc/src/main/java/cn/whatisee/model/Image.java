package cn.whatisee.model;

/**
 * Created by ppc on 2016/3/7.
 */
public class Image extends MultiMedia {

    private static final long serialVersionUID = -94561397120329104L;
    private float width;
    private float height;

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
