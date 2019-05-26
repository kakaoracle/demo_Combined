# eleme
> 高仿饿了么
## 第3章:
- weback  核心编译工具  
## 第4章,项目实战-准备工作
src目录下的所有图片相关信息是课程中自带的  
- 图片分为2x,3x这主要是进行分辨率区分
- 制作图标字体,https://icomoon.io/app/#/select,将本地的svg文件全部上传自动生成对应图标,选中后点击自动生成,然后设置preferences的
名字,之后下载
- src目录下建立common(公共资源)和components(组件相关资源)两个目录,components下面新建header目录,common下面有三个目录,fonts,js,stylus
- 模拟后台数据:data.json,分为seller,goods,ratings三个部分的数据,最新版的vue的框架下的build目录下没有dev-server.js文件.但是可以在webpack-dev-conf.js文件中修改步骤:
```
在模拟后台数据的时候直接在webpack-dev-conf.js文件中修改

第一步，在const portfinder = require(‘portfinder’)后添加

//第一步
const express = require('express')
const app = express()//请求server
var appData = require('../data.json')//加载本地数据文件
var seller = appData.seller//获取对应的本地数据
var goods = appData.goods
var ratings = appData.ratings
var apiRoutes = express.Router()
app.use('/api', apiRoutes)//通过路由请求数据
第二步：找到devServer,在里面加上before（）方法

devServer: {
    clientLogLevel: 'warning',
    historyApiFallback: true,
    hot: true,
    compress: true,
    host: HOST || config.dev.host,
    port: PORT || config.dev.port,
    open: config.dev.autoOpenBrowser,
    overlay: config.dev.errorOverlay
      ? { warnings: false, errors: true }
      : false,
    publicPath: config.dev.assetsPublicPath,
    proxy: config.dev.proxyTable,
    quiet: true, // necessary for FriendlyErrorsPlugin
    watchOptions: {
      poll: config.dev.poll,
    },
    //第二步找到devServer,在里面添加
before(app) {
  app.get('/api/seller', (req, res) => {
    res.json({
      errno: 0,
      data: seller
    })//接口返回json数据，上面配置的数据seller就赋值给data请求后调用
  }),
  app.get('/api/goods', (req, res) => {
    res.json({
      errno: 0,
      data: goods
    })
  }),
  app.get('/api/ratings', (req, res) => {
    res.json({
      errno: 0,
      data: ratings
    })
  })
}
  }
```
然后命令:npm run dev,然后验证能否看到数据,localhost:8080/api/goods

## 第5章,页面骨架开发
### 组件拆分
1. 在static目录下新建css目录,复制reset.css,作用是将标签的默认功能给reset掉
2. 在index.html页面中写:
```html
<link rel="stylesheet" type="text/css" href="static/css//reset.css"><link>
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimun-scale=1.0,user-scalable=no">
<!--viewport指的是,最大缩放,最小缩放,禁止用户缩放-->
```
3. 样式:
```
<style lang="stylus" rel="stylesheet/stylus"><!--这里的stylus是不识别的,因此需要导入lang和rel进行配置 -->
  #app
    .tab
     display:flex
     width:100%
     height : 45px
     line-height :40px
     .tab-item
      flex:1
      text-align:center
</style>
```
### VUE路由
1. vue-router介绍:https://router.vuejs.org/
2. 任何组件安装后都会在node_modules下存在,比如router对应的vue-router,路由跳转后不是整个页面的跳转,只是所在div的展示内容的切换
3. 代码中引用:
main.js中:  
    import VueRouter from "vue-router";//vue-router是因为node_modules下的vuerouter下的package.json中的name就是vue-router
    Vue.use(VueRouter);
3. 使用步骤:
>>HTML中

1,使用<router-link to="">标签来指定链接,其会被渲染成一个<a>标签
2,使用<router-view></router-view>进行组件渲染

>>JavaScript中:

1,main.js中创建vue实例
```js
import App from './App';
import Vue from 'vue';
import router from './router';
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
//其中import中的vue,router,app皆不可少
```
2,index.js中创建router实例
```js
import Vue from 'vue'
import Router from 'vue-router'
import goods from '../components/goods/goods.vue'

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/goods',
      name: 'goods',
      component: goods
    }
  ]
})
//当然,在实例化router的时候,要显示声明一下用到这个router
```
### 像素boder的实现
1. 在app.vue的style标签中:
```js
#app
    .tab
      border-bottom : 1px solid rgba(7,17,27,0.1)
```
//但是这种1像素在iphone由于dpi就可能变成两倍或者三倍
要改成 
border-bottom : 1px solid rgba(7,17,27,0.1)
position relative
2. 为了其他地方也可以实现,于是抽出common目录->stylus->mixin.styl中定义一个函数:
border-1px($color)
    position: relative
然后app.vue中的<style>中用
  @import "./common/stylus/mixin.styl";//@import是stylus引用语法
  border-1px(rgba(7,17,27,0.1))来代替
3. 不同地方有不同的styl,多个styl可以通过同一个styl进行引用
styl目录新建index.styl:
@import "./mixin"
@import "./icon"
@import "./base"  
然后main.js引入index.styl:import './common/stylus/index.styl';  
4. 用处就是在app.vue中的
<div class="tab border-1px">
5. 因此步骤就是两个,一是写一个下边框,二是在base.styl中判断dpi,如果是1.5倍屏幕Y方向就缩放为0.7,为2就变成0.5,这样就达到什么样的屏幕都是一像素

### 备注
1. 路径别名
  比如import goods from '../components/goods/goods.vue',每一次指定compoments都需要知道目录层级关系太麻烦
  在build->webpack.base.conf.js中:
  alias: {"components": path.resolve(__dirname,'../src/components')},但是配置文件改完后需要重新启动工程
2. 路径中的#,比如主页应该是localhost/但是实际是localhost/#/
原因vue默认用hash模式,解决方法就是在index.js中添加export default new Router({mode: 'history',.....}
3. 点击时对被点击的标签单独设置
vue默认实现了被点击时自动生成class属性为router-link-exact-active router-link-active,意思是两个名字,任用其一即可


### 问题:
1. 问题报错:  
>>!!vue-style-loader!css-loader?{"sourceMap":true}!../../../node_modules/vue-loader/lib/style-compiler/index?{"vue":true,"id":"data-v-12835cef","scoped":false,"hasInlineConfig":false}!stylus-loader?{"sourceMap":true}!../../../node_modules/vue-loader/lib/selector?type=styles&index=0!./header.vue in ./src/components/header/header.vue  

解决方法:  
npm install sass-loader --save;
npm install node-sass --save;
如果还不行,那就再安装其他没有安装的模块,比如:  
npm install stylus-loader --save-dev;等等
2. stylus是什么?
是CSS预处理框架.与SASS/LESS类似,近似于用脚本的方式写css代码,默认用stly作为扩展名,SASS需要依赖ruby运行,但是stylus不用  
全局安装命令是:  
```script
npm install stylus -g
```
3. vue.map是1.0的方法,不兼容vue2.0,即vue2.0中挂载vue实例时不能用map方法


3. 等分时的flex是什么?

4. import Vue from 'vue',此vue是什么?位置在哪?
vue是插件,webpack包管理一个基本的文件目录,所谓vue,其实就是一个插件,用这个插件时语法比较方便而已,插件安装会安装到node_modules中插件的使用需要在main.js中Import 自定义名 from '插件名',比如vue其实是./vue,配置文件中会省略./,
5. ::-webkit是什么?
chrome与safari的私有前缀

## 第6章,header组件开发    
### VUE-resource应用
vue-resource类似于前端的httpclient,或者说是ajax
安装步骤见备注
在script标签中写函数:
```js
//状态码单独定义一下
const ERR_OK = 0;
export default {
  data(){
    return {
      seller: {}
    };
  },
  //created是生命周期,刚刚创建的时候,/api是在定义模拟数据的时候,在webpack-dev-conf中定义的路径
  created(){
    this.$http.get('/api/seller').then((response) => {
        response = response.body;
        if(response.errno=== ERR_OK){
            this.seller = response.data;
            console.log(this.seller);
        }
    });
  },
  components:{
    'v-header': header
  }
```
### 外部组件
- v-bind:seller可以省略 为:seller

###
###
###
###
###
### 备注
1. 安装插件:
比如安装插件vue-resource  
方法一:在package.json中的dependencies.json中注明:"vue-resource":"1.15.1"(具体版本号自己到github上查)
方法二:直接npm install vue-resource@1.15.1,安装成功的标志有二,一是dependencies.json中会自动出现一行"vue-resource":"1.15.1",二是在node_modules中出现对应的插件目录.当然,也可以不指定版本号,直接npm install vue-resource,这时就默认安装最新版
2. 使用插件:
"引用并注册"
在main.js中
import VueResource from 'vue-resource'
Vue.use(VueResource);
其实也可以在index.js中vue.use,但是一般index.js都是专门用来写路由的.

3. 关于插件是实例化在index.js还是main.js中的问题
首先插件必须显式注册即vue.use,以router举例
如果router在main.js中注册,则需要
import Router from 'vue-router'
Vue.use(Router);
但是如果是在index.js中注册
main.js中的vue的实例化是:
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
此刻router不是import router from 'vue-router'
而是import Router from './router/index',这样用到的才是实例化后的router

## 第7章,goods列表页开发

## 第8章,food详情页实现

## 第9章,ratings评价列表页实现

## 第10章,seller商家详情页实现

## 第11章,项目编译打包

## 第12章 其他
###  stylus语法
1. 选择器
- 冒号,分号,大括号可写可不写
- 后代关系用相同的缩进,缩进的格数不限制,只要一,缩进了,二,大家一起缩进了
- 父子关系用 > 表示
- 伪类元素用 & 表示其宿主元素
- 属性写在前,嵌套子元素样式写在后
- 分组选择器用相同缩进即可,如+a,+span
###  自定义的组件和引入的插件的区别
自定义的组件指的是vue文件
引入的插件使用就是"引入注册"
组件和插件实现功能都要在export中填写
自定义的组件使用时
  import header from '.....'
  export {component v-header:header}
插件的使用 export new Router(.....)

### export/export default/import的区别
1. 每一个vue文件都是一个类,且变量与方法都是静态
2. export可以有多个返回值,export只能有一个返回值
比如export:
```js
//demo1.js
export const str = 'hello world'
export function f(a){
    return a+1
}
对应的引入方式：
//demo2.js
import { str, f } from 'demo1'//str和f是自定义名
```
比如 export default:
```js
//demo1.js
export default {
    a: 'hello',
    b: 'world'      
}
对应的引入方式：
//demo2.js
import obj from 'demo1'//obj是自定义名
```
