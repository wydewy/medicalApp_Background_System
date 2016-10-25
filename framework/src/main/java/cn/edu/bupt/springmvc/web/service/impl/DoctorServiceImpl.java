package cn.edu.bupt.springmvc.web.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.edu.bupt.springmvc.web.dao.DoctorMapper;
import cn.edu.bupt.springmvc.web.model.Doctor;
import cn.edu.bupt.springmvc.web.model.DoctorExample;
import cn.edu.bupt.springmvc.web.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Resource
	private DoctorMapper doctorMapper;
	
	private DoctorExample doctorExample;
	
	@Override
	public int insert(Doctor record) {
		String id = UUID.randomUUID().toString();
		record.setDoctorid(id);
		record.setOutpatientid("22222"); //门诊表主键（外键）
		record.setDoctorname("张平");
		record.setPichead("");
		record.setPosition("主治医生");
		record.setSpecial("擅长外科手术");
		record.setSection("外科");
		record.setDoctorintro("医生简介");
		record.setFlag(new Byte((byte) 2));
		record.setSex("男");
		record.setGraduinstitution("医科大");
		record.setTutorqualification("有从业导师资格证");
		record.setDegree("硕士");
		record.setMarjor("外科");
		record.setParttimeacademic(null);
		record.setCertificatehold("国家一级证书");
		record.setIsfamilydoc(null);
		record.setTelephone(null);
		record.setRelnubcount((byte)100);
		return doctorMapper.insert(record);
	}

	@Override
	public List<Doctor> selectByExample() {
		doctorExample = new DoctorExample();
		doctorExample.createCriteria().andDoctornameEqualTo("张平");
		List<Doctor> list = doctorMapper.selectByExample(doctorExample);
		return list;
	}

	@Override
	public List<Doctor> selectByPage(int page, int rows) {
		doctorExample = new DoctorExample();
		PageHelper.startPage(page,rows);
		List<Doctor> list = doctorMapper.selectByExample(doctorExample);
		return list;
	}

	@Override
	public int updateByPrimaryKeySelective(Doctor record) {
		record.setDoctorid("2f869097-31fc-44c8-ac92-ff516faa3bf3");
		record.setOutpatientid("22222"); //门诊表主键（外键）
		record.setDoctorname("张平");
		record.setPichead("");
		record.setPosition("主治医生");
		record.setSpecial("擅长外科手术");
		record.setSection("外科");
		record.setDoctorintro("医生简介");
		record.setFlag(new Byte((byte) 2));
		record.setSex("男");
		record.setGraduinstitution("医科大");
		record.setTutorqualification("有从业导师资格证");
		record.setDegree("硕士");
		record.setMarjor("外科");
		record.setParttimeacademic(null);
		record.setCertificatehold("国家一级证书");
		record.setIsfamilydoc(null);
		record.setTelephone(null);
		record.setRelnubcount((byte)100);
		int i = doctorMapper.updateByPrimaryKeySelective(record);
		return i;
	}

	@Override
	public int deleteByExample() {
		doctorExample = new DoctorExample();
		doctorExample.createCriteria().andDoctornameEqualTo("王明");
		int i = doctorMapper.deleteByExample(doctorExample);
		return i;
	}

}
