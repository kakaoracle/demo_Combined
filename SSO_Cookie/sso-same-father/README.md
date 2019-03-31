 1. 同父域
    web1.x.com与web2.x.com,web1与web2都是三级域名,相同的父域是x.com
>   待定(暂不确定):
    同父域指的父域必须是二级或者更低,不能是一级域名,因为
    web1.com与web2.com类似这样cookie可以传递了.
2. 设置hosts文件:
    127.0.0.1 localhost
    127.0.0.1 demo1.x.com
    127.0.0.1 demo2.x.com
    127.0.0.1 check.x.com
3. 接同域,访问demo1.x.com:8080/demo1与demo2.x.com:8080/demo2并填写用户名与密码后,
    由于demo1页面的cookie无法跨域传输到demo2,因此demo2必须重新登录
4. 测试的时候用的就是demo1.x.com:8080/demo1与demo2.x.com:8080/demo2
    统一校验的域名接口为check.x.com:8080
5.





























