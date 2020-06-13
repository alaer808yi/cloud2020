package com.longjing.springcloud.service.impl;

import com.longjing.springcloud.dao.PaymentMapper;
import com.longjing.springcloud.entities.Payment;
import com.longjing.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：jane.
 * @ Date       ：Created in 19:52 2020/5/24
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;
    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int save(Payment payment) {
        return paymentMapper.insert(payment);
    }
}
