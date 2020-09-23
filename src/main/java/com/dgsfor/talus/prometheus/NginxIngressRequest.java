package com.dgsfor.talus.prometheus;

import io.prometheus.client.Counter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class NginxIngressRequest {
    private static final Logger logger = LoggerFactory.getLogger(NginxIngressRequest.class);
    @Autowired
    private Counter processorNginxIngressRequest;

    @GetMapping("/ingressRequest")
    public Map TestIngressRequest(){
        processorNginxIngressRequest.labels("ingress1","ingress.dgsfor.com").inc();
        Map<String,Object> result = new HashMap<>();
        result.put("counter success",true);
        logger.info("counter success");
        return result;
    }
}
