package com.entity.model;

import com.entity.YuyuexinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 预约信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-12 20:43:26
 */
public class YuyuexinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 电桩分类
	 */
	
	private String dianzhuangfenlei;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 充电电压
	 */
	
	private String chongdiandianya;
		
	/**
	 * 充电电流
	 */
	
	private String chongdiandianliu;
		
	/**
	 * 价格
	 */
	
	private Double jiage;
		
	/**
	 * 充电速度
	 */
	
	private String chongdiansudu;
		
	/**
	 * 电量
	 */
	
	private Double dianliang;
		
	/**
	 * 预约数量
	 */
	
	private Integer dianzhuangshuliang;
		
	/**
	 * 所处位置
	 */
	
	private String suochuweizhi;
		
	/**
	 * 预约时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date yuyueshijian;
		
	/**
	 * 业主账号
	 */
	
	private String yezhuzhanghao;
		
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
	 * 设置：电桩分类
	 */
	 
	public void setDianzhuangfenlei(String dianzhuangfenlei) {
		this.dianzhuangfenlei = dianzhuangfenlei;
	}
	
	/**
	 * 获取：电桩分类
	 */
	public String getDianzhuangfenlei() {
		return dianzhuangfenlei;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：充电电压
	 */
	 
	public void setChongdiandianya(String chongdiandianya) {
		this.chongdiandianya = chongdiandianya;
	}
	
	/**
	 * 获取：充电电压
	 */
	public String getChongdiandianya() {
		return chongdiandianya;
	}
				
	
	/**
	 * 设置：充电电流
	 */
	 
	public void setChongdiandianliu(String chongdiandianliu) {
		this.chongdiandianliu = chongdiandianliu;
	}
	
	/**
	 * 获取：充电电流
	 */
	public String getChongdiandianliu() {
		return chongdiandianliu;
	}
				
	
	/**
	 * 设置：价格
	 */
	 
	public void setJiage(Double jiage) {
		this.jiage = jiage;
	}
	
	/**
	 * 获取：价格
	 */
	public Double getJiage() {
		return jiage;
	}
				
	
	/**
	 * 设置：充电速度
	 */
	 
	public void setChongdiansudu(String chongdiansudu) {
		this.chongdiansudu = chongdiansudu;
	}
	
	/**
	 * 获取：充电速度
	 */
	public String getChongdiansudu() {
		return chongdiansudu;
	}
				
	
	/**
	 * 设置：电量
	 */
	 
	public void setDianliang(Double dianliang) {
		this.dianliang = dianliang;
	}
	
	/**
	 * 获取：电量
	 */
	public Double getDianliang() {
		return dianliang;
	}
				
	
	/**
	 * 设置：预约数量
	 */
	 
	public void setDianzhuangshuliang(Integer dianzhuangshuliang) {
		this.dianzhuangshuliang = dianzhuangshuliang;
	}
	
	/**
	 * 获取：预约数量
	 */
	public Integer getDianzhuangshuliang() {
		return dianzhuangshuliang;
	}
				
	
	/**
	 * 设置：所处位置
	 */
	 
	public void setSuochuweizhi(String suochuweizhi) {
		this.suochuweizhi = suochuweizhi;
	}
	
	/**
	 * 获取：所处位置
	 */
	public String getSuochuweizhi() {
		return suochuweizhi;
	}
				
	
	/**
	 * 设置：预约时间
	 */
	 
	public void setYuyueshijian(Date yuyueshijian) {
		this.yuyueshijian = yuyueshijian;
	}
	
	/**
	 * 获取：预约时间
	 */
	public Date getYuyueshijian() {
		return yuyueshijian;
	}
				
	
	/**
	 * 设置：业主账号
	 */
	 
	public void setYezhuzhanghao(String yezhuzhanghao) {
		this.yezhuzhanghao = yezhuzhanghao;
	}
	
	/**
	 * 获取：业主账号
	 */
	public String getYezhuzhanghao() {
		return yezhuzhanghao;
	}
				
	
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
			
}
