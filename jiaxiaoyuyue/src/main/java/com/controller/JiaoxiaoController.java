
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 驾校信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiaoxiao")
public class JiaoxiaoController {
    private static final Logger logger = LoggerFactory.getLogger(JiaoxiaoController.class);

    private static final String TABLE_NAME = "jiaoxiao";

    @Autowired
    private JiaoxiaoService jiaoxiaoService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private JiaolianService jiaolianService;//教练
    @Autowired
    private JiaolianCollectionService jiaolianCollectionService;//教练收藏
    @Autowired
    private JiaolianLiuyanService jiaolianLiuyanService;//教练留言
    @Autowired
    private JiaolianYuyueService jiaolianYuyueService;//教练预约
    @Autowired
    private KaoshixService kaoshixService;//考试通知
    @Autowired
    private KaoshixYuyueService kaoshixYuyueService;//考试预约
    @Autowired
    private NewsService newsService;//公告通知
    @Autowired
    private YonghuService yonghuService;//学员
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学员".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("教练".equals(role))
            params.put("jiaolianId",request.getSession().getAttribute("userId"));
        params.put("jiaoxiaoDeleteStart",1);params.put("jiaoxiaoDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = jiaoxiaoService.queryPage(params);

        //字典表数据转换
        List<JiaoxiaoView> list =(List<JiaoxiaoView>)page.getList();
        for(JiaoxiaoView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiaoxiaoEntity jiaoxiao = jiaoxiaoService.selectById(id);
        if(jiaoxiao !=null){
            //entity转view
            JiaoxiaoView view = new JiaoxiaoView();
            BeanUtils.copyProperties( jiaoxiao , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiaoxiaoEntity jiaoxiao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiaoxiao:{}",this.getClass().getName(),jiaoxiao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JiaoxiaoEntity> queryWrapper = new EntityWrapper<JiaoxiaoEntity>()
            .eq("jiaoxiao_name", jiaoxiao.getJiaoxiaoName())
            .eq("jiaoxiao_types", jiaoxiao.getJiaoxiaoTypes())
            .eq("jiaoxiao_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaoxiaoEntity jiaoxiaoEntity = jiaoxiaoService.selectOne(queryWrapper);
        if(jiaoxiaoEntity==null){
            jiaoxiao.setJiaoxiaoDelete(1);
            jiaoxiao.setInsertTime(new Date());
            jiaoxiao.setCreateTime(new Date());
            jiaoxiaoService.insert(jiaoxiao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiaoxiaoEntity jiaoxiao, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiaoxiao:{}",this.getClass().getName(),jiaoxiao.toString());
        JiaoxiaoEntity oldJiaoxiaoEntity = jiaoxiaoService.selectById(jiaoxiao.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(jiaoxiao.getJiaoxiaoPhoto()) || "null".equals(jiaoxiao.getJiaoxiaoPhoto())){
                jiaoxiao.setJiaoxiaoPhoto(null);
        }

            jiaoxiaoService.updateById(jiaoxiao);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiaoxiaoEntity> oldJiaoxiaoList =jiaoxiaoService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<JiaoxiaoEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JiaoxiaoEntity jiaoxiaoEntity = new JiaoxiaoEntity();
            jiaoxiaoEntity.setId(id);
            jiaoxiaoEntity.setJiaoxiaoDelete(2);
            list.add(jiaoxiaoEntity);
        }
        if(list != null && list.size() >0){
            jiaoxiaoService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<JiaoxiaoEntity> jiaoxiaoList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JiaoxiaoEntity jiaoxiaoEntity = new JiaoxiaoEntity();
//                            jiaoxiaoEntity.setJiaoxiaoName(data.get(0));                    //标题 要改的
//                            jiaoxiaoEntity.setJiaoxiaoPhoto("");//详情和图片
//                            jiaoxiaoEntity.setJiaoxiaoTypes(Integer.valueOf(data.get(0)));   //展示类型 要改的
//                            jiaoxiaoEntity.setJiaoxiaoContent("");//详情和图片
//                            jiaoxiaoEntity.setJiaoxiaoDelete(1);//逻辑删除字段
//                            jiaoxiaoEntity.setInsertTime(date);//时间
//                            jiaoxiaoEntity.setCreateTime(date);//时间
                            jiaoxiaoList.add(jiaoxiaoEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        jiaoxiaoService.insertBatch(jiaoxiaoList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = jiaoxiaoService.queryPage(params);

        //字典表数据转换
        List<JiaoxiaoView> list =(List<JiaoxiaoView>)page.getList();
        for(JiaoxiaoView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiaoxiaoEntity jiaoxiao = jiaoxiaoService.selectById(id);
            if(jiaoxiao !=null){


                //entity转view
                JiaoxiaoView view = new JiaoxiaoView();
                BeanUtils.copyProperties( jiaoxiao , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody JiaoxiaoEntity jiaoxiao, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiaoxiao:{}",this.getClass().getName(),jiaoxiao.toString());
        Wrapper<JiaoxiaoEntity> queryWrapper = new EntityWrapper<JiaoxiaoEntity>()
            .eq("jiaoxiao_name", jiaoxiao.getJiaoxiaoName())
            .eq("jiaoxiao_types", jiaoxiao.getJiaoxiaoTypes())
            .eq("jiaoxiao_delete", jiaoxiao.getJiaoxiaoDelete())
//            .notIn("jiaoxiao_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaoxiaoEntity jiaoxiaoEntity = jiaoxiaoService.selectOne(queryWrapper);
        if(jiaoxiaoEntity==null){
            jiaoxiao.setJiaoxiaoDelete(1);
            jiaoxiao.setInsertTime(new Date());
            jiaoxiao.setCreateTime(new Date());
        jiaoxiaoService.insert(jiaoxiao);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

