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
 * 考试通知
 *
 * @author 
 * @email
 */
@TableName("kaoshix")
public class KaoshixEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KaoshixEntity() {

	}

	public KaoshixEntity(T t) {
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
     * 通知标题
     */
    @ColumnInfo(comment="通知标题",type="varchar(200)")
    @TableField(value = "kaoshix_name")

    private String kaoshixName;


    /**
     * 通知封面
     */
    @ColumnInfo(comment="通知封面",type="varchar(200)")
    @TableField(value = "kaoshix_photo")

    private String kaoshixPhoto;


    /**
     * 考试类型
     */
    @ColumnInfo(comment="考试类型",type="int(11)")
    @TableField(value = "kaoshix_types")

    private Integer kaoshixTypes;


    /**
     * 考试地址
     */
    @ColumnInfo(comment="考试地址",type="varchar(200)")
    @TableField(value = "kaoshix_address")

    private String kaoshixAddress;


    /**
     * 考试时间
     */
    @ColumnInfo(comment="考试时间",type="varchar(200)")
    @TableField(value = "kaoshix_shijian")

    private String kaoshixShijian;


    /**
     * 截止时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="截止时间",type="timestamp")
    @TableField(value = "kaoshix_time")

    private Date kaoshixTime;


    /**
     * 详情信息
     */
    @ColumnInfo(comment="详情信息",type="longtext")
    @TableField(value = "kaoshix_content")

    private String kaoshixContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "kaoshix_delete")

    private Integer kaoshixDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间     homeMain
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
	 * 获取：通知标题
	 */
    public String getKaoshixName() {
        return kaoshixName;
    }
    /**
	 * 设置：通知标题
	 */

    public void setKaoshixName(String kaoshixName) {
        this.kaoshixName = kaoshixName;
    }
    /**
	 * 获取：通知封面
	 */
    public String getKaoshixPhoto() {
        return kaoshixPhoto;
    }
    /**
	 * 设置：通知封面
	 */

    public void setKaoshixPhoto(String kaoshixPhoto) {
        this.kaoshixPhoto = kaoshixPhoto;
    }
    /**
	 * 获取：考试类型
	 */
    public Integer getKaoshixTypes() {
        return kaoshixTypes;
    }
    /**
	 * 设置：考试类型
	 */

    public void setKaoshixTypes(Integer kaoshixTypes) {
        this.kaoshixTypes = kaoshixTypes;
    }
    /**
	 * 获取：考试地址
	 */
    public String getKaoshixAddress() {
        return kaoshixAddress;
    }
    /**
	 * 设置：考试地址
	 */

    public void setKaoshixAddress(String kaoshixAddress) {
        this.kaoshixAddress = kaoshixAddress;
    }
    /**
	 * 获取：考试时间
	 */
    public String getKaoshixShijian() {
        return kaoshixShijian;
    }
    /**
	 * 设置：考试时间
	 */

    public void setKaoshixShijian(String kaoshixShijian) {
        this.kaoshixShijian = kaoshixShijian;
    }
    /**
	 * 获取：截止时间
	 */
    public Date getKaoshixTime() {
        return kaoshixTime;
    }
    /**
	 * 设置：截止时间
	 */

    public void setKaoshixTime(Date kaoshixTime) {
        this.kaoshixTime = kaoshixTime;
    }
    /**
	 * 获取：详情信息
	 */
    public String getKaoshixContent() {
        return kaoshixContent;
    }
    /**
	 * 设置：详情信息
	 */

    public void setKaoshixContent(String kaoshixContent) {
        this.kaoshixContent = kaoshixContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getKaoshixDelete() {
        return kaoshixDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setKaoshixDelete(Integer kaoshixDelete) {
        this.kaoshixDelete = kaoshixDelete;
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
	 * 获取：创建时间     homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间     homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Kaoshix{" +
            ", id=" + id +
            ", kaoshixName=" + kaoshixName +
            ", kaoshixPhoto=" + kaoshixPhoto +
            ", kaoshixTypes=" + kaoshixTypes +
            ", kaoshixAddress=" + kaoshixAddress +
            ", kaoshixShijian=" + kaoshixShijian +
            ", kaoshixTime=" + DateUtil.convertString(kaoshixTime,"yyyy-MM-dd") +
            ", kaoshixContent=" + kaoshixContent +
            ", kaoshixDelete=" + kaoshixDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
