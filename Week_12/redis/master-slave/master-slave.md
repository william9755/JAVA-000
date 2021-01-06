#### redis 主从(windows  redis-5.0.10)
##### 1、配置
1. 将安装好的 redis 复制一份，命名为 redis-slave, 并修改 redis-slave 的 redis.windows.conf 配置文件
```shell
# 修改端口
port 6380
# 主从配置
slaveof 127.0.0.1 6379
```
##### 2、测试
```shell
# 启动主从实例
redis-server redis.windows.conf

# 在主节点增加数据
redis-cli -h 127.0.0.1 -p 6379
set testkey 11111

# 在从节点查看数据
redis-cli -h 127.0.0.1 -p 6380
get testkey
```