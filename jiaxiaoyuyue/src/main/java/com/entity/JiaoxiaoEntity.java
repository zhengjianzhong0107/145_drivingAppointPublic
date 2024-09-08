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
 * 驾校信息
 *
 * @author 
 * @email
 */
@TableName("jiaoxiao")
public class JiaoxiaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaoxiaoEntity() {

	}

	public JiaoxiaoEntity(T t) {
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
     * 标题
     */
    @ColumnInfo(comment="标题",type="varchar(200)")
    @TableField(value = "jiaoxiao_name")

    private String jiaoxiaoName;


    /**
     * 封面
     */
    @ColumnInfo(comment="封面",type="varchar(200)")
    @TableField(value = "jiaoxiao_photo")

    private String jiaoxiaoPhoto;


    /**
     * 展示类型
     */
    @ColumnInfo(comment="展示类型",type="int(11)")
    @TableField(value = "jiaoxiao_types")

    private Integer jiaoxiaoTypes;


    /**
     * 详情信息
     */
    @ColumnInfo(comment="详情信息",type="longtext")
    @TableField(value = "jiaoxiao_content")

    private String jiaoxiaoContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "jiaoxiao_delete")

    private Integer jiaoxiaoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：标题
	 */
    public String getJiaoxiaoName() {
        return jiaoxiaoName;
    }
    /**
	 * 设置：标题
	 */

    public void setJiaoxiaoName(String jiaoxiaoName) {
        this.jiaoxiaoName = jiaoxiaoName;
    }
    /**
	 * 获取：封面
	 */
    public String getJiaoxiaoPhoto() {
        return jiaoxiaoPhoto;
    }
    /**
	 * 设置：封面
	 */

    public void setJiaoxiaoPhoto(String jiaoxiaoPhoto) {
        this.jiaoxiaoPhoto = jiaoxiaoPhoto;
    }
    /**
	 * 获取：展示类型
	 */
    public Integer getJiaoxiaoTypes() {
        return jiaoxiaoTypes;
    }
    /**
	 * 设置：展示类型
	 */

    public void setJiaoxiaoTypes(Integer jiaoxiaoTypes) {
        this.jiaoxiaoTypes = jiaoxiaoTypes;
    }
    /**
	 * 获取：详情信息
	 */
    public String getJiaoxiaoContent() {
        return jiaoxiaoContent;
    }
    /**
	 * 设置：详情信息
	 */

    public void setJiaoxiaoContent(String jiaoxiaoContent) {
        this.jiaoxiaoContent = jiaoxiaoContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJiaoxiaoDelete() {
        return jiaoxiaoDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setJiaoxiaoDelete(Integer jiaoxiaoDelete) {
        this.jiaoxiaoDelete = jiaoxiaoDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jiaoxiao{" +
            ", id=" + id +
            ", jiaoxiaoName=" + jiaoxiaoName +
            ", jiaoxiaoPhoto=" + jiaoxiaoPhoto +
            ", jiaoxiaoTypes=" + jiaoxiaoTypes +
            ", jiaoxiaoContent=" + jiaoxiaoContent +
            ", jiaoxiaoDelete=" + jiaoxiaoDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
