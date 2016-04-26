package cn.whatisee.model;

import java.util.Date;

/**
 * Created by ppc on 2016/3/7.
 */
public class MultiMedia extends BaseModel {
    private static final long serialVersionUID = 5420039383663159675L;

    private String id;
    private  String fileName;
    private  String storeLocation;
    private  String url;
    private Date createDate;
    private boolean isDelete;
    private String createrId;
    private int orderNo;
    private String flagDesc;




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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public String getFlagDesc() {
        return flagDesc;
    }

    public void setFlagDesc(String flagDesc) {
        this.flagDesc = flagDesc;
    }
}
