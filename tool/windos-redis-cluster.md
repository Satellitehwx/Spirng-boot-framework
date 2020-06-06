# Windos环境部署redis集群

## 一、前期准备
Redis、Ruby语言运行环境、Redis的Ruby驱动redis-xxxx.gem、创建Redis集群的工具redis-trib.rb
### 版本信息
redis: Redis-x64-3.2.100.zip
Ruby: rubyinstaller-2.2.4-x64.exe
redis的Ruby驱动: redis-3.2.2.gem
创建Redis集群的工具: redis-trib.rb

## 二、安装redis
redis下载地址 [url:https://github.com/MSOpenTech/redis/releases] ; 下载Redis-x64-3.2.100.zip.

集群规划有三个节点的集群，每个节点有一主一备。需要6台虚拟机。
把 redis 解压指定盘,(也可以在其他盘，怎么方便怎么来)再复制出 5 份，配置 三主三从集群。 由于 redis 默认端口号为 6379，
我这里吧端口改为了16159,然后其他五个一次改为 16158、16157、16156、16155、16154

##  三、修改配置
redis-16159安装目录下有一个文件 redis.windows.conf，修改里面的端口号，以及集群支持配置。
port 16159
bind 0.0.0.0
修改其他配置支持集群
cluster-enabled yes
cluster-config-file nodes-16159.conf （修改其他几个文件夹的时候nodes-16159.conf 中的16159也要改成相对于的端口）
cluster-node-timeout 15000
appendonly yes
如果cluster-enabled 不为yes， 那么在使用JedisCluster集群代码获取的时候，会报错。
cluster-node-timeout 调整为 15000，那么在创建集群的时候，不会超时。

cluster-config-file nodes-6379.conf 是为该节点的配置信息，这里使用 nodes-端口.conf命名方法。服务启动后会在目录生成该文件。
bind 0.0.0.0 这个表示允许任何主机访问（建议修改） 。

## 四、启动redis服务
在cmd界面依次在redis-16159、redis-16158、redis-16157、redis-16156、redis-16155、redis-16154的目录下执行 redis-server redis.windows.conf
依次启动, 六个redis服务 启动后窗口不关闭,关闭后redis服务就关闭了

## 五、安装Ruby
redis集群使用ruby脚本编写，所以系统需要有 Ruby 环境 ,下载地址 [url:http://dl.bintray.com/oneclick/rubyinstaller/rubyinstaller-2.2.4-x64.exe]
下载后，双击安装即可，安装时这里选中后两个选项,意思是将ruby添加到系统的环境变量中，在cmd命令中能直接使用ruby的命令

## 六、下载Ruby环境下Redis驱动
考虑到兼容性，这里下载的是3.2.2版本
　　下载地址：[url:https://rubygems.org/gems/redis/versions/3.2.2]
将下载的文件放在ruby安装目录下：

安装该驱动，命令如下：gem install --local D:\Ruby22-x64\redis-3.2.2.gem

下载Redis官方提供的创建Redis集群的ruby脚本文件redis-trib.rb 
推荐从官网源文件包里拷贝，网上说的将redis-trib.rb 里的内容拷贝出来 创建成rb文件 可能存在使用脚本创建集群的时候出现创建不成功的状况
[url;https://codeload.github.com/microsoftarchive/redis/zip/win-3.2.100]

压缩包中 src 文件夹下就有改文件

## 七、创建集群
cmd 切换到rb文件所在位置执行创建集群命令
redis-trib.rb create --replicas 1 127.0.0.1:16159 127.0.0.1:16158 127.0.0.1:16157 127.0.0.1:16156 127.0.0.1:16155 127.0.0.1:16154


### 创建集群市出现异常解决办法
1. Waiting for the cluster to joinD:/desoft/Ruby22-x64/lib/ruby/gems/2.2.0/gems/redis-3.2.2/lib/redis/connection/ruby.rb:55:in 
`rescue in _read_from_socket': Connection timed out (Redis::TimeoutError)
在创建集群时 不要用 redis-cli 客户端连接6个节点中某一个

2.D:/desoft/Ruby22-x64/lib/ruby/gems/2.2.0/gems/redis-3.2.2/lib/redis/client.rb:114:in `call': ERR Slot 0 is already busy (Redis::CommandError)
提示大致意思说的时某一个节点中存在数据 此时将各个节点中的数据清空 用 flushall 命令
然后删除各个节点目录下的 nodes-16159.conf 配置文件

