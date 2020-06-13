package com.longjing.springcloud.service;

import com.longjing.springcloud.entities.Payment;

/**
 * @ Author     ：jane.
 * @ Date       ：Created in 19:51 2020/5/24
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public interface PaymentService {
    Payment getPaymentById(Long id);

    int save(Payment payment);

}
