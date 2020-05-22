package bjpowernode.test;

import bjpowernode.model.Province;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ClassName :TestJson
 * Package :bjpowernode.test
 * Description:
 *
 * @Date :2020-05-21
 * @Author:Jqk
 */
public class TestJson {

    public static void main(String[] args) throws JsonProcessingException {
        //使用jsckson把java对象转化成json格式的字符串

        Province p=new Province();
        p.setId(1);
        p.setName("河北");
        p.setJiancheng("冀");
        p.setShenghui("石家庄");

        //使用jackson把 p转化为json
        ObjectMapper om=new ObjectMapper();
        String json = om.writeValueAsString(p);    //把参数的java对象转为json格式的字符串
        System.out.println("转换的json="+json);


    }



}
