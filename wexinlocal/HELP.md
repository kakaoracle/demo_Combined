# Getting Started
1. 微信发送的消息都是xml类型的,post方式,不同事件由消息中的内容决定,返回xml字符串,标签之间不能有空格
2. 调用接口一般都会用到token,需要先请求获取到token后保存下来
3. 自定义菜单,往公众号发送请求将菜单发过去,现在是写一个main方法,调用时
才会分配菜单,用一次就可以了.
4. 事件也是消息,只不过消息参数MsgType为event
5. 获取用户信息,需要获取用户加密后的微信名(即openId)