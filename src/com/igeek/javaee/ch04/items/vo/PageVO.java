package com.igeek.javaee.ch04.items.vo;

import java.util.List;

/**
 * 分页的辅助类
 */
public class PageVO<T> {

    //查询条件
    private String query;
    //当前页
    private Integer pageNow;
    //总页数
    private Long myPages;
    //数据
    private List<T> list;

    public PageVO(String query, Integer pageNow, Long myPages, List<T> list) {
        this.query = query;
        this.pageNow = pageNow;
        this.myPages = myPages;
        this.list = list;
    }

    public PageVO() {
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public Long getMyPages() {
        return myPages;
    }

    public void setMyPages(Long myPages) {
        this.myPages = myPages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageVO{" +
                "query='" + query + '\'' +
                ", pageNow=" + pageNow +
                ", myPages=" + myPages +
                ", list=" + list +
                '}';
    }
}
