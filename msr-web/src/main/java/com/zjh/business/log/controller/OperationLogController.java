package com.zjh.business.log.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjh.msr.common.constants.Constant;
import com.zjh.msr.common.model.DataBox;
import com.zjh.business.log.model.OperationLog;
import com.zjh.business.log.service.OperationLogService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* @author frank.zhao
* @date 2020/12/15
*/
@RestController
@RequestMapping("/operation/log")
public class OperationLogController {
    @Resource
    private OperationLogService operationLogService;

    @PostMapping("/add")
    public DataBox add(OperationLog operationLog) {
        XmlBeanFactory
        operationLogService.save(operationLog);
        return DataBox.newInstance(Constant.STATUS_SUCCESS);
    }

    @PostMapping("/delete")
    public DataBox delete(@RequestParam Integer id) {
        operationLogService.deleteById(id);
        return DataBox.newInstance(Constant.STATUS_SUCCESS);
    }

    @PostMapping("/update")
    public DataBox update(OperationLog operationLog) {
        operationLogService.update(operationLog);
        return DataBox.newInstance(Constant.STATUS_SUCCESS);
    }

    @PostMapping("/detail")
    public DataBox detail(@RequestParam Integer id) {
        OperationLog operationLog = operationLogService.findById(id);
        return DataBox.newInstance(Constant.STATUS_SUCCESS,operationLog);
    }

    @PostMapping("/list")
    public DataBox list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<OperationLog> list = operationLogService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return DataBox.newInstance(Constant.STATUS_SUCCESS,pageInfo);
    }
}
