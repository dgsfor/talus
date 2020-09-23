package com.dgsfor.talus.prometheus;

import io.prometheus.client.Gauge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Async
public class NatGatewayMonitorSnat {
    private static final Logger logger = LoggerFactory.getLogger(NatGatewayMonitorSnat.class);
    @Autowired
    private Gauge processorNatGatewayMonitorSnat;

    @Scheduled(cron = "*/10 * * * * *")
    public void getNatGatewayMonitorSnat(){
        processorNatGatewayMonitorSnat.labels("id-123145","192.168.1.1").set(123);
        logger.info("write success");
    }
}
