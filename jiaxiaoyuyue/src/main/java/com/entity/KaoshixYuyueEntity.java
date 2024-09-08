package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 考试预约
 *
 * @author 
 * @email
 */
@TableName("kaoshix_yuyue")
public class KaoshixYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KaoshixYuyueEntity() {

	}

	public KaoshixYuyueEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 预约编号
     */
    @ColumnInfo(comment="预约编号",type="varchar(200)")
    @TableField(value = "kaoshix_yuyue_uuid_number")

    private String kaoshixYuyueUuidNumber;


    /**
     * 考试
     */
    @ColumnInfo(comment="考试",type="int(11)")
    @TableField(value = "kaoshix_id")

    private Integer kaoshixId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 预约状态
     */
    @ColumnInfo(comment="预约状态",type="int(11)")
    @TableField(value = "kaoshix_yuyue_yesno_types")

    private Integer kaoshixYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "kaoshix_yuyue_yesno_text")

    private String kaoshixYuyueYesnoText;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "KaoshixYuyue{" +
            ", id=" + id +
            ", kaoshixYuyueUuidNumber=" + kaoshixYuyueUuidNumber +
            ", kaoshixId=" + kaoshixId +
            ", yonghuId=" + yonghuId +
            ", kaoshixYuyueYesnoTypes=" + kaoshixYuyueYesnoTypes +
            ", kaoshixYuyueYesnoText=" + kaoshixYuyueYesnoText +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
