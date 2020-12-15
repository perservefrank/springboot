package com.zjh.business.configure;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author frank.zhao
 * @date 2020/12/15
 */
@Configuration
public class MybatisConfigurer implements TransactionManagementConfigurer {

    @Resource
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTypeAliasesPackage(ProjectConstant.MODEL_PACKAGE);

        //配置分页插件，详情请查阅官方文档
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        //分页尺寸为0时查询所有纪录不再执行分页
        properties.setProperty("pageSizeZero", "true");
        //页码<=0 查询第一页，页码>=总页数查询最后一页
        properties.setProperty("reasonable", "true");
        //支持通过 Mapper 接口参数来传递分页参数
        properties.setProperty("supportMethodsArguments", "true");
        pageHelper.setProperties(properties);

        //添加插件
        factory.setPlugins(new Interceptor[]{pageHelper});
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        return factory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name="platformTransactionManager")
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }


    //platformTransactionManager 为springboot默认初始化好的对象，，无需定义
    @Bean(name = "mmqbtransactionInterceptor")
    public TransactionInterceptor transactionInterceptor(PlatformTransactionManager platformTransactionManager) {
        TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
        // 事物管理器
        transactionInterceptor.setTransactionManager(platformTransactionManager);
        Properties transactionAttributes = new Properties();
        // 新增
        transactionAttributes.setProperty("insert*","PROPAGATION_REQUIRED,-Throwable");
        // 修改
        transactionAttributes.setProperty("update*","PROPAGATION_REQUIRED,-Throwable");
        // 删除
        transactionAttributes.setProperty("delete*","PROPAGATION_REQUIRED,-Throwable");
        //查询
        transactionAttributes.setProperty("select*","PROPAGATION_REQUIRED,-Throwable");
        //查询
        transactionAttributes.setProperty("get*","PROPAGATION_REQUIRED,-Throwable");
        //业务处理
        transactionAttributes.setProperty("deal*","PROPAGATION_REQUIRED,-Throwable");
        //new事务
        transactionAttributes.setProperty("requiresNew*","PROPAGATION_REQUIRES_NEW,-Throwable");

        transactionInterceptor.setTransactionAttributes(transactionAttributes);
        return transactionInterceptor;
    }

   /* //代理到ServiceImpl的Bean
    @Bean
    public BeanNameAutoProxyCreator transactionAutoProxy() {
        BeanNameAutoProxyCreator transactionAutoProxy = new BeanNameAutoProxyCreator();
        transactionAutoProxy.setProxyTargetClass(true);
        transactionAutoProxy.setBeanNames("*ServiceImpl");
        transactionAutoProxy.setInterceptorNames("mmqbtransactionInterceptor");
        return transactionAutoProxy;
    }*/

}

