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

import com.entity.YezhuEntity;
import com.entity.view.YezhuView;

import com.service.YezhuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 业主
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-12 20:43:25
 */
@RestController
@RequestMapping("/yezhu")
public class YezhuController {
    @Autowired
    private YezhuService yezhuService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		YezhuEntity u = yezhuService.selectOne(new EntityWrapper<YezhuEntity>().eq("yezhuzhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"yezhu",  "业主" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody YezhuEntity yezhu){
    	//ValidatorUtils.validateEntity(yezhu);
    	YezhuEntity u = yezhuService.selectOne(new EntityWrapper<YezhuEntity>().eq("yezhuzhanghao", yezhu.getYezhuzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		yezhu.setId(uId);
        yezhuService.insert(yezhu);
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
        YezhuEntity u = yezhuService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	YezhuEntity u = yezhuService.selectOne(new EntityWrapper<YezhuEntity>().eq("yezhuzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        yezhuService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YezhuEntity yezhu,
		HttpServletRequest request){
        EntityWrapper<YezhuEntity> ew = new EntityWrapper<YezhuEntity>();

		PageUtils page = yezhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yezhu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YezhuEntity yezhu, 
		HttpServletRequest request){
        EntityWrapper<YezhuEntity> ew = new EntityWrapper<YezhuEntity>();

		PageUtils page = yezhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yezhu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YezhuEntity yezhu){
       	EntityWrapper<YezhuEntity> ew = new EntityWrapper<YezhuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yezhu, "yezhu")); 
        return R.ok().put("data", yezhuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YezhuEntity yezhu){
        EntityWrapper< YezhuEntity> ew = new EntityWrapper< YezhuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yezhu, "yezhu")); 
		YezhuView yezhuView =  yezhuService.selectView(ew);
		return R.ok("查询业主成功").put("data", yezhuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YezhuEntity yezhu = yezhuService.selectById(id);
        return R.ok().put("data", yezhu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YezhuEntity yezhu = yezhuService.selectById(id);
        return R.ok().put("data", yezhu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YezhuEntity yezhu, HttpServletRequest request){
        if(yezhuService.selectCount(new EntityWrapper<YezhuEntity>().eq("yezhuzhanghao", yezhu.getYezhuzhanghao()))>0) {
            return R.error("业主账号已存在");
        }
    	yezhu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yezhu);
    	YezhuEntity u = yezhuService.selectOne(new EntityWrapper<YezhuEntity>().eq("yezhuzhanghao", yezhu.getYezhuzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		yezhu.setId(new Date().getTime());
        yezhuService.insert(yezhu);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YezhuEntity yezhu, HttpServletRequest request){
        if(yezhuService.selectCount(new EntityWrapper<YezhuEntity>().eq("yezhuzhanghao", yezhu.getYezhuzhanghao()))>0) {
            return R.error("业主账号已存在");
        }
    	yezhu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yezhu);
    	YezhuEntity u = yezhuService.selectOne(new EntityWrapper<YezhuEntity>().eq("yezhuzhanghao", yezhu.getYezhuzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		yezhu.setId(new Date().getTime());
        yezhuService.insert(yezhu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YezhuEntity yezhu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yezhu);
        if(yezhuService.selectCount(new EntityWrapper<YezhuEntity>().ne("id", yezhu.getId()).eq("yezhuzhanghao", yezhu.getYezhuzhanghao()))>0) {
            return R.error("业主账号已存在");
        }
        yezhuService.updateById(yezhu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yezhuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
