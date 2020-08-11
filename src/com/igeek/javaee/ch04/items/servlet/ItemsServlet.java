package com.igeek.javaee.ch04.items.servlet;

import com.igeek.javaee.ch04.items.entity.Items;
import com.igeek.javaee.ch04.items.service.ItemsService;
import com.igeek.javaee.ch04.items.vo.PageVO;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @MultipartConfig 有此注解，表示当前servlet支持文件上传
 */
@WebServlet(name = "ItemsServlet", urlPatterns = "/items")
@MultipartConfig
public class ItemsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItemsService service = new ItemsService();

        //获得请求参数
        String code = request.getParameter("code");
        System.out.println("code = "+code);
        if(code!=null && !code.equals("")){

            switch (code){
                //根据搜索条件+分页查询列表
                case "viewAll":
                    //获得请求参数中的查询条件
                    String query = request.getParameter("query");
                    //获得请求参数中当前页码
                    String page= request.getParameter("pageNow");
                    Integer pageNow  =0;
                    if(query==null){
                        query = "";  //默认查询所有
                    }
                    if(page==null){
                        pageNow  =1; //默认查询第一页
                    }else{
                        pageNow = Integer.parseInt(page);
                    }
                    //查询列表操作
                    PageVO<Items> vo = service.viewAll(query, pageNow);
                    request.setAttribute("vo",vo);
                    request.getRequestDispatcher("items/itemsList.jsp").forward(request,response);
                    break;
                case "validate":
                    String name = request.getParameter("name");
                    boolean flag = service.validateName(name);
                    String message = "";
                    if(flag){
                        message = "当前商品名未占用";
                    }else{
                        message = "当前商品名已占用";
                    }
                    //System.out.println("flag="+flag+",message="+message);
                    //绑定json数据
                    JSONObject obj = new JSONObject();
                    obj.put("flag",Boolean.toString(flag));
                    obj.put("nameMsg",message);
                    //通过响应，将json数据以字符串的形式传递至页面
                    PrintWriter out = response.getWriter();
                    out.println(obj.toString());
                    out.flush();
                    out.close();
                    break;
                case "add":
                    //通过请求参数获得普通域的数据
                    name = request.getParameter("name");
                    String detail = request.getParameter("detail");
                    Double price = Double.parseDouble(request.getParameter("price"));
                    Timestamp createtime = Timestamp.valueOf(request.getParameter("createtime"));

                    //创建商品对象Items
                    Items items = new Items(name,price,createtime,detail);

                    //处理图片上传
                    Part part = request.getPart("file");
                    if(part!=null){
                        //获取原图片的名称
                        String oldName = part.getHeader("content-disposition");
                        //oldName = form-data; name="file"; filename="Chrysanthemum.jpg"
                        System.out.println("oldName = "+oldName);

                        if(oldName!=null && oldName.indexOf(".")>0){
                            //新名称 = 随机数 + 原图片的后缀  newName = 87d4b648-82ae-43c9-bcb3-caba58a27a7b.jpg
                            String newName = UUID.randomUUID()+
                                    oldName.substring(oldName.lastIndexOf("."),oldName.length()-1);
                            System.out.println("newName = "+newName);

                            //设置商品的图片信息
                            items.setPic("/pic/"+newName);
                            //将图片写入到服务器的磁盘上
                            part.write("G:\\0811 item\\temp\\"+newName);
                        }
                    }

                    //添加商品
                    flag = service.add(items);
                    if(flag){
                        //注册成功，响应重定向到商品查询列表
                        response.sendRedirect("/items?code=viewAll");
                    }else{
                        //注册失败
                        request.setAttribute("items",items);
                        request.getRequestDispatcher("/items/addItem.jsp").forward(request,response);
                    }

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
