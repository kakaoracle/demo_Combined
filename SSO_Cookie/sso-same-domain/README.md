0. 同域SSO表示:
    域名完全相同(指的是从com(一级域名)开始,往左的低级别域名全部相同),不同的只是域名下的资源而已
    web1.x.com/1.html与web1.x.com/2.html
1. 关键就在于先检查用户名密码还是先检查cookie,答案是先检查cookie,
如果没有cookie,那么再通过登录来设置cookie
2. 打开localhost:8080/demo1(不是demo01)后,会检查cookie
3. 第一次打开肯定是没有cookie的,于是跳转到登录页面,判断如果用户名与密码正确的话就设置cookie
4. cookie的一大特征就是设置好了之后,访问页面会自动携带.
5. 最终效果就是,打开localhost:8080/demo1会显示登录页面,浏览器不关,再打开localhost:8080/demo2页面
   就不用再登录就可以显示demo2的欢迎页面
6. 具体详细步骤可以参见:https://segmentfault.com/a/1190000008933546


