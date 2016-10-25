package cn.edu.bupt.springmvc.web.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.bupt.springmvc.web.model.Outpatient;
import cn.edu.bupt.springmvc.web.model.OutpatientExample;

public interface OutpatientService {

	int insert(Outpatient record);
	
	List<Outpatient> selectByExample();
	
	List<Outpatient> selectByPage(int page,int rows);
	
	int updateByPrimaryKeySelective(@Param("record") Outpatient record);
	
	int deleteByExample();
}
