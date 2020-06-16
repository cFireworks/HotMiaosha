package com.cfireworks.admin.service;

import com.cfireworks.admin.entity.IpLog;
import com.cfireworks.admin.query.IpLogQueryObject;
import com.cfireworks.admin.query.PageResult;

public interface IIpLogService {

    PageResult query(IpLogQueryObject qo);

    void insert(IpLog ipLog);

}
