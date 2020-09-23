### 介绍

塔罗斯(Talus)

塔罗斯（希腊语：Ταλως；英语：Talos / Talus）是希腊神话中的机械巨人（Automaton）。该名义为“砍伐”或“太阳”。塔罗斯的身世有三种版本。按赫西奥德（Hesiod）的说法，宙斯曾创造了四代人类：黄金、白银、青铜、黑铁。

### 功能

后期主要提供给thanos运维数据，提供prometheus接口

### 接口

输出接口：`/talus/metrics/prometheus`


### 访问地址

```shell script
http://localhost:9000/talus/metrics/prometheus
```


### 例子

我这边写了几个例子，分别对应的指标类型为：Counter、Guage、Histogram、Summary，对应的指标定义在：`MetricConfig.java`中可以看到

指标说明：

|指标|指标说明|
|----|----
|Counter|Counter类型代表一种样本数据单调递增的指标，即只增不减，除非监控系统发生了重置
|Guage|Guage类型代表一种样本数据可以任意变化的指标，即可增可减
|Histogram|Histogram 由bucket{le=""}，bucket{le="+Inf"},sum，count 组成，主要用于表示一段时间范围内对数据进行采样（通常是请求持续时间或响应大小），并能够对其指定区间以及总数进行统计，通常它采集的数据展示为直方图
|Summary|Summary 和 Histogram 类似，由{quantile="<φ>"}，sum，count 组成，主要用于表示一段时间内数据采样结果（通常是请求持续时间或响应大小），它直接存储了 quantile 数据，而不是根据统计区间计算出来的。


我简单写了两个例子去实现counter和guage指标：

|指标名称|类名称|
|----|----
|Counter|NginxIngressRequest|
|Guage|NatGatewayMonitorSnat|

查看exportor的结果可以看到如下内容：

```shell script
# HELP processorNatGatewayMonitor_snat processorNatGatewayMonitorSnat：record by gatewayid and nodeip
# TYPE processorNatGatewayMonitor_snat gauge
processorNatGatewayMonitor_snat{natgatewayid="id-123145",nodeip="192.168.1.1",} 123.0
```

```shell script
# HELP processorNginxIngress_request processorNginxIngressRequest : domain
# TYPE processorNginxIngress_request counter
processorNginxIngress_request{ingressname="ingress1",domain="ingress.dgsfor.com",} 7.0
```