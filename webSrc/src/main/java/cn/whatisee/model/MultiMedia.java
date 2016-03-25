package cn.whatisee.model;

import java.util.Date;

/**
 * Created by ppc on 2016/3/7.
 */
public class MultiMedia extends BaseModel {
    private  String fileName;
    private  String storeLocation;
    private  String url;
    private Date createDate;
    private boolean isDelete;
    private String createrId;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setisDelete(boolean delete) {
        isDelete = delete;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }
}
