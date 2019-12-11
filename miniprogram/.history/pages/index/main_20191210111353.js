// pages/index/main.js
//import { request1 } from "../../request/index.js";

Page({
  data:{
    //轮播图数组
    swiperList:[]
  },
  //页面开始加载,就会触发
  onLoad: function(options){
    //1, 发送异步请求,第二个请求需要等待第一个请求发送成功再发送,类推的话代码极其臃肿,因此用es6
    //中的promise
    //////用promise---then进行封装处理
    // wx.request({
    //   url: 'https://api.zbztb.cn/api/public/v1/home/swiperdata',
    //   success: (result) =>{
    //     this.setData({
    //       swiperList:result.data.message
    //     })
    //   }
    // })
    request1({url:"https://api.zbztb.cn/api/public/v1/home/swiperdata"})
    .then(() =>{
      /* this.setData({
        swiperList:result.data.message   
      }) */
      console.log("11111")
    });
  },
})
