package com.igeek.javaee.ch04.items.servlet;

import com.igeek.javaee.ch04.items.entity.Items;
import com.igeek.javaee.ch04.items.service.ItemsService;
import com.igeek.javaee.ch04.items.vo.PageVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ItemsServlet", urlPatterns = "/items")
public class ItemsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItemsService service = new ItemsService();

        //获得请求参数
        String code = request.getParameter("code");
        if(code!=null && !code.equals("")){

            switch (code){
                //根据搜索条件+分页查询列表
                case "viewAll":
                    //获得请求参数中的查询条件
                    String query = request.getParameter("query");
                    //获得请求参数中当前页码
                    String page= request.getParameter("pageNow");
                    Integer pageNow = Integer.parseInt(page);

                    //查询列表操作
                    PageVO<Items> vo = service.viewAll(query, pageNow);
                    request.setAttribute("vo",vo);
                    request.getRequestDispatcher("items/itemsList.jsp").forward(request,response);
                    break;
                case "add":
                    break;
                case "viewOne":
                    break;
                case "update":
                    break;
                case "delete":
                    break;
                default:
                    break;
            }

        }else{
            System.out.println("当前无此操作");
        }

    }
}
