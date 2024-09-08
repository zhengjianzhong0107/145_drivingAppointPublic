package com.entity.model;

import com.entity.KaoshixEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 考试通知
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KaoshixModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 通知标题
     */
    private String kaoshixName;


    /**
     * 通知封面
     */
    private String kaoshixPhoto;


    /**
     * 考试类型
     */
    private Integer kaoshixTypes;


    /**
     * 考试地址
     */
    private String kaoshixAddress;


    /**
     * 考试时间
     */
    private String kaoshixShijian;


    /**
     * 截止时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date kaoshixTime;


    /**
     * 详情信息
     */
    private String kaoshixContent;


    /**
     * 逻辑删除
     */
    private Integer kaoshixDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow homeMain
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
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
