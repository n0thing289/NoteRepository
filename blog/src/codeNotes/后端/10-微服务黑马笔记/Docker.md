---
title: Docker笔记
date: 2024-05-16
---

## 删除镜像

`docker rmi 镜像名:版本号`



## 自定义镜像

>[dockerfile详解_在dockerfile里面crstool是什么意思呢?-CSDN博客](https://blog.csdn.net/luyinxing1/article/details/97398320)
>
>[Dockerfile Copy 上级路径文件_dockerfile copy 上层目录文件-CSDN博客](https://blog.csdn.net/zuidenaoshi/article/details/132717020)

1. 写dockerfile

   ```dockerfile
   # 基础镜像（可以多个）
   FROM openjdk:11.0-jre-buster
   # 设定时区
   ENV TZ=Asia/Shanghai
   RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
   # 复制文件
   COPY cart/cart-service.jar /app.jar
   COPY api_common/hm-api-1.0.0.jar /hm-api-1.0.0.jar
   COPY api_common/hm-common-1.0.0.jar /hm-common-1.0.0.jar
   # 入口，运行命令
   ENTRYPOINT ["java", "-jar", "/app.jar"]
   ```

   注意路径, 根本思路是你想在哪里敲命令(你想在引用的顶层敲命令构建, 那么路径就应该写成从最上层jar开始)

   ```yaml
   # 上示目录结构
   jar:
     cart: 
       cart-service.jar
     api_common:
       hm-api-1.0.0.jar
       hm-common-1.0.0.jar
   ```

2. 构建镜像的命令

   ```bash
   docker build -t cart-service -f cart/cart-Dockerfile .
   ```

   那个 `.`别忘记了, 代表context 从当前目录开始执行命令/寻找文件(后续需要复制上一级目录里的内容都可以找得到, 因为都在jar里)!

## docker compose

- 我有很多的微服务需要部署, 难道每次创建容器都要进入微服务目录每次手敲启动命令吗?
- docker compose 一键创建容器并允许

1. 写docker-compose.yml文件

   ```yaml
   # yaml 配置实例
   version: '1'
   
   networks:
     hm-net: # hm-net这个只是标识符， 最后自定义网络的名字还是hmall
       name: hmall
   
   services:
     # 所有服务
     cart-service:
       build: 
         context: . # 这里的context是继承自compose文件所在的上下文
         dockerfile: cart/cart-Dockerfile
       ports:
         - "8082:8082"
       networks:
         - hm-net
       # volumes:
         # -
       # depends_on:
         # - 
     #...
   ```

   services: 里其实就是写多个镜像或者Dockerfile的启动相关的配置

   build: 就是通过Dockerfile来构建镜像context 和dockerfile和构建镜像命令是一样的意义

   ports: 和docker run -p xxxx:xxxx 一个意思; 与宿主机双向绑定端口

   networks: 加入到自定义网络, 自定义网络内直接通过容器名通信

   volumes: 映射数据卷; 与宿主机某个文件或目录双向绑定

   depends_on: 表示依赖某个容器, 被依赖的容器会优先创建

2. 运行docker compose命令

   ```bash
   docker compose up # docker-compose.yml在当前目录就可以这样简写
   ```

   

