package com.longjing.springcloud.entities;

import java.io.Serializable;


public class Payment implements Serializable {
    private static final long serialVersionUID = -1351614008458894215L;
    private Long id;

    private String serial;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial == null ? null : serial.trim();
    }
}