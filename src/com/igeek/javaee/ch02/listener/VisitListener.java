package com.igeek.javaee.ch02.listener;

import com.igeek.javaee.ch02.service.VisitService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

//上下文的监听器：监听上下文（Tomcat容器）启动和关闭
@WebListener()
public class VisitListener implements ServletContextListener {

    private VisitService service = new VisitService();

    // Public constructor is required by servlet spec
    public VisitListener() {
    }


    /**
     * This method is called when the servlet context is
     * initialized(when the Web application is deployed).
     * You can initialize servlet context related data here.
     *
     * 当Tomcat容器启动时，此时上下文初始化，从数据库中获得最新的访问人次
     * @param event 上下文事件对象
     */
    public void contextInitialized(ServletContextEvent event) {
        //从数据库中查询最新的访问人次
        int counts = service.getCounts();
        System.out.println("容器启动，访问人次："+counts);
        //通过上下文事件对象，获取上下文对象
        ServletContext servletContext = event.getServletContext();
        //将访问人次设置到上下文对象中
        servletContext.setAttribute("counts",counts);
    }

    /**
     * This method is invoked when the Servlet Context
     * (the Web application) is undeployed or
     *  Application Server shuts down.
     *
     * 当Tomcat容器关闭时，此时上下文销毁，给数据库中存储最新的访问人次
     * @param event 上下文事件对象
     */
    public void contextDestroyed(ServletContextEvent event) {
        //通过上下文事件对象，获取上下文对象
        ServletContext servletContext = event.getServletContext();
        //通过上下文对象，获得上下文属性中的最新的访问人次
        Integer counts = (Integer)servletContext.getAttribute("counts");
        System.out.println("容器销毁，访问人次："+counts);
        //将数据插入到数据库中
        service.saveCounts(counts);
    }

}
