package cn.edu.bupt.springmvc.web.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import cn.edu.bupt.springmvc.web.model.Doctor;

public interface DoctorService {
	
	int insert(Doctor record);
	
	List<Doctor> selectByExample();
	
	List<Doctor> selectByPage(int page,int rows);
	
	int updateByPrimaryKeySelective(@Param("record") Doctor record);
	
	int deleteByExample();
	
	public Doctor getDoctorDetailInfo(String doctorId) throws Exception;
	
	public List<Doctor> getDoctorReleaseNumByOutPatientId(String outpatientId) throws Exception;
}
