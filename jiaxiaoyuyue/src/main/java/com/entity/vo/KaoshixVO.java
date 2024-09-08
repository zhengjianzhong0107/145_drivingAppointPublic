package com.entity.vo;

import com.entity.KaoshixEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 考试通知
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("kaoshix")
public class KaoshixVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 通知标题
     */

    @TableField(value = "kaoshix_name")
    private String kaoshixName;


    /**
     * 通知封面
     */

    @TableField(value = "kaoshix_photo")
    private String kaoshixPhoto;


    /**
     * 考试类型
     */

    @TableField(value = "kaoshix_types")
    private Integer kaoshixTypes;


    /**
     * 考试地址
     */

    @TableField(value = "kaoshix_address")
    private String kaoshixAddress;


    /**
     * 考试时间
     */

    @TableField(value = "kaoshix_shijian")
    private String kaoshixShijian;


    /**
     * 截止时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "kaoshix_time")
    private Date kaoshixTime;


    /**
     * 详情信息
     */

    @TableField(value = "kaoshix_content")
    private String kaoshixContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "kaoshix_delete")
    private Integer kaoshixDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow homeMain
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
	 * 设置：通知标题
	 */
    public String getKaoshixName() {
        return kaoshixName;
    }


    /**
	 * 获取：通知标题
	 */

    public void setKaoshixName(String kaoshixName) {
        this.kaoshixName = kaoshixName;
    }
    /**
	 * 设置：通知封面
	 */
    public String getKaoshixPhoto() {
        return kaoshixPhoto;
    }


    /**
	 * 获取：通知封面
	 */

    public void setKaoshixPhoto(String kaoshixPhoto) {
        this.kaoshixPhoto = kaoshixPhoto;
    }
    /**
	 * 设置：考试类型
	 */
    public Integer getKaoshixTypes() {
        return kaoshixTypes;
    }


    /**
	 * 获取：考试类型
	 */

    public void setKaoshixTypes(Integer kaoshixTypes) {
        this.kaoshixTypes = kaoshixTypes;
    }
    /**
	 * 设置：考试地址
	 */
    public String getKaoshixAddress() {
        return kaoshixAddress;
    }


    /**
	 * 获取：考试地址
	 */

    public void setKaoshixAddress(String kaoshixAddress) {
        this.kaoshixAddress = kaoshixAddress;
    }
    /**
	 * 设置：考试时间
	 */
    public String getKaoshixShijian() {
        return kaoshixShijian;
    }


    /**
	 * 获取：考试时间
	 */

    public void setKaoshixShijian(String kaoshixShijian) {
        this.kaoshixShijian = kaoshixShijian;
    }
    /**
	 * 设置：截止时间
	 */
    public Date getKaoshixTime() {
        return kaoshixTime;
    }


    /**
	 * 获取：截止时间
	 */

    public void setKaoshixTime(Date kaoshixTime) {
        this.kaoshixTime = kaoshixTime;
    }
    /**
	 * 设置：详情信息
	 */
    public String getKaoshixContent() {
        return kaoshixContent;
    }


    /**
	 * 获取：详情信息
	 */

    public void setKaoshixContent(String kaoshixContent) {
        this.kaoshixContent = kaoshixContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getKaoshixDelete() {
        return kaoshixDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setKaoshixDelete(Integer kaoshixDelete) {
        this.kaoshixDelete = kaoshixDelete;
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
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
