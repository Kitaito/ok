package com.igeek.javaee.ch04.items.service;

import com.igeek.javaee.ch04.items.dao.ItemsDao;
import com.igeek.javaee.ch04.items.entity.Items;
import com.igeek.javaee.ch04.items.vo.PageVO;

import java.util.List;

public class ItemsService {

    private ItemsDao dao = new ItemsDao();

    //根据条件+分页查询商品列表
    public PageVO<Items> viewAll(String query , Integer pageNow){
        //获得总记录数
        Long counts = dao.selectCounts(query);
        //计算总页数
        Long myPages = (Long)((counts%3==0)?counts/3:counts/3+1);
        //计算起始值
        Integer begin = (pageNow-1)*3;
        //查询数据
        List<Items> itemsList = dao.selectAll(query, begin);
        //封装PageVO对象
        PageVO<Items> vo = new PageVO<Items>(query,pageNow,myPages,itemsList);
        return vo;
    }


    //校验商品用户名是否存在
    public boolean validateName(String name){
        Items items = dao.selectOne(name);
        if(items==null){
            return true; //当前商品不存在，商品名可用
        }
        //当前商品存在，商品名不可用
        return false;
    }


    //注册
    public boolean add(Items items){
        boolean flag = this.validateName(items.getName());
        if(flag){
            //商品名不存在，可用
            int i = dao.insert(items);
            if(i>0){
                //插入成功
                return true;
            }else{
                //没有成功插入
                return false;
            }
        }
        //当前商品存在，商品名不可用
        return false;
    }

}
