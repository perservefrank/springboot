package com.zjh.business.log.model;

import javax.persistence.*;

@Table(name = "operation_log")
public class OperationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 被记录日志表名
     */
    private String tablename;

    /**
     * 被记录日志ID
     */
    private Integer tableid;

    /**
     * 操作时间
     */
    @Column(name = "operation_time")
    private String operationTime;

    /**
     * 操作积分
     */
    @Column(name = "operation_integral")
    private Integer operationIntegral;

    /**
     * 操作人员
     */
    private String operationer;

    /**
     * 描述
     */
    @Column(name = "operation_description")
    private String operationDescription;

    /**
     * 项目ID
     */
    private Integer projectid;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取被记录日志表名
     *
     * @return tablename - 被记录日志表名
     */
    public String getTablename() {
        return tablename;
    }

    /**
     * 设置被记录日志表名
     *
     * @param tablename 被记录日志表名
     */
    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    /**
     * 获取被记录日志ID
     *
     * @return tableid - 被记录日志ID
     */
    public Integer getTableid() {
        return tableid;
    }

    /**
     * 设置被记录日志ID
     *
     * @param tableid 被记录日志ID
     */
    public void setTableid(Integer tableid) {
        this.tableid = tableid;
    }

    /**
     * 获取操作时间
     *
     * @return operation_time - 操作时间
     */
    public String getOperationTime() {
        return operationTime;
    }

    /**
     * 设置操作时间
     *
     * @param operationTime 操作时间
     */
    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime;
    }

    /**
     * 获取操作积分
     *
     * @return operation_integral - 操作积分
     */
    public Integer getOperationIntegral() {
        return operationIntegral;
    }

    /**
     * 设置操作积分
     *
     * @param operationIntegral 操作积分
     */
    public void setOperationIntegral(Integer operationIntegral) {
        this.operationIntegral = operationIntegral;
    }

    /**
     * 获取操作人员
     *
     * @return operationer - 操作人员
     */
    public String getOperationer() {
        return operationer;
    }

    /**
     * 设置操作人员
     *
     * @param operationer 操作人员
     */
    public void setOperationer(String operationer) {
        this.operationer = operationer;
    }

    /**
     * 获取描述
     *
     * @return operation_description - 描述
     */
    public String getOperationDescription() {
        return operationDescription;
    }

    /**
     * 设置描述
     *
     * @param operationDescription 描述
     */
    public void setOperationDescription(String operationDescription) {
        this.operationDescription = operationDescription;
    }

    /**
     * 获取项目ID
     *
     * @return projectid - 项目ID
     */
    public Integer getProjectid() {
        return projectid;
    }

    /**
     * 设置项目ID
     *
     * @param projectid 项目ID
     */
    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }
}