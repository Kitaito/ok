package com.igeek.javaee.ch02.dao;

public class VisitDao extends BaseDao {

    //查询值
    public Object select(){
        Object value = this.getSingleValue("select * from visit", null);
        return value;
    }

    //插入
    public void insert(int count){
        this.update("update visit set count = ?",count);
    }

}
