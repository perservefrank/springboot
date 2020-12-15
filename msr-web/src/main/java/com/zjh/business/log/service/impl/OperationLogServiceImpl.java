package com.zjh.business.log.service.impl;

import com.zjh.msr.common.base.AbstractService;
import com.zjh.business.log.mapper.OperationLogMapper;
import com.zjh.business.log.model.OperationLog;
import com.zjh.business.log.service.OperationLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
* @author frank.zhao
* @date 2020/12/15
*/
@Service
public class OperationLogServiceImpl extends AbstractService<OperationLog> implements OperationLogService {
    @Resource
    private OperationLogMapper operationLogMapper;

}
