package com.longjing.springcloud.dao;

import com.longjing.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface PaymentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
}