package com.entity.view;

import com.entity.WeixiuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 维修信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-12 20:43:26
 */
@TableName("weixiuxinxi")
public class WeixiuxinxiView  extends WeixiuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WeixiuxinxiView(){
	}
 
 	public WeixiuxinxiView(WeixiuxinxiEntity weixiuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, weixiuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
