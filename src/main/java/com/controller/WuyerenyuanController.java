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

import com.entity.WuyerenyuanEntity;
import com.entity.view.WuyerenyuanView;

import com.service.WuyerenyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 物业人员
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-12 20:43:25
 */
@RestController
@RequestMapping("/wuyerenyuan")
public class WuyerenyuanController {
    @Autowired
    private WuyerenyuanService wuyerenyuanService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		WuyerenyuanEntity u = wuyerenyuanService.selectOne(new EntityWrapper<WuyerenyuanEntity>().eq("wuyezhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"wuyerenyuan",  "管理员" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody WuyerenyuanEntity wuyerenyuan){
    	//ValidatorUtils.validateEntity(wuyerenyuan);
    	WuyerenyuanEntity u = wuyerenyuanService.selectOne(new EntityWrapper<WuyerenyuanEntity>().eq("wuyezhanghao", wuyerenyuan.getWuyezhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		wuyerenyuan.setId(uId);
        wuyerenyuanService.insert(wuyerenyuan);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        WuyerenyuanEntity u = wuyerenyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	WuyerenyuanEntity u = wuyerenyuanService.selectOne(new EntityWrapper<WuyerenyuanEntity>().eq("wuyezhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        wuyerenyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WuyerenyuanEntity wuyerenyuan,
		HttpServletRequest request){
        EntityWrapper<WuyerenyuanEntity> ew = new EntityWrapper<WuyerenyuanEntity>();

		PageUtils page = wuyerenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wuyerenyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WuyerenyuanEntity wuyerenyuan, 
		HttpServletRequest request){
        EntityWrapper<WuyerenyuanEntity> ew = new EntityWrapper<WuyerenyuanEntity>();

		PageUtils page = wuyerenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wuyerenyuan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WuyerenyuanEntity wuyerenyuan){
       	EntityWrapper<WuyerenyuanEntity> ew = new EntityWrapper<WuyerenyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wuyerenyuan, "wuyerenyuan")); 
        return R.ok().put("data", wuyerenyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WuyerenyuanEntity wuyerenyuan){
        EntityWrapper< WuyerenyuanEntity> ew = new EntityWrapper< WuyerenyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wuyerenyuan, "wuyerenyuan")); 
		WuyerenyuanView wuyerenyuanView =  wuyerenyuanService.selectView(ew);
		return R.ok("查询物业人员成功").put("data", wuyerenyuanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WuyerenyuanEntity wuyerenyuan = wuyerenyuanService.selectById(id);
        return R.ok().put("data", wuyerenyuan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WuyerenyuanEntity wuyerenyuan = wuyerenyuanService.selectById(id);
        return R.ok().put("data", wuyerenyuan);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WuyerenyuanEntity wuyerenyuan, HttpServletRequest request){
        if(wuyerenyuanService.selectCount(new EntityWrapper<WuyerenyuanEntity>().eq("wuyezhanghao", wuyerenyuan.getWuyezhanghao()))>0) {
            return R.error("物业账号已存在");
        }
    	wuyerenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wuyerenyuan);
    	WuyerenyuanEntity u = wuyerenyuanService.selectOne(new EntityWrapper<WuyerenyuanEntity>().eq("wuyezhanghao", wuyerenyuan.getWuyezhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		wuyerenyuan.setId(new Date().getTime());
        wuyerenyuanService.insert(wuyerenyuan);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WuyerenyuanEntity wuyerenyuan, HttpServletRequest request){
        if(wuyerenyuanService.selectCount(new EntityWrapper<WuyerenyuanEntity>().eq("wuyezhanghao", wuyerenyuan.getWuyezhanghao()))>0) {
            return R.error("物业账号已存在");
        }
    	wuyerenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wuyerenyuan);
    	WuyerenyuanEntity u = wuyerenyuanService.selectOne(new EntityWrapper<WuyerenyuanEntity>().eq("wuyezhanghao", wuyerenyuan.getWuyezhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		wuyerenyuan.setId(new Date().getTime());
        wuyerenyuanService.insert(wuyerenyuan);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WuyerenyuanEntity wuyerenyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wuyerenyuan);
        if(wuyerenyuanService.selectCount(new EntityWrapper<WuyerenyuanEntity>().ne("id", wuyerenyuan.getId()).eq("wuyezhanghao", wuyerenyuan.getWuyezhanghao()))>0) {
            return R.error("物业账号已存在");
        }
        wuyerenyuanService.updateById(wuyerenyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wuyerenyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
