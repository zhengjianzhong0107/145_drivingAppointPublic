package com.entity.vo;

import com.entity.JiaoxiaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 驾校信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiaoxiao")
public class JiaoxiaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 标题
     */

    @TableField(value = "jiaoxiao_name")
    private String jiaoxiaoName;


    /**
     * 封面
     */

    @TableField(value = "jiaoxiao_photo")
    private String jiaoxiaoPhoto;


    /**
     * 展示类型
     */

    @TableField(value = "jiaoxiao_types")
    private Integer jiaoxiaoTypes;


    /**
     * 详情信息
     */

    @TableField(value = "jiaoxiao_content")
    private String jiaoxiaoContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "jiaoxiao_delete")
    private Integer jiaoxiaoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：标题
	 */
    public String getJiaoxiaoName() {
        return jiaoxiaoName;
    }


    /**
	 * 获取：标题
	 */

    public void setJiaoxiaoName(String jiaoxiaoName) {
        this.jiaoxiaoName = jiaoxiaoName;
    }
    /**
	 * 设置：封面
	 */
    public String getJiaoxiaoPhoto() {
        return jiaoxiaoPhoto;
    }


    /**
	 * 获取：封面
	 */

    public void setJiaoxiaoPhoto(String jiaoxiaoPhoto) {
        this.jiaoxiaoPhoto = jiaoxiaoPhoto;
    }
    /**
	 * 设置：展示类型
	 */
    public Integer getJiaoxiaoTypes() {
        return jiaoxiaoTypes;
    }


    /**
	 * 获取：展示类型
	 */

    public void setJiaoxiaoTypes(Integer jiaoxiaoTypes) {
        this.jiaoxiaoTypes = jiaoxiaoTypes;
    }
    /**
	 * 设置：详情信息
	 */
    public String getJiaoxiaoContent() {
        return jiaoxiaoContent;
    }


    /**
	 * 获取：详情信息
	 */

    public void setJiaoxiaoContent(String jiaoxiaoContent) {
        this.jiaoxiaoContent = jiaoxiaoContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJiaoxiaoDelete() {
        return jiaoxiaoDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJiaoxiaoDelete(Integer jiaoxiaoDelete) {
        this.jiaoxiaoDelete = jiaoxiaoDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
