package com.zjh.generator;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author wei.li12
 * @date 2017/8/9
 */
public final class ProjectConstant {

    /**
     * 业务层
     * */
    public static final String LAYER = ".testg";

    /**
     * 模块名
     * */
    public static final String MOUDLE_NAME = "msr-generator";

    /**
     * 项目基础包路径
    */
    public static final String BASE_PACKAGE = "com.zjh.projectspringboot.business";

    /**
     * Mapper 类路径
     * */
    public static final String MAPPER_INTERFACE_REFERENCE = "com.zjh.msr.common.mapper.Mapper";

    /**
     * @author
     * */
    public static final String AUTHOR = "frank.zhao";

    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/dev?useUnicode=true&characterEncoding=utf-8";

    public static final String JDBC_USERNAME = "root";

    public static final String JDBC_PASSWORD = "root";

    public static final String JDBC_DIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

    /**
     * model所在包
     * */
    public static final String MODEL_PACKAGE = BASE_PACKAGE + LAYER + ".model";

    /**
     * Mapper所在包
     * */
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + LAYER + ".mapper";

    /**
     * Service所在包
     * */
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + LAYER + ".service";

    /**
     * ServiceImpl所在包
     * */
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";

    /**
     * Controller所在包
     * */
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + LAYER + ".controller";

    /**
     * 项目在硬盘上的基础路径
     * */
    public static final String PROJECT_PATH = System.getProperty("user.dir");

    /**
     * 模板位置
     * */
    public static final String TEMPLATE_FILE_PATH = PROJECT_PATH + "/msr-generator/src/main/resources/generator/template";
    /**
     * java文件路径
     * */
    public static final String JAVA_PATH = "/" + MOUDLE_NAME + "/src/main/java";
    /**
     * 资源文件路径
     * */
    public static final String RESOURCES_PATH = "/" + MOUDLE_NAME +"/src/main/resources";

    public static final String DATE = new SimpleDateFormat("yyyy/MM/dd").format(new Date());

}
