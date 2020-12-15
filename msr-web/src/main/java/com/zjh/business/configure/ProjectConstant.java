package com.zjh.business.configure;

/**
 * Created by wei.li12 on 2017/8/9.
 */
public interface ProjectConstant {
    String BASE_PACKAGE = "com.zjh.business";//项目基础包名称，根据自己公司的项目修改
    String MODEL_PACKAGE = BASE_PACKAGE + ".**.model";//Model所在包
    String MAPPER_PACKAGE = BASE_PACKAGE + ".**.mapper";//Mapper所在包
    String SERVICE_PACKAGE = BASE_PACKAGE + ".**.service";//Service所在包
    String MAPPER_INTERFACE_REFERENCE = "com.zjh.msr.common.mapper.Mapper";
}
