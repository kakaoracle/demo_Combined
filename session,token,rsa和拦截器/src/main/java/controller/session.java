package controller;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
* 问题:用cookie的话,网站确定,客户端确定,因此用户确定,但是session保存在服务端,无法确定是哪一个客户端,怎么办?
	取出id,将id每次赋同一个值,写入到cookie,每次从cookie中确定session.
	其他:cookie与session都可以从request的方法中获取.
	cookie需要new一个对象,这句话指的是自定义一个cookie键值对,
	session是一个抽象概念,session可以是服务器内存的一个map键值对(通常说的cookie实现),也可以是一个文件,也可以是一份数据库文件,而sessionid是一个cookie键值对(默认实现方案是cookie形式),是session的一部分,用来识别session,然后sessionid作为一个cookie写入到客户端,客户端从来不写入session,只写一个id能够用servlet通过id找到对应的session而已
	当cookie被禁用时,服务端无法从cookie中读取sessionid,就找不到对应session,就需要"url重写",也就是在url路径中写明sessionid
	session的数据结构:
		没有RFC,由于session可以多线程共享,
		protested Map<String,Session> sessions = new ConcurrenthashMap<>();
*
* */
public class session extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
    //分清有的时候dopost里面的方法是this.goGet(request,response);还是super.dopost(req,resp)如果后者,那么post提交就须写在dopost中
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookname = req.getParameter("bookname");
        HttpSession session = req.getSession();
        /*由于cookie是map键值对,同时第一次请求时带来的session的id名默认为JSESSIONID
        于是每一次都再写一遍sessionid,确保是同一个session
         * */
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        System.out.println(">>sessionId:"+session.getId());
        resp.addCookie(cookie);

        //将购物车列表存放入session中,如果不存在,那么先创建
        List list = (List) session.getAttribute("chart");
        if(list == null){
            List chart = new ArrayList();
            chart.add(bookname);
            System.out.println(">>chart:"+chart.toString());
            session.setAttribute("chart",chart);
        }else {
            list.add(bookname);
            session.setAttribute("list",list);
            System.out.println(list.toString());
        }

    }
}
