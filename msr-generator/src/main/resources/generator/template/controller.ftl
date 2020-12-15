package ${basePackage}${layer}.controller;
import ${basePackage}${layer}.model.${modelNameUpperCamel};
import ${basePackage}${layer}.service.${modelNameUpperCamel}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.zjh.msr.common.constants.Constant;
import com.zjh.msr.common.model.DataBox;
import javax.annotation.Resource;
import java.util.List;

/**
* @author ${author}
* @date ${date}
*/
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {
    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping("/add")
    public DataBox add(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return DataBox.newInstance(Constant.STATUS_SUCCESS);
    }

    @PostMapping("/delete")
    public DataBox delete(@RequestParam Integer id) {
        ${modelNameLowerCamel}Service.deleteById(id);
        return DataBox.newInstance(Constant.STATUS_SUCCESS);
    }

    @PostMapping("/update")
    public DataBox update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        return DataBox.newInstance(Constant.STATUS_SUCCESS);
    }

    @PostMapping("/detail")
    public DataBox detail(@RequestParam Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        return DataBox.newInstance(Constant.STATUS_SUCCESS,${modelNameLowerCamel});
    }

    @PostMapping("/list")
    public DataBox list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return DataBox.newInstance(Constant.STATUS_SUCCESS,pageInfo);
    }
}
