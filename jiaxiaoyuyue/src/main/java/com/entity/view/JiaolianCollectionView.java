package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JiaolianCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 教练收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jiaolian_collection")
public class JiaolianCollectionView extends JiaolianCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String jiaolianCollectionValue;

	//级联表 教练
		/**
		* 教练名称
		*/

		@ColumnInfo(comment="教练名称",type="varchar(200)")
		private String jiaolianName;
		/**
		* 教练手机号
		*/

		@ColumnInfo(comment="教练手机号",type="varchar(200)")
		private String jiaolianPhone;
		/**
		* 教练身份证号
		*/

		@ColumnInfo(comment="教练身份证号",type="varchar(200)")
		private String jiaolianIdNumber;
		/**
		* 教练头像
		*/

		@ColumnInfo(comment="教练头像",type="varchar(200)")
		private String jiaolianPhoto;
		/**
		* 教练类型
		*/
		@ColumnInfo(comment="教练类型",type="int(11)")
		private Integer jiaolianTypes;
			/**
			* 教练类型的值
			*/
			@ColumnInfo(comment="教练类型的字典表值",type="varchar(200)")
			private String jiaolianValue;
		/**
		* 教练邮箱
		*/

		@ColumnInfo(comment="教练邮箱",type="varchar(200)")
		private String jiaolianEmail;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer jiaolianDelete;
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

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public JiaolianCollectionView() {

	}

	public JiaolianCollectionView(JiaolianCollectionEntity jiaolianCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, jiaolianCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getJiaolianCollectionValue() {
		return jiaolianCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setJiaolianCollectionValue(String jiaolianCollectionValue) {
		this.jiaolianCollectionValue = jiaolianCollectionValue;
	}


	//级联表的get和set 教练

		/**
		* 获取： 教练名称
		*/
		public String getJiaolianName() {
			return jiaolianName;
		}
		/**
		* 设置： 教练名称
		*/
		public void setJiaolianName(String jiaolianName) {
			this.jiaolianName = jiaolianName;
		}

		/**
		* 获取： 教练手机号
		*/
		public String getJiaolianPhone() {
			return jiaolianPhone;
		}
		/**
		* 设置： 教练手机号
		*/
		public void setJiaolianPhone(String jiaolianPhone) {
			this.jiaolianPhone = jiaolianPhone;
		}

		/**
		* 获取： 教练身份证号
		*/
		public String getJiaolianIdNumber() {
			return jiaolianIdNumber;
		}
		/**
		* 设置： 教练身份证号
		*/
		public void setJiaolianIdNumber(String jiaolianIdNumber) {
			this.jiaolianIdNumber = jiaolianIdNumber;
		}

		/**
		* 获取： 教练头像
		*/
		public String getJiaolianPhoto() {
			return jiaolianPhoto;
		}
		/**
		* 设置： 教练头像
		*/
		public void setJiaolianPhoto(String jiaolianPhoto) {
			this.jiaolianPhoto = jiaolianPhoto;
		}
		/**
		* 获取： 教练类型
		*/
		public Integer getJiaolianTypes() {
			return jiaolianTypes;
		}
		/**
		* 设置： 教练类型
		*/
		public void setJiaolianTypes(Integer jiaolianTypes) {
			this.jiaolianTypes = jiaolianTypes;
		}


			/**
			* 获取： 教练类型的值
			*/
			public String getJiaolianValue() {
				return jiaolianValue;
			}
			/**
			* 设置： 教练类型的值
			*/
			public void setJiaolianValue(String jiaolianValue) {
				this.jiaolianValue = jiaolianValue;
			}

		/**
		* 获取： 教练邮箱
		*/
		public String getJiaolianEmail() {
			return jiaolianEmail;
		}
		/**
		* 设置： 教练邮箱
		*/
		public void setJiaolianEmail(String jiaolianEmail) {
			this.jiaolianEmail = jiaolianEmail;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getJiaolianDelete() {
			return jiaolianDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setJiaolianDelete(Integer jiaolianDelete) {
			this.jiaolianDelete = jiaolianDelete;
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

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "JiaolianCollectionView{" +
			", jiaolianCollectionValue=" + jiaolianCollectionValue +
			", jiaolianName=" + jiaolianName +
			", jiaolianPhone=" + jiaolianPhone +
			", jiaolianIdNumber=" + jiaolianIdNumber +
			", jiaolianPhoto=" + jiaolianPhoto +
			", jiaolianEmail=" + jiaolianEmail +
			", jiaolianDelete=" + jiaolianDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
