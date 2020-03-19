#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
/*
用来操作linux,在linux中执行该文件即可建立socket连接
*/
void conn(){

    char recv_buf[1024]=""; 

    // 网络地址结构
    struct sockaddr_in my_addr;
    // 设置为ip4
    my_addr.sin_family = AF_INET;
    my_addr.sin_port = htons(80);
    // 设置ip地址为本机
    my_addr.sin_addr.s_addr = htonl(INADDR_ANY);

    // 客户端ip地址结构
    struct sockaddr_in client_addr;


    int listenfd = socket(AF_INET,SOCK_STREAM,0);
    bind(listenfd,(struct sockaddr *)&my_addr,sizeof(my_addr));
    // 同时接收128个连接
    listen(listenfd,128);
    // 长度指针
    socklen_t cliaddr_len = sizeof(client_addr);
    // 将client_addr强转为指针,&取地址
    int clientfd = accept(listenfd,(struct sockaddr*)&client_addr,&cliaddr_len);
    // 循环读通信套接字文件
    while(1){
       int k =  read(clientfd,recv_buf,sizeof(recv_buf));
       if( k>0){
           printf("%s\n",recv_buf);
       }
    }
}

int main(){
    conn();
    return 0;
}