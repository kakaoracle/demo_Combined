###	springboot的启动类是放到控制层下的,而不是与控制层平级
###	用@RestController返回javabean可以识别但是返回json字符串无法识别并报404错误
#### 返回一个对象和返回一个json究竟 说的是什么意思:
	javabean传输时的展示形式是:"User [id=1,name=ming]"
	而用了json转换后变成了"{"id":1,"name":"ming"}"
    当然如果用了RestController之后,返回javabean也会自动变成第二种进行传输		
#### springmvc默认的javabean转json用的是jackjson
#### springmvc中返回javabean的时候,在浏览器会显示为json字符串格式,但是返回json格式的string,在浏览器会显示text格式,虽然内容一致,但是第一眼显示方式不同,原因是二者默认的produres不同.
@RequestMapping(value = "/upload",produces="application/json;charset=UTF-8")
@RequestMapping(value = "/upload",produces="text/html;charset=UTF-8")
