package com.we.controller;

import java.util.List;

/**
 * Created by jackl on 2016/12/6.
 */
public class PageResult {
    private long total;
    private List rows;
    private int page;

    public PageResult(long total, List rows, int page) {
        this.total = total;
        this.rows = rows;
        this.page = page;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
