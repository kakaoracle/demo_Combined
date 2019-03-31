1. 参考的视频教程链接为:https://www.imooc.com/learn/633
1. 这三个示例全部都是用cookie来做的
2. cookie在跨域中能够实现,但是不适合最广泛的商业应用.原因是:
    cookie不可以设置.com,但是一家公司的网址可以是taobao.com和tianmao.com这样就不适用.因此最好用Token或者用CAS
3. 在设置host文件127.0.0.1 www.a.com后,一定要注意,浏览器必须重启,必须!必须!必须!
4. 详细见sso-cross-domain
5. cookie取决于域(domain),path,有效期
比如:
Cookie: domain=dn.com  path = /sso
http://dn.com/sso              可以
http://erp.dn.com/sso          可以
http://dn.com/sso/index        可以
http://erp.aa.com/sso/index    不可以
http://erp.dn.com/erp/index    不可以
6. 跨域的流程是:
    第一遍登录,服务器验证成功后,生成一个session类,并将session的键值对放到cookie中(设置好path),然后传回给浏览器
    cookie是浏览器公用的一个类,每一次请求,浏览器都会检查对应的域和path下有没有cookie,这一步是自动的.
    session在java中就是一个类,叫做HttpSession而已
    跨域就是多增加一个验证cookie的服务.
7. 注销的话就再用token