package controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
* 需求:登录后关闭浏览器,过一段时间再打开可以不用输入密码就登录
	方案:第一次输入密码提交后,response响应时候将cookie写入到浏览器
	cookie:是报文header请求头的一个字段,每次提交请求到固定网站都会自动搜索本地cookie,将内容带过去
	其他:
	cookie还可以设置域名,路径,有效期*/
public class cookie extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        //先判断有无cookie,如果有,打印出来
        Cookie[] cookies = req.getCookies();
        if (cookies != null &&cookies.length >0){
            for(Cookie cookie:cookies){
                if ("name".equals(cookie.getName())){
                    name = cookie.getValue();
                    System.out.println(cookie.getValue());
                }
            }
        }
        //如果没有携带cookie,那么将上传表单中的name值设置为一个新的cookie,如果表单中值为空,那么也直接设置一个新的值
        else{
            if(name != null){
                Cookie cookie1 = new Cookie(name, "xiaoming");
                resp.addCookie(cookie1);
            }else{
                Cookie cookie2 = new Cookie("空的名字", "xiaoming");
                resp.addCookie(cookie2);
            }
        }
    }
}
