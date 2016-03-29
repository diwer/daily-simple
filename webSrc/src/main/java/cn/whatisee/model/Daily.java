package cn.whatisee.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ppc on 2016/3/7.
 */
public class Daily extends BaseModel {

    private static final long serialVersionUID = -2881039864522495686L;
    private String id;
    private String Content;
    private ArrayList<Image> imageList;
    private Date createDate;
    private Date deleteDate;
    private String title;
    private Video video;
    private String videoUrl;
    private boolean isDelete;
    private String userId;
    private int dailystatus;
    private int reportCount;
    private int likeCount;
    private String Location;
    private String Weather;

    private String Tag;

    public boolean IsPublic() {
        return false;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
//
//    public Video getVideo() {
//        return video;
//    }
//
//    public void setVideo(Video video) {
//        this.video = video;
//    }


    public void setReportCount(int reportCount) {
        this.reportCount = reportCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public ArrayList<Image> getImageList() {
        return imageList;
    }

    public void setImageList(ArrayList<Image> imageList) {
        this.imageList = imageList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getWeather() {
        return Weather;
    }

    public void setWeather(String weather) {
        Weather = weather;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean delete) {
        isDelete = delete;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getDailystatus() {
        return dailystatus;
    }

    public void setDailystatus(int dailystatus) {
        this.dailystatus = dailystatus;
    }
}
