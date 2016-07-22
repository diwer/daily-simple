package cn.whatisee.model;

import java.util.Date;

public class Image {
    private String id;

    private String filename;

    private String filepath;

    private Integer orderno;

    private String url;

    private Byte isdelete;

    private Integer type;

    private String flagdesc;

    private String usedid;

    private Date createtdate;

    private String createrid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public Integer getOrderno() {
        return orderno;
    }

    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Byte getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Byte isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFlagdesc() {
        return flagdesc;
    }

    public void setFlagdesc(String flagdesc) {
        this.flagdesc = flagdesc == null ? null : flagdesc.trim();
    }

    public String getUsedid() {
        return usedid;
    }

    public void setUsedid(String usedid) {
        this.usedid = usedid == null ? null : usedid.trim();
    }

    public Date getCreatetdate() {
        return createtdate;
    }

    public void setCreatetdate(Date createtdate) {
        this.createtdate = createtdate;
    }

    public String getCreaterid() {
        return createrid;
    }

    public void setCreaterid(String createrid) {
        this.createrid = createrid == null ? null : createrid.trim();
    }
}