package com.entity.model;

import com.entity.WuyejiaofeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 物业缴费
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-12 20:43:26
 */
public class WuyejiaofeiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 业主账号
	 */
	
	private String yezhuzhanghao;
		
	/**
	 * 业主姓名
	 */
	
	private String yezhuxingming;
		
	/**
	 * 楼号
	 */
	
	private String louhao;
		
	/**
	 * 门牌号
	 */
	
	private String menpaihao;
		
	/**
	 * 发票
	 */
	
	private String fapiao;
		
	/**
	 * 费用类型
	 */
	
	private String feiyongleixing;
		
	/**
	 * 费用
	 */
	
	private Double feiyong;
		
	/**
	 * 备注
	 */
	
	private String beizhu;
		
	/**
	 * 发布时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fabushijian;
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
		
	/**
	 * 用户id
	 */
	
	private Long userid;
				
	
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
	 * 设置：发票
	 */
	 
	public void setFapiao(String fapiao) {
		this.fapiao = fapiao;
	}
	
	/**
	 * 获取：发票
	 */
	public String getFapiao() {
		return fapiao;
	}
				
	
	/**
	 * 设置：费用类型
	 */
	 
	public void setFeiyongleixing(String feiyongleixing) {
		this.feiyongleixing = feiyongleixing;
	}
	
	/**
	 * 获取：费用类型
	 */
	public String getFeiyongleixing() {
		return feiyongleixing;
	}
				
	
	/**
	 * 设置：费用
	 */
	 
	public void setFeiyong(Double feiyong) {
		this.feiyong = feiyong;
	}
	
	/**
	 * 获取：费用
	 */
	public Double getFeiyong() {
		return feiyong;
	}
				
	
	/**
	 * 设置：备注
	 */
	 
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
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
	 * 设置：是否支付
	 */
	 
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
				
	
	/**
	 * 设置：用户id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
			
}
