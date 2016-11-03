package cn.edu.bupt.springmvc.web.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.bupt.springmvc.web.model.Outpatient;

public interface OutpatientService {

	int insert(Outpatient record);
	
	List<Outpatient> selectByExample();
	
	List<Outpatient> selectByPage(int page,int rows);
	
	int updateByPrimaryKeySelective(@Param("record") Outpatient record);
	
	int deleteByExample();
	
	public Outpatient getOutpatientDetailsById(String outpatientId) throws Exception;
	
	/**
	 * @author qjk
	 * @param sectionName
	 * 
	 * 点击科室名称进行该科室下门诊表的查询
	 * */
	List<Outpatient> selectBySectionName(String sectionName);
	
	Outpatient selectByName(String outpatientName);
}
