package com.dao;

import com.entity.KaoshixYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KaoshixYuyueView;

/**
 * 考试预约 Dao 接口
 *
 * @author 
 */
public interface KaoshixYuyueDao extends BaseMapper<KaoshixYuyueEntity> {

   List<KaoshixYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
