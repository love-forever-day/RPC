#与easy-rpc的区别
easy-rpc对服务提供方和消费者的很多配置都进行了静态化处理

不利于维护。

在rpc-core中我们将要通过读取配置文件来进行对项目进行自定义配置

#设计方案

先从小到大。

一个项目拥有：
    name(名称)
    version(版本号)
    serverHost(服务器主机名)
    serverPort(服务器端口号)

通过Hutool的Setting模块指定读取名称的配置文件的部分配置信息
