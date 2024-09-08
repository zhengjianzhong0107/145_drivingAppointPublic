package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.KaoshixYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 考试预约
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("kaoshix_yuyue")
public class KaoshixYuyueView extends KaoshixYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 预约状态的值
	*/
	@ColumnInfo(comment="预约状态的字典表值",type="varchar(200)")
	private String kaoshixYuyueYesnoValue;

	//级联表 考试通知
		/**
		* 通知标题
		*/

		@ColumnInfo(comment="通知标题",type="varchar(200)")
		private String kaoshixName;
		/**
		* 通知封面
		*/

		@ColumnInfo(comment="通知封面",type="varchar(200)")
		private String kaoshixPhoto;
		/**
		* 考试类型
		*/
		@ColumnInfo(comment="考试类型",type="int(11)")
		private Integer kaoshixTypes;
			/**
			* 考试类型的值
			*/
			@ColumnInfo(comment="考试类型的字典表值",type="varchar(200)")
			private String kaoshixValue;
		/**
		* 考试地址
		*/

		@ColumnInfo(comment="考试地址",type="varchar(200)")
		private String kaoshixAddress;
		/**
		* 考试时间
		*/

		@ColumnInfo(comment="考试时间",type="varchar(200)")
		private String kaoshixShijian;
		/**
		* 截止时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="截止时间",type="timestamp")
		private Date kaoshixTime;
		/**
		* 详情信息
		*/

		@ColumnInfo(comment="详情信息",type="longtext")
		private String kaoshixContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer kaoshixDelete;
	//级联表 学员
		/**
		* 学员名称
		*/

		@ColumnInfo(comment="学员名称",type="varchar(200)")
		private String yonghuName;
		/**
		* 学员手机号
		*/

		@ColumnInfo(comment="学员手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 学员身份证号
		*/

		@ColumnInfo(comment="学员身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 学员头像
		*/

		@ColumnInfo(comment="学员头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 学员邮箱
		*/

		@ColumnInfo(comment="学员邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;



	public KaoshixYuyueView() {

	}

	public KaoshixYuyueView(KaoshixYuyueEntity kaoshixYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, kaoshixYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 预约状态的值
	*/
	public String getKaoshixYuyueYesnoValue() {
		return kaoshixYuyueYesnoValue;
	}
	/**
	* 设置： 预约状态的值
	*/
	public void setKaoshixYuyueYesnoValue(String kaoshixYuyueYesnoValue) {
		this.kaoshixYuyueYesnoValue = kaoshixYuyueYesnoValue;
	}


	//级联表的get和set 考试通知

		/**
		* 获取： 通知标题
		*/
		public String getKaoshixName() {
			return kaoshixName;
		}
		/**
		* 设置： 通知标题
		*/
		public void setKaoshixName(String kaoshixName) {
			this.kaoshixName = kaoshixName;
		}

		/**
		* 获取： 通知封面
		*/
		public String getKaoshixPhoto() {
			return kaoshixPhoto;
		}
		/**
		* 设置： 通知封面
		*/
		public void setKaoshixPhoto(String kaoshixPhoto) {
			this.kaoshixPhoto = kaoshixPhoto;
		}
		/**
		* 获取： 考试类型
		*/
		public Integer getKaoshixTypes() {
			return kaoshixTypes;
		}
		/**
		* 设置： 考试类型
		*/
		public void setKaoshixTypes(Integer kaoshixTypes) {
			this.kaoshixTypes = kaoshixTypes;
		}


			/**
			* 获取： 考试类型的值
			*/
			public String getKaoshixValue() {
				return kaoshixValue;
			}
			/**
			* 设置： 考试类型的值
			*/
			public void setKaoshixValue(String kaoshixValue) {
				this.kaoshixValue = kaoshixValue;
			}

		/**
		* 获取： 考试地址
		*/
		public String getKaoshixAddress() {
			return kaoshixAddress;
		}
		/**
		* 设置： 考试地址
		*/
		public void setKaoshixAddress(String kaoshixAddress) {
			this.kaoshixAddress = kaoshixAddress;
		}

		/**
		* 获取： 考试时间
		*/
		public String getKaoshixShijian() {
			return kaoshixShijian;
		}
		/**
		* 设置： 考试时间
		*/
		public void setKaoshixShijian(String kaoshixShijian) {
			this.kaoshixShijian = kaoshixShijian;
		}

		/**
		* 获取： 截止时间
		*/
		public Date getKaoshixTime() {
			return kaoshixTime;
		}
		/**
		* 设置： 截止时间
		*/
		public void setKaoshixTime(Date kaoshixTime) {
			this.kaoshixTime = kaoshixTime;
		}

		/**
		* 获取： 详情信息
		*/
		public String getKaoshixContent() {
			return kaoshixContent;
		}
		/**
		* 设置： 详情信息
		*/
		public void setKaoshixContent(String kaoshixContent) {
			this.kaoshixContent = kaoshixContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getKaoshixDelete() {
			return kaoshixDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setKaoshixDelete(Integer kaoshixDelete) {
			this.kaoshixDelete = kaoshixDelete;
		}
	//级联表的get和set 学员

		/**
		* 获取： 学员名称
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 学员名称
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 学员手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 学员手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 学员身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 学员身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 学员头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 学员头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 学员邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 学员邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "KaoshixYuyueView{" +
			", kaoshixYuyueYesnoValue=" + kaoshixYuyueYesnoValue +
			", kaoshixName=" + kaoshixName +
			", kaoshixPhoto=" + kaoshixPhoto +
			", kaoshixAddress=" + kaoshixAddress +
			", kaoshixShijian=" + kaoshixShijian +
			", kaoshixTime=" + DateUtil.convertString(kaoshixTime,"yyyy-MM-dd") +
			", kaoshixContent=" + kaoshixContent +
			", kaoshixDelete=" + kaoshixDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
