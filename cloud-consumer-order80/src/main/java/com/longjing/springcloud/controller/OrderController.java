package com.longjing.springcloud.controller;

import com.longjing.springcloud.entities.CommonResult;
import com.longjing.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ Author     ：jane.
 * @ Date       ：Created in 0:37 2020/5/26
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@RequestMapping("/order")
@RestController
@Slf4j
@PropertySource("classpath:order.consumer.properties")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${payment.service.instance}")
    private String paymentServiceInstanceName;


    @RequestMapping("/consumer/create")
    public CommonResult order(Payment payment) {
        return restTemplate.postForObject("http://" + paymentServiceInstanceName + "/payment/pay/save",
                payment, CommonResult.class);
    }

    @RequestMapping("/consumer/find/{id}")
    public CommonResult findOrder(@PathVariable Long id) {
        return restTemplate.getForObject("http://" + paymentServiceInstanceName + "/payment/pay/find/" + id,
                CommonResult.class);
    }
}
