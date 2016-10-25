package cn.edu.bupt.springmvc.web.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.bupt.springmvc.web.model.Interest;
import cn.edu.bupt.springmvc.web.model.InterestExample;

public interface InterestService {

	int insert(Interest record);
	
	List<Interest> selectByExample();
	
	List<Interest> selectByPage(int page,int rows);
	
	int updateByPrimaryKeySelective(@Param("record") Interest record);
	
	int deleteByExample();
}
