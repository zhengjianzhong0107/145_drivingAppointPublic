package com.dao;

import com.entity.KaoshixEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KaoshixView;

/**
 * 考试通知 Dao 接口
 *
 * @author 
 */
public interface KaoshixDao extends BaseMapper<KaoshixEntity> {

   List<KaoshixView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
