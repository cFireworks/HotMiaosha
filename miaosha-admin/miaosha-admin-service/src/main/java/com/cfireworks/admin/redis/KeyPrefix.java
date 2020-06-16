package com.cfireworks.admin.redis;

public interface KeyPrefix {

    public int getExpireSeconds();

    public String getPrefix();
}
