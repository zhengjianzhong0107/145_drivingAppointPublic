package com.entity.vo;

import com.entity.KaoshixYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 考试预约
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("kaoshix_yuyue")
public class KaoshixYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 预约编号
     */

    @TableField(value = "kaoshix_yuyue_uuid_number")
    private String kaoshixYuyueUuidNumber;


    /**
     * 考试
     */

    @TableField(value = "kaoshix_id")
    private Integer kaoshixId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 预约状态
     */

    @TableField(value = "kaoshix_yuyue_yesno_types")
    private Integer kaoshixYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "kaoshix_yuyue_yesno_text")
    private String kaoshixYuyueYesnoText;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：预约编号
	 */
    public String getKaoshixYuyueUuidNumber() {
        return kaoshixYuyueUuidNumber;
    }


    /**
	 * 获取：预约编号
	 */

    public void setKaoshixYuyueUuidNumber(String kaoshixYuyueUuidNumber) {
        this.kaoshixYuyueUuidNumber = kaoshixYuyueUuidNumber;
    }
    /**
	 * 设置：考试
	 */
    public Integer getKaoshixId() {
        return kaoshixId;
    }


    /**
	 * 获取：考试
	 */

    public void setKaoshixId(Integer kaoshixId) {
        this.kaoshixId = kaoshixId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：预约状态
	 */
    public Integer getKaoshixYuyueYesnoTypes() {
        return kaoshixYuyueYesnoTypes;
    }


    /**
	 * 获取：预约状态
	 */

    public void setKaoshixYuyueYesnoTypes(Integer kaoshixYuyueYesnoTypes) {
        this.kaoshixYuyueYesnoTypes = kaoshixYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getKaoshixYuyueYesnoText() {
        return kaoshixYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setKaoshixYuyueYesnoText(String kaoshixYuyueYesnoText) {
        this.kaoshixYuyueYesnoText = kaoshixYuyueYesnoText;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
