package com.cfireworks.order.redis;

public interface KeyPrefix {

    public int getExpireSeconds();

    public String getPrefix();
}
