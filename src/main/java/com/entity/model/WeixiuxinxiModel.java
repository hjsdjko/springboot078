package com.entity.model;

import com.entity.WeixiuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 维修信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-12 20:43:26
 */
public class WeixiuxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 业主姓名
	 */
	
	private String yezhuxingming;
		
	/**
	 * 手机号
	 */
	
	private String shoujihao;
		
	/**
	 * 楼号
	 */
	
	private String louhao;
		
	/**
	 * 门牌号
	 */
	
	private String menpaihao;
		
	/**
	 * 详细地址
	 */
	
	private String xiangxidizhi;
		
	/**
	 * 设备位置
	 */
	
	private String shebeiweizhi;
		
	/**
	 * 故障图片
	 */
	
	private String guzhangtupian;
		
	/**
	 * 维修时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date weixiushijian;
		
	/**
	 * 维修详情
	 */
	
	private String weixiuxiangqing;
		
	/**
	 * 物业账号
	 */
	
	private String wuyezhanghao;
		
	/**
	 * 物业姓名
	 */
	
	private String wuyexingming;
				
	
	/**
	 * 设置：业主姓名
	 */
	 
	public void setYezhuxingming(String yezhuxingming) {
		this.yezhuxingming = yezhuxingming;
	}
	
	/**
	 * 获取：业主姓名
	 */
	public String getYezhuxingming() {
		return yezhuxingming;
	}
				
	
	/**
	 * 设置：手机号
	 */
	 
	public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
	}
	
	/**
	 * 获取：手机号
	 */
	public String getShoujihao() {
		return shoujihao;
	}
				
	
	/**
	 * 设置：楼号
	 */
	 
	public void setLouhao(String louhao) {
		this.louhao = louhao;
	}
	
	/**
	 * 获取：楼号
	 */
	public String getLouhao() {
		return louhao;
	}
				
	
	/**
	 * 设置：门牌号
	 */
	 
	public void setMenpaihao(String menpaihao) {
		this.menpaihao = menpaihao;
	}
	
	/**
	 * 获取：门牌号
	 */
	public String getMenpaihao() {
		return menpaihao;
	}
				
	
	/**
	 * 设置：详细地址
	 */
	 
	public void setXiangxidizhi(String xiangxidizhi) {
		this.xiangxidizhi = xiangxidizhi;
	}
	
	/**
	 * 获取：详细地址
	 */
	public String getXiangxidizhi() {
		return xiangxidizhi;
	}
				
	
	/**
	 * 设置：设备位置
	 */
	 
	public void setShebeiweizhi(String shebeiweizhi) {
		this.shebeiweizhi = shebeiweizhi;
	}
	
	/**
	 * 获取：设备位置
	 */
	public String getShebeiweizhi() {
		return shebeiweizhi;
	}
				
	
	/**
	 * 设置：故障图片
	 */
	 
	public void setGuzhangtupian(String guzhangtupian) {
		this.guzhangtupian = guzhangtupian;
	}
	
	/**
	 * 获取：故障图片
	 */
	public String getGuzhangtupian() {
		return guzhangtupian;
	}
				
	
	/**
	 * 设置：维修时间
	 */
	 
	public void setWeixiushijian(Date weixiushijian) {
		this.weixiushijian = weixiushijian;
	}
	
	/**
	 * 获取：维修时间
	 */
	public Date getWeixiushijian() {
		return weixiushijian;
	}
				
	
	/**
	 * 设置：维修详情
	 */
	 
	public void setWeixiuxiangqing(String weixiuxiangqing) {
		this.weixiuxiangqing = weixiuxiangqing;
	}
	
	/**
	 * 获取：维修详情
	 */
	public String getWeixiuxiangqing() {
		return weixiuxiangqing;
	}
				
	
	/**
	 * 设置：物业账号
	 */
	 
	public void setWuyezhanghao(String wuyezhanghao) {
		this.wuyezhanghao = wuyezhanghao;
	}
	
	/**
	 * 获取：物业账号
	 */
	public String getWuyezhanghao() {
		return wuyezhanghao;
	}
				
	
	/**
	 * 设置：物业姓名
	 */
	 
	public void setWuyexingming(String wuyexingming) {
		this.wuyexingming = wuyexingming;
	}
	
	/**
	 * 获取：物业姓名
	 */
	public String getWuyexingming() {
		return wuyexingming;
	}
			
}
