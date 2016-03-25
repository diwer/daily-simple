package cn.whatisee.model;

/**
 * Created by ppc on 2016/3/7.
 */
public class Video extends MultiMedia {
    private float time;
    private int vol;

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }
}
