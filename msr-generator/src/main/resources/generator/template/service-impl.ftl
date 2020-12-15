package ${basePackage}${layer}.service.impl;

import ${basePackage}${layer}.mapper.${modelNameUpperCamel}Mapper;
import ${basePackage}${layer}.model.${modelNameUpperCamel};
import ${basePackage}${layer}.service.${modelNameUpperCamel}Service;
import com.zjh.msr.common.base.AbstractService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


/**
* @author ${author}
* @date ${date}
*/
@Service
public class ${modelNameUpperCamel}ServiceImpl extends AbstractService<${modelNameUpperCamel}> implements ${modelNameUpperCamel}Service {
    @Resource
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

}
