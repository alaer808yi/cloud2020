package com.longjing.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ Author     ：jane.
 * @ Date       ：Created in 12:57 2020/5/24
 * @ Description：payment主类
 * @ Modified By：
 * @Version: 1.0$
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentApplication {
    public static void main(String[] args){
        SpringApplication.run(PaymentApplication.class,args);
    }

}
