package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WuyejiaofeiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WuyejiaofeiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WuyejiaofeiView;


/**
 * 物业缴费
 *
 * @author 
 * @email 
 * @date 2024-04-12 20:43:26
 */
public interface WuyejiaofeiService extends IService<WuyejiaofeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WuyejiaofeiVO> selectListVO(Wrapper<WuyejiaofeiEntity> wrapper);
   	
   	WuyejiaofeiVO selectVO(@Param("ew") Wrapper<WuyejiaofeiEntity> wrapper);
   	
   	List<WuyejiaofeiView> selectListView(Wrapper<WuyejiaofeiEntity> wrapper);
   	
   	WuyejiaofeiView selectView(@Param("ew") Wrapper<WuyejiaofeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WuyejiaofeiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<WuyejiaofeiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<WuyejiaofeiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<WuyejiaofeiEntity> wrapper);



}

