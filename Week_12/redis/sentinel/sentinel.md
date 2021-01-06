#### redis sentinel(windows  redis-5.0.10)
##### 1、配置
1. 配置 redis 主从
2. 创建 redis.sentinel.conf 配置文件，内容如下
```shell
# sentinel 使用的端口
port 30001
# 避免脚本重置
sentinel deny-scripts-reconfig yes
# sentinel 监听的地址和端口，后面的数字是指当有多少个 sentinel 认为一个 master 失效时，master 才算真正失效
sentinel monitor mymaster 127.0.0.1 6379 2
# 失效时间，master 超过这个时间无应答则会被 sentinel 认为是不可用的，单位是毫秒
sentinel down-after-milliseconds mymaster 5000
# 故障转移超时
sentinel failover-timeout mymaster 15000
```
##### 2、测试
```shell
# 开启主从和 sentinel
redis-server redis.windows.conf
redis-server redis.sentinel.conf --sentinel

# 登录主节点和从节点，查看状态
redis-cli -h 127.0.0.1 -p 6379
info replication

redis-cli -h 127.0.0.1 -p 6380
info replication
```
可以看到当前主节点的 role 为 master，从节点的 role 为 slave。

```shell
# 关闭主节点，并登录从节点再次查看状态
redis-cli -h 127.0.0.1 -p 6380
info replication
```
这时从节点的 role 变为了 master