package cn.whatisee.core;

/**
 * Created by ppc on 2016/3/23.
 */
public class Pageable {
    private int index;
    private int pageSize;

    public Pageable(int index, int pageSize) {
        if (index >= 1) {
            this.index = index;
        } else {
            this.index = 1;
        }
        if (pageSize >= 1) {
            this.pageSize = pageSize;
        } else {
            this.pageSize = 20;
        }
    }

    public Pageable() {
        this.index = 1;
        this.pageSize = 20;
    }

    public int getFrom() {
        return (index - 1) * pageSize;
    }

    public int getTo() {
        return pageSize * index;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
