package com.igeek.javaee.ch04.items.dao;

import com.igeek.javaee.ch04.items.entity.Items;

import java.util.List;

public class ItemsDao extends BaseDao<Items>{

    //根据条件+分页查询所有记录
    public List<Items> selectAll(String query,Integer begin){
        String sql = "select * from items where name like concat('%',?,'%') limit ?,3";
        List<Items> list = this.getBeanList(Items.class, sql, query, begin);
        return list;
    }

    //根据条件查询总记录数
    public Long selectCounts(String query){
        String sql = "select count(*) from items where name like concat('%',?,'%')";
        Long value = (Long)this.getSingleValue(sql, query);
        return value;
    }


    //根据商品名称进行精确查询
    public Items selectOne(String name){
        String sql = "select * from items where name = ?";
        Items items = this.getBean(Items.class, sql, name);
        return items;
    }

    //添加商品
    public int insert(Items items){
        String sql = "insert into items(name,price,detail,pic,createtime) values(?,?,?,?,?)";
        int i = this.update(sql, items.getName(), items.getPrice(), items.getDetail(), items.getPic(), items.getCreatetime());
        return i;
    }


}
