## 与IO_demo工程配套的FileResources是用来作为服务器,存储图片及其他文件来测试用的
## springboot中的静态资源不是放在webapp中的(若放则需要设置一下),默认是放在resources下的static下的
## file(url)有这个方法,但是没有用处,因为这个用法的前提是要取得的文件的是ftp开头而不是http开头\
## file,inputstream,outputstream的关系
    第一,input/outputstream都是一个类,inputstream(地址)就自动生成一个含有内容的实例,包含文件所有内容
    只不过是二进制而已,file的作用只是资源地址,例如inputstream(file)或者outputstream(file)
    第二,