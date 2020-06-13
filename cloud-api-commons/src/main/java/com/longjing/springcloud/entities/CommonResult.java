package com.longjing.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author     ：jane.
 * @ Date       ：Created in 17:57 2020/5/24
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private String code;
    private String message;
    private T data;

    public CommonResult(String code,String message){
        this(code,message,null);
    }
}
