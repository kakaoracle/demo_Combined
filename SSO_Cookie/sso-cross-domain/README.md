1. 跨域sso登录
   首先设置hosts文件
   127.0.0.1 localhost
   127.0.0.1 www.a.com
   127.0.0.1 www.b.com
   127.0.0.1 www.x.com
2.由于http通信默认是80端口,如果设置为了8081,则在访问的时候,需要加上端口号,比如www.a.com:8081/demo1
    但是httpClient不支持端口设定,所以暂时用80端口
3. 第一次需要登录,以后每次如果有cookie则不需要登录
4. 前台问题,dologin已经找到正确html网页,在f12的response中展示正确,但是正面展示undefined,暂时不处理
