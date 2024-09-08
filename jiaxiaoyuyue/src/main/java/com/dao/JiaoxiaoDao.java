package com.dao;

import com.entity.JiaoxiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaoxiaoView;

/**
 * 驾校信息 Dao 接口
 *
 * @author 
 */
public interface JiaoxiaoDao extends BaseMapper<JiaoxiaoEntity> {

   List<JiaoxiaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
