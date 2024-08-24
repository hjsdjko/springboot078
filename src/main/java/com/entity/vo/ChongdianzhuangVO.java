package com.entity.vo;

import com.entity.ChongdianzhuangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 充电桩
 * @author 
 * @email 
 * @date 2024-04-12 20:43:26
 */
public class ChongdianzhuangVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
	 * 电桩数量
	 */
	
	private Integer dianzhuangshuliang;
		
	/**
	 * 注意事项
	 */
	
	private String zhuyishixiang;
		
	/**
	 * 所处位置
	 */
	
	private String suochuweizhi;
		
	/**
	 * 详细介绍
	 */
	
	private String xiangxijieshao;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
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
	 * 设置：电桩数量
	 */
	 
	public void setDianzhuangshuliang(Integer dianzhuangshuliang) {
		this.dianzhuangshuliang = dianzhuangshuliang;
	}
	
	/**
	 * 获取：电桩数量
	 */
	public Integer getDianzhuangshuliang() {
		return dianzhuangshuliang;
	}
				
	
	/**
	 * 设置：注意事项
	 */
	 
	public void setZhuyishixiang(String zhuyishixiang) {
		this.zhuyishixiang = zhuyishixiang;
	}
	
	/**
	 * 获取：注意事项
	 */
	public String getZhuyishixiang() {
		return zhuyishixiang;
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
	 * 设置：详细介绍
	 */
	 
	public void setXiangxijieshao(String xiangxijieshao) {
		this.xiangxijieshao = xiangxijieshao;
	}
	
	/**
	 * 获取：详细介绍
	 */
	public String getXiangxijieshao() {
		return xiangxijieshao;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
