###	springboot的启动类是放到控制层下的,而不是与控制层平级
###	用@RestController返回javabean可以识别但是返回json字符串无法识别并报404错误
#### 返回一个对象和返回一个json究竟 说的是什么意思:
	javabean传输时的展示形式是:"User [id=1,name=ming]"
	而用了json转换后变成了"{"id":1,"name":"ming"}"
    当然如果用了RestController之后,返回javabean也会自动变成第二种进行传输		
#### springmvc默认的javabean转json用的是jackjson