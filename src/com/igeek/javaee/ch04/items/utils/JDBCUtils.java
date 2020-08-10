package com.igeek.javaee.ch04.items.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 通过数据库连接池 C3P0进行数据访问操作
 *
 * 核心类：ComboPooledDataSource
 */
public class JDBCUtils {

    // 创建数据源
    private static DataSource dataSource = new ComboPooledDataSource("order");
    // 线程变量
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    //获取连接池（数据源）的方法
    public static DataSource getDataSource(){
        return dataSource;
    }


    //获取连接对象
    public static Connection getConn() {
        //通过线程变量获取连接
        Connection conn = tl.get();
        //若连接对象是null，或者被关闭了
        try {
            if(conn==null || conn.isClosed()){
                //从数据源中获取连接对象
                conn = dataSource.getConnection();
                //将连接对象返回至线程变量中
                tl.set(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    //释放资源
    public static void close(Connection conn , Statement st , ResultSet rs){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
