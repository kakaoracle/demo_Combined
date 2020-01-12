# 前端(包括css和h5和typescript)
## 安装less
1. 安装less或者cass或者stylus
命令: npm install -g less
安装完成后查看结果: lessc -version
2. 作用
- 嵌套(在父子关系中):
css:
```
.class1 .class2 {}
.class1 .class3 {}
且.class1与.class2之间一定要有空格
```
less:
```
.class1{
  .class2{}
  .class3{}
}
```

## CSS
1. 能用class(.)表示就不用id(#)表示
2. div的border属性有三个:   border:1px solid lightskyblue;
3. div中字体水平居中: text-align: center;
   div中字体垂直居中: height: 20px; line-height: 20px;(设置height和line-height相同)
4. 阴影:box-shadow: 10px 20px 40px 20px #4e99ff;(从左边框右移10,从上边框下移20,往右再加40,计算出中点,最后扩展20用来渐变,扩展20可以省略)
5.













