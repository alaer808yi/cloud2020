package com.longjing.springcloud.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.longjing.springcloud.entities.CommonResult;
import com.longjing.springcloud.entities.Payment;
import com.longjing.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ Author     ：jane.
 * @ Date       ：Created in 17:14 2020/5/24
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@RequestMapping("/pay")
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/test")
    public Object test() {
        return "test";
    }

    @RequestMapping("/find/{id}")
    public CommonResult<Payment> test2(@PathVariable Long id) throws Exception {
        Payment payment = paymentService.getPaymentById(id);
        ObjectMapper mapper = new ObjectMapper();

        log.info("payment:{} find", mapper.writeValueAsString(payment));
        return new CommonResult<Payment>("200", "success" + port, payment);
    }

    @RequestMapping(value = "/save/{serial}", method = RequestMethod.POST)
    public CommonResult<Payment> test3(@PathVariable String serial) {
        Payment payment = new Payment();
        payment.setSerial(serial);
        int i = paymentService.save(payment);
        log.info("insert {} data", i);
        return new CommonResult<Payment>("200", "成功" + port, payment);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public CommonResult<Payment> test4(@RequestBody Payment payment) {
        int i = paymentService.save(payment);
        log.info("insert {} data", i);
        return new CommonResult<Payment>("200", "成功" + port, payment);
    }

    @GetMapping("/discovery")
    public Object discovery() throws JsonProcessingException {
        List<String> services = discoveryClient.getServices();
        ObjectMapper mapper = new ObjectMapper();
        log.info("services: {}", mapper.writeValueAsString(services));
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        log.info("instances:{}", mapper.writeValueAsString(instances));
        return instances;
    }
}
