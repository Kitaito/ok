package com.igeek.javaee.ch04.items.dao;

import com.igeek.javaee.ch04.items.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * BaseDao：定义一个用来被继承的对数据库进行增删改查基本操作的类（CRUD）
 * @param <T>  泛型
 */
public class BaseDao<T> {

    private QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

    //通用的修改、删除、添加
    public int update(String sql,Object... params){
        int count = 0;
        try {
            count = runner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 查询单条记录
     * @param type   类类型
     * @param sql    SQL语句
     * @param params 多个参数
     * @return  对象
     */
    public T getBean(Class<T> type , String sql,Object...params){
        T bean = null;
        try {
            bean = runner.query(sql, new BeanHandler<>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 查询多条记录
     * @param type   类类型
     * @param sql    SQL语句
     * @param params 多个参数
     * @return 集合
     */
    public List<T> getBeanList(Class<T> type , String sql , Object...params){
        List<T> list = null;
        try {
            list = runner.query(sql, new BeanListHandler<>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 查询单个结果
     * @param sql    SQL语句
     * @param params 多个参数
     * @return 单值
     */
    public Object getSingleValue(String sql , Object...params){
        Object obj = null;
        try {
            obj = runner.query(sql, new ScalarHandler(), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
