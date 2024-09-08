package com.entity.model;

import com.entity.KaoshixYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 考试预约
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KaoshixYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 预约编号
     */
    private String kaoshixYuyueUuidNumber;


    /**
     * 考试
     */
    private Integer kaoshixId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 预约状态
     */
    private Integer kaoshixYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String kaoshixYuyueYesnoText;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：预约编号
	 */
    public String getKaoshixYuyueUuidNumber() {
        return kaoshixYuyueUuidNumber;
    }


    /**
	 * 设置：预约编号
	 */
    public void setKaoshixYuyueUuidNumber(String kaoshixYuyueUuidNumber) {
        this.kaoshixYuyueUuidNumber = kaoshixYuyueUuidNumber;
    }
    /**
	 * 获取：考试
	 */
    public Integer getKaoshixId() {
        return kaoshixId;
    }


    /**
	 * 设置：考试
	 */
    public void setKaoshixId(Integer kaoshixId) {
        this.kaoshixId = kaoshixId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：预约状态
	 */
    public Integer getKaoshixYuyueYesnoTypes() {
        return kaoshixYuyueYesnoTypes;
    }


    /**
	 * 设置：预约状态
	 */
    public void setKaoshixYuyueYesnoTypes(Integer kaoshixYuyueYesnoTypes) {
        this.kaoshixYuyueYesnoTypes = kaoshixYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getKaoshixYuyueYesnoText() {
        return kaoshixYuyueYesnoText;
    }


    /**
	 * 设置：审核回复
	 */
    public void setKaoshixYuyueYesnoText(String kaoshixYuyueYesnoText) {
        this.kaoshixYuyueYesnoText = kaoshixYuyueYesnoText;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
