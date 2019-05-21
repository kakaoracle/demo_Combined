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
2. 任何组件安装后都会在node_modules下存在,比如router对应的vue-router
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
  

### 备注

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

## 第6章,header组件开发    

## 第7章,goods列表页开发

## 第8章,food详情页实现

## 第9章,ratings评价列表页实现

## 第10章,seller商家详情页实现

## 第11章,项目编译打包

## 第12章 总结

