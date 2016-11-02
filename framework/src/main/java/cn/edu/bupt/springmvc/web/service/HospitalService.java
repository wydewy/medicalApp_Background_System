package cn.edu.bupt.springmvc.web.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.bupt.springmvc.web.model.Hospital;

public interface HospitalService {

	int insert(Hospital record);
	
	List<Hospital> selectByExample();
	
	/**
	 * @author qjk
	 * @param page
	 * @param rows
	 * @return
	 */
	Hospital searchHosInfo(String hosId);
	
	List<Hospital> selectByPage(int page,int rows);
	
	int updateByPrimaryKeySelective(@Param("record") Hospital record);
	
	int deleteByExample();
	
	public List<Hospital> getHospitalSectionList(String hospitalId)throws Exception;
}
