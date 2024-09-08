package com.entity.model;

import com.entity.JiaoxiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 驾校信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiaoxiaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 标题
     */
    private String jiaoxiaoName;


    /**
     * 封面
     */
    private String jiaoxiaoPhoto;


    /**
     * 展示类型
     */
    private Integer jiaoxiaoTypes;


    /**
     * 详情信息
     */
    private String jiaoxiaoContent;


    /**
     * 逻辑删除
     */
    private Integer jiaoxiaoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 photoShow
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
	 * 获取：创建时间  show1 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
