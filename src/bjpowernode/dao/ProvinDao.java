package bjpowernode.dao;

import bjpowernode.model.Province;

import java.sql.*;

/**
 * ClassName :ProvinDao
 * Package :com.bjpowernode.dao
 * Description:
 *
 * @Date :2020-05-21
 * @Author:Jqk
 */

//使用jdbc访问数据库
public class ProvinDao {

    //根据id获取一个完整的province对象
    public Province queryProvinceNameById(Integer provinceId) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "";

        //连接数据库三要素
        String url = "jdbc:mysql://localhost:3306/springbd";
        String username = "root";
        String password = "admin";

        //访问数据库的返回值
        Province p=new Province();

        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection(url, username, password);
            //创建preparedStatement
            sql = "select id,name,jiancheng,shenghui from province where id=?";
            pst = conn.prepareStatement(sql);
            //设置参数值(将1赋值给传进来的方法值)
            pst.setInt(1, provinceId);    //1代表sql语句的第一个参数?
            //执行sql
            rs = pst.executeQuery();
            //遍历rs
/*            while(rs.next()){  //当你的rs中有大于一条数据时
               String name=rs.getString("name");  //拿到name列对应的值
            }*/
            if (rs.next()) {

                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setJiancheng(rs.getString("jiancheng"));
                p.setShenghui(rs.getString("shenghui"));

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return p;
    }
}

