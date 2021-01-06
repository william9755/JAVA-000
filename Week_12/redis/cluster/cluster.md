#### redis cluster(windows  redis-5.0.10)
##### 1、配置
1. 修改 redis 的配置文件，开启集群模式
```shell
cluster-enabled yes
cluster-config-file nodes.conf
cluster-node-timeout 15000
```
2. 复制多份 redis，并修改相应的端口

##### 2、测试
```shell
# 1. 启动配置好的 redis cluster 节点
# 2. 创建集群
redis-cli --cluster create 127.0.0.1:10000 127.0.0.1:10001 127.0.0.1:10002 127.0.0.1:10003 127.0.0.1:10004 127.0.0.1:10005 --cluster-replicas 1

# 3. 查看集群效果
redis-cli -c -p 10000
set testkey1 11111
set keytest2 22222
```