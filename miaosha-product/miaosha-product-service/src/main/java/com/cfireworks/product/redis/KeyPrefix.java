package com.cfireworks.product.redis;

public interface KeyPrefix {

    public int getExpireSeconds();

    public String getPrefix();
}
