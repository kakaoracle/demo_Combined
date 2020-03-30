# Getting Started
1. 拦截器
2. session就是每一次浏览器打开时,服务端接收到请求同时就会生成一个session,这个
session有id,并且可以往session.arrtribute中写入信息,然后将sessionid写回到cookie中
3. token生成结果由密钥,有效期,对象组成,前端在请求头中发送时需要后端在拦截器
中放行token关键字
