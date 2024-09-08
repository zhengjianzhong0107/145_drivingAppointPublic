
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
 * 考试通知
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/kaoshix")
public class KaoshixController {
    private static final Logger logger = LoggerFactory.getLogger(KaoshixController.class);

    private static final String TABLE_NAME = "kaoshix";

    @Autowired
    private KaoshixService kaoshixService;


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
    private JiaoxiaoService jiaoxiaoService;//驾校信息
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
        params.put("kaoshixDeleteStart",1);params.put("kaoshixDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = kaoshixService.queryPage(params);

        //字典表数据转换
        List<KaoshixView> list =(List<KaoshixView>)page.getList();
        for(KaoshixView c:list){
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
        KaoshixEntity kaoshix = kaoshixService.selectById(id);
        if(kaoshix !=null){
            //entity转view
            KaoshixView view = new KaoshixView();
            BeanUtils.copyProperties( kaoshix , view );//把实体数据重构到view中
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
    public R save(@RequestBody KaoshixEntity kaoshix, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kaoshix:{}",this.getClass().getName(),kaoshix.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<KaoshixEntity> queryWrapper = new EntityWrapper<KaoshixEntity>()
            .eq("kaoshix_name", kaoshix.getKaoshixName())
            .eq("kaoshix_types", kaoshix.getKaoshixTypes())
            .eq("kaoshix_address", kaoshix.getKaoshixAddress())
            .eq("kaoshix_shijian", kaoshix.getKaoshixShijian())
            .eq("kaoshix_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KaoshixEntity kaoshixEntity = kaoshixService.selectOne(queryWrapper);
        if(kaoshixEntity==null){
            kaoshix.setKaoshixDelete(1);
            kaoshix.setInsertTime(new Date());
            kaoshix.setCreateTime(new Date());
            kaoshixService.insert(kaoshix);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KaoshixEntity kaoshix, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,kaoshix:{}",this.getClass().getName(),kaoshix.toString());
        KaoshixEntity oldKaoshixEntity = kaoshixService.selectById(kaoshix.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(kaoshix.getKaoshixPhoto()) || "null".equals(kaoshix.getKaoshixPhoto())){
                kaoshix.setKaoshixPhoto(null);
        }

            kaoshixService.updateById(kaoshix);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<KaoshixEntity> oldKaoshixList =kaoshixService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<KaoshixEntity> list = new ArrayList<>();
        for(Integer id:ids){
            KaoshixEntity kaoshixEntity = new KaoshixEntity();
            kaoshixEntity.setId(id);
            kaoshixEntity.setKaoshixDelete(2);
            list.add(kaoshixEntity);
        }
        if(list != null && list.size() >0){
            kaoshixService.updateBatchById(list);
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
            List<KaoshixEntity> kaoshixList = new ArrayList<>();//上传的东西
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
                            KaoshixEntity kaoshixEntity = new KaoshixEntity();
//                            kaoshixEntity.setKaoshixName(data.get(0));                    //通知标题 要改的
//                            kaoshixEntity.setKaoshixPhoto("");//详情和图片
//                            kaoshixEntity.setKaoshixTypes(Integer.valueOf(data.get(0)));   //考试类型 要改的
//                            kaoshixEntity.setKaoshixAddress(data.get(0));                    //考试地址 要改的
//                            kaoshixEntity.setKaoshixShijian(data.get(0));                    //考试时间 要改的
//                            kaoshixEntity.setKaoshixTime(sdf.parse(data.get(0)));          //截止时间 要改的
//                            kaoshixEntity.setKaoshixContent("");//详情和图片
//                            kaoshixEntity.setKaoshixDelete(1);//逻辑删除字段
//                            kaoshixEntity.setInsertTime(date);//时间
//                            kaoshixEntity.setCreateTime(date);//时间
                            kaoshixList.add(kaoshixEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        kaoshixService.insertBatch(kaoshixList);
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
        PageUtils page = kaoshixService.queryPage(params);

        //字典表数据转换
        List<KaoshixView> list =(List<KaoshixView>)page.getList();
        for(KaoshixView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        KaoshixEntity kaoshix = kaoshixService.selectById(id);
            if(kaoshix !=null){


                //entity转view
                KaoshixView view = new KaoshixView();
                BeanUtils.copyProperties( kaoshix , view );//把实体数据重构到view中

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
    public R add(@RequestBody KaoshixEntity kaoshix, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,kaoshix:{}",this.getClass().getName(),kaoshix.toString());
        Wrapper<KaoshixEntity> queryWrapper = new EntityWrapper<KaoshixEntity>()
            .eq("kaoshix_name", kaoshix.getKaoshixName())
            .eq("kaoshix_types", kaoshix.getKaoshixTypes())
            .eq("kaoshix_address", kaoshix.getKaoshixAddress())
            .eq("kaoshix_shijian", kaoshix.getKaoshixShijian())
            .eq("kaoshix_delete", kaoshix.getKaoshixDelete())
//            .notIn("kaoshix_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KaoshixEntity kaoshixEntity = kaoshixService.selectOne(queryWrapper);
        if(kaoshixEntity==null){
            kaoshix.setKaoshixDelete(1);
            kaoshix.setInsertTime(new Date());
            kaoshix.setCreateTime(new Date());
        kaoshixService.insert(kaoshix);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

