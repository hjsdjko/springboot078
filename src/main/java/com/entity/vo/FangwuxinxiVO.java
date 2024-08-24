package com.entity.vo;

import com.entity.FangwuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 房屋信息
 * @author 
 * @email 
 * @date 2024-04-12 20:43:26
 */
public class FangwuxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 房源名称
	 */
	
	private String fangyuanmingcheng;
		
	/**
	 * 房屋楼号
	 */
	
	private String fangwulouhao;
		
	/**
	 * 室内图片
	 */
	
	private String shineitupian;
		
	/**
	 * 房屋视频
	 */
	
	private String fangwushipin;
		
	/**
	 * 房屋朝向
	 */
	
	private String fangwuchaoxiang;
		
	/**
	 * 房屋位置
	 */
	
	private String fangwuweizhi;
		
	/**
	 * 房屋面积
	 */
	
	private String fangwumianji;
		
	/**
	 * 发布时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fabushijian;
		
	/**
	 * 房屋详情
	 */
	
	private String fangwuxiangqing;
		
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
	 * 设置：房源名称
	 */
	 
	public void setFangyuanmingcheng(String fangyuanmingcheng) {
		this.fangyuanmingcheng = fangyuanmingcheng;
	}
	
	/**
	 * 获取：房源名称
	 */
	public String getFangyuanmingcheng() {
		return fangyuanmingcheng;
	}
				
	
	/**
	 * 设置：房屋楼号
	 */
	 
	public void setFangwulouhao(String fangwulouhao) {
		this.fangwulouhao = fangwulouhao;
	}
	
	/**
	 * 获取：房屋楼号
	 */
	public String getFangwulouhao() {
		return fangwulouhao;
	}
				
	
	/**
	 * 设置：室内图片
	 */
	 
	public void setShineitupian(String shineitupian) {
		this.shineitupian = shineitupian;
	}
	
	/**
	 * 获取：室内图片
	 */
	public String getShineitupian() {
		return shineitupian;
	}
				
	
	/**
	 * 设置：房屋视频
	 */
	 
	public void setFangwushipin(String fangwushipin) {
		this.fangwushipin = fangwushipin;
	}
	
	/**
	 * 获取：房屋视频
	 */
	public String getFangwushipin() {
		return fangwushipin;
	}
				
	
	/**
	 * 设置：房屋朝向
	 */
	 
	public void setFangwuchaoxiang(String fangwuchaoxiang) {
		this.fangwuchaoxiang = fangwuchaoxiang;
	}
	
	/**
	 * 获取：房屋朝向
	 */
	public String getFangwuchaoxiang() {
		return fangwuchaoxiang;
	}
				
	
	/**
	 * 设置：房屋位置
	 */
	 
	public void setFangwuweizhi(String fangwuweizhi) {
		this.fangwuweizhi = fangwuweizhi;
	}
	
	/**
	 * 获取：房屋位置
	 */
	public String getFangwuweizhi() {
		return fangwuweizhi;
	}
				
	
	/**
	 * 设置：房屋面积
	 */
	 
	public void setFangwumianji(String fangwumianji) {
		this.fangwumianji = fangwumianji;
	}
	
	/**
	 * 获取：房屋面积
	 */
	public String getFangwumianji() {
		return fangwumianji;
	}
				
	
	/**
	 * 设置：发布时间
	 */
	 
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
				
	
	/**
	 * 设置：房屋详情
	 */
	 
	public void setFangwuxiangqing(String fangwuxiangqing) {
		this.fangwuxiangqing = fangwuxiangqing;
	}
	
	/**
	 * 获取：房屋详情
	 */
	public String getFangwuxiangqing() {
		return fangwuxiangqing;
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
