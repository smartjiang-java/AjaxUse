package bjpowernode.controller;


import bjpowernode.dao.ProvinDao;
import bjpowernode.model.Province;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName :QueryProvinceServlet
 * Package :com.bjpowernode.controller
 * Description:
 *
 * @Date :2020-05-21
 * @Author:Jqk
 */
public class QueryProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //获取数据
        String proid = req.getParameter("proid");

        //定义返回数据 :默认值,{}:表示json格式的数据
        String result = "{}";


        //访问数据库
        if (proid != null && proid.trim().length()>0 ) {    //不为空,且不是空串,注意:空串和空不是一个概念
            int id = Integer.valueOf(proid);   //将String类型强转成int类型
             ProvinDao dao = new ProvinDao();
            Province province = dao.queryProvinceNameById(id);  //从数据库中获取数据
            //使用jackon把Province对象转化为json格式
            ObjectMapper om = new ObjectMapper();
            result = om.writeValueAsString(province);
        }

        //使用HttpServletResponse输出数据
        resp.setContentType("application/json;charset=utf-8");  //指定服务器端(servlet)返回给浏览器的事json格式的数据
        PrintWriter pw = resp.getWriter();

        pw.println(result);  //将数据传给ajax:json格式
        pw.flush();
        pw.close();

    }


}
