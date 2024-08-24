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

import com.entity.FangwuxinxiEntity;
import com.entity.view.FangwuxinxiView;

import com.service.FangwuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 房屋信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-12 20:43:26
 */
@RestController
@RequestMapping("/fangwuxinxi")
public class FangwuxinxiController {
    @Autowired
    private FangwuxinxiService fangwuxinxiService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangwuxinxiEntity fangwuxinxi,
		HttpServletRequest request){
        EntityWrapper<FangwuxinxiEntity> ew = new EntityWrapper<FangwuxinxiEntity>();

		PageUtils page = fangwuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangwuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangwuxinxiEntity fangwuxinxi, 
		HttpServletRequest request){
        EntityWrapper<FangwuxinxiEntity> ew = new EntityWrapper<FangwuxinxiEntity>();

		PageUtils page = fangwuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangwuxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangwuxinxiEntity fangwuxinxi){
       	EntityWrapper<FangwuxinxiEntity> ew = new EntityWrapper<FangwuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangwuxinxi, "fangwuxinxi")); 
        return R.ok().put("data", fangwuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangwuxinxiEntity fangwuxinxi){
        EntityWrapper< FangwuxinxiEntity> ew = new EntityWrapper< FangwuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangwuxinxi, "fangwuxinxi")); 
		FangwuxinxiView fangwuxinxiView =  fangwuxinxiService.selectView(ew);
		return R.ok("查询房屋信息成功").put("data", fangwuxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangwuxinxiEntity fangwuxinxi = fangwuxinxiService.selectById(id);
		fangwuxinxi.setClicknum(fangwuxinxi.getClicknum()+1);
		fangwuxinxi.setClicktime(new Date());
		fangwuxinxiService.updateById(fangwuxinxi);
        fangwuxinxi = fangwuxinxiService.selectView(new EntityWrapper<FangwuxinxiEntity>().eq("id", id));
        return R.ok().put("data", fangwuxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangwuxinxiEntity fangwuxinxi = fangwuxinxiService.selectById(id);
		fangwuxinxi.setClicknum(fangwuxinxi.getClicknum()+1);
		fangwuxinxi.setClicktime(new Date());
		fangwuxinxiService.updateById(fangwuxinxi);
        fangwuxinxi = fangwuxinxiService.selectView(new EntityWrapper<FangwuxinxiEntity>().eq("id", id));
        return R.ok().put("data", fangwuxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FangwuxinxiEntity fangwuxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fangwuxinxi);
        fangwuxinxiService.insert(fangwuxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FangwuxinxiEntity fangwuxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fangwuxinxi);
        fangwuxinxiService.insert(fangwuxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FangwuxinxiEntity fangwuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangwuxinxi);
        fangwuxinxiService.updateById(fangwuxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fangwuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,FangwuxinxiEntity fangwuxinxi, HttpServletRequest request,String pre){
        EntityWrapper<FangwuxinxiEntity> ew = new EntityWrapper<FangwuxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = fangwuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangwuxinxi), params), params));
        return R.ok().put("data", page);
    }










}
