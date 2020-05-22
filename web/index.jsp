<%--
  Created by IntelliJ IDEA.
  User: 姜启坤
  Date: 2020-05-21
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>ajax:使用json格式的数据</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script>

    function search() {
      /**
       * //使用ajax原生态请求
      //发起Ajax请求,传递参数给服务器,服务器返回数据
      //1:创建异步对象
      var xmlHttp = new XMLHttpRequest();
      //2:绑定事件
      xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
          //alert(xmlHttp.responseText);
          var data = xmlHttp.responseText;
          //eval是执行括号中的代码,把 json字符串转化为json对象
          var jsonobj=eval("("+ data +")");
          //更新d对象
          document.getElementById("proname").value = jsonobj.name;
          document.getElementById("projiancheng").value=jsonobj.jiancheng;
          document.getElementById("procityshenghui").value=jsonobj.shenghui;
        }
      }
      //3:初始化异步对象
      var proid=document.getElementById("proid").value;
      proid="proid="+proid;
      //true:异步处理请求. 使用异步对象发起请求后,不用等待数据处理完毕,就可以执行其他的操作
      xmlHttp.open("get", "queryjson?"+proid, true);
      //4:发送请求
      xmlHttp.send();
       */

      //使用jquery-ajax方式
      /**
      $.ajax({
               //type:'get'
              url:'queryjson',
              data:{"proid":$("#proid").val()},
              success:callback,
              error:errorFun,
              dataType:'json'    //前方传过来的是json,这里可以设置成json/text;但如果传过来的是string,这里只能用text
      });
       */


      //最常用的ajax方式
      $.get( "queryjson",
             // {"proid":$("#proid").val()},    //根据id取值
              {"proid":$(":text[name='proid']").val()},    //根据name取值
              callback,
              "json");

    }

    //局部刷新函数
    function callback(data){
    // alert(data);  //字符串可以直接打印,但是json对象不能直接打印,必须逐个取值
      document.getElementById("proname").value = data.name;
      document.getElementById("projiancheng").value=data.jiancheng;
      document.getElementById("procityshenghui").value=data.shenghui;
    }

    //出错之后的函数
    function  errorFun() {
      alert("出错了,请检查数据没有传输完成还是接受收数据失败");
    }


  </script>
</head>

<body>

<p>ajax:使用json格式的数据</p>
<table>
  <tr>
    <td>省份编号:</td>
    <td><input type="text" id="proid" name="proid">
      <input type="button" value="搜索" onclick="search()">
    </td>
  </tr>
  <tr>
    <td>省份名称:</td>
    <td><input type="text" id="proname"></td>
  </tr>
  <tr>
    <td>省份简称:</td>
    <td><input type="text" id="projiancheng"></td>
  </tr>
  <tr>
    <td>省会城市:</td>
    <td><input type="text" id="procityshenghui"></td>
  </tr>

</table>


</body>
</html>
