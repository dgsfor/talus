package com.dgsfor.talus.prometheus;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricConfig {
    @Autowired
    public CollectorRegistry collectorRegistry;

    /**
     * nat网关监控(SNAT)，单条数据包含网关id，nodeip，以及snat连接数
     * @return
     */
    @Bean
    Gauge processorNatGatewayMonitorSnat(){
        return Gauge.build().name("processorNatGatewayMonitor_snat")
                .labelNames("natgatewayid","nodeip")
                .help("processorNatGatewayMonitorSnat：record by gatewayid and nodeip")
                .register(collectorRegistry);
    }

    /**
     * Conunter的指标定义
     */
    @Bean
    Counter processorNginxIngressRequest(){
        return Counter.build().name("processorNginxIngress_request")
                .labelNames("ingressname","domain")
                .help("processorNginxIngressRequest : domain")
                .register(collectorRegistry);
    }
}
