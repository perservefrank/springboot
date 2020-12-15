package com.zjh.msr.common.mapper;


import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;

/**
 * 批量插入，支持批量插入的数据库可以使用，例如MySQL,H2等
 * <p>
 * 参数 InsertListMapper 不支持主键策略，
 * 插入前需要设置好主键的值
 * 区别于Mapper中InsertListMapper主键自增策略
 * <p>
 * 特别注意：2018-04-22 后，该方法支持 @KeySql 注解的 genId 方式
*/
public interface AdditionalMapper<T>  extends
        BaseMapper<T>,
        ConditionMapper<T>,
        IdsMapper<T>,
        InsertListMapper<T> , ExampleMapper<T> {
}
