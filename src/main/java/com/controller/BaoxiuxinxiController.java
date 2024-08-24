package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.BaoxiuxinxiEntity;
import com.entity.view.BaoxiuxinxiView;

import com.service.BaoxiuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 报修信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-12 20:43:25
 */
@RestController
@RequestMapping("/baoxiuxinxi")
public class BaoxiuxinxiController {
    @Autowired
    private BaoxiuxinxiService baoxiuxinxiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BaoxiuxinxiEntity baoxiuxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yezhu")) {
			baoxiuxinxi.setYezhuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<BaoxiuxinxiEntity> ew = new EntityWrapper<BaoxiuxinxiEntity>();

		PageUtils page = baoxiuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baoxiuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BaoxiuxinxiEntity baoxiuxinxi, 
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yezhu")) {
			baoxiuxinxi.setYezhuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<BaoxiuxinxiEntity> ew = new EntityWrapper<BaoxiuxinxiEntity>();

		PageUtils page = baoxiuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baoxiuxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BaoxiuxinxiEntity baoxiuxinxi){
       	EntityWrapper<BaoxiuxinxiEntity> ew = new EntityWrapper<BaoxiuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( baoxiuxinxi, "baoxiuxinxi")); 
        return R.ok().put("data", baoxiuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BaoxiuxinxiEntity baoxiuxinxi){
        EntityWrapper< BaoxiuxinxiEntity> ew = new EntityWrapper< BaoxiuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( baoxiuxinxi, "baoxiuxinxi")); 
		BaoxiuxinxiView baoxiuxinxiView =  baoxiuxinxiService.selectView(ew);
		return R.ok("查询报修信息成功").put("data", baoxiuxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BaoxiuxinxiEntity baoxiuxinxi = baoxiuxinxiService.selectById(id);
        return R.ok().put("data", baoxiuxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BaoxiuxinxiEntity baoxiuxinxi = baoxiuxinxiService.selectById(id);
        return R.ok().put("data", baoxiuxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BaoxiuxinxiEntity baoxiuxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(baoxiuxinxi);
        baoxiuxinxiService.insert(baoxiuxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BaoxiuxinxiEntity baoxiuxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(baoxiuxinxi);
    	baoxiuxinxi.setUserid((Long)request.getSession().getAttribute("userId"));
        baoxiuxinxiService.insert(baoxiuxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BaoxiuxinxiEntity baoxiuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(baoxiuxinxi);
        baoxiuxinxiService.updateById(baoxiuxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        baoxiuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	






    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<BaoxiuxinxiEntity> ew = new EntityWrapper<BaoxiuxinxiEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yezhu")) {
            ew.eq("yezhuzhanghao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = baoxiuxinxiService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<BaoxiuxinxiEntity> ew = new EntityWrapper<BaoxiuxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yezhu")) {
            ew.eq("yezhuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = baoxiuxinxiService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<BaoxiuxinxiEntity> ew = new EntityWrapper<BaoxiuxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yezhu")) {
            ew.eq("yezhuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = baoxiuxinxiService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<BaoxiuxinxiEntity> ew = new EntityWrapper<BaoxiuxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yezhu")) {
            ew.eq("yezhuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = baoxiuxinxiService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<BaoxiuxinxiEntity> ew = new EntityWrapper<BaoxiuxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yezhu")) {
            ew.eq("yezhuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = baoxiuxinxiService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,BaoxiuxinxiEntity baoxiuxinxi, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yezhu")) {
            baoxiuxinxi.setYezhuzhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<BaoxiuxinxiEntity> ew = new EntityWrapper<BaoxiuxinxiEntity>();
        int count = baoxiuxinxiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baoxiuxinxi), params), params));
        return R.ok().put("data", count);
    }



}
