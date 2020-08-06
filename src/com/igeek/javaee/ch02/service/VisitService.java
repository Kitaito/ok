package com.igeek.javaee.ch02.service;

import com.igeek.javaee.ch02.dao.VisitDao;

//访问的业务逻辑
public class VisitService {

    private VisitDao dao = new VisitDao();

    //获取最新访问人次
    public int getCounts(){
        int count = (int)dao.select();
        return count;
    }

    //存储最新访问人次
    public void saveCounts(int count){
        dao.insert(count);
    }

}
