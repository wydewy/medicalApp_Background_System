package cn.edu.bupt.springmvc.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.bupt.springmvc.core.generic.GenericController;
import cn.edu.bupt.springmvc.web.model.Doctor;
import cn.edu.bupt.springmvc.web.service.DoctorService;

@Controller
@RequestMapping(value="doctor")
public class DoctorController extends GenericController {
	
	@Resource
	private DoctorService doctorService;
	
	@RequestMapping(value="insert")
	public void insert(HttpServletRequest request, HttpServletResponse response, Doctor doctor){
		int i = doctorService.insert(doctor);
		if (i>0) {
			renderSuccessString(response, doctor);
		} else {
			renderErrorString(response, "insert doctor failed!");
		}
	}
	
	@RequestMapping(value="selectByExample")
	public void select(HttpServletRequest request, HttpServletResponse response){
		List<Doctor> list = doctorService.selectByExample();
		if(list!=null){
			renderSuccessString(response, list);
		} else {
			renderErrorString(response, "select doctor no data");
		}
		
	}
	
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response){
		Doctor doctor = new Doctor();
		int i = doctorService.updateByPrimaryKeySelective(doctor);
		if (i>0) {
			renderSuccessString(response, "update doctor success!");
		} else {
			renderErrorString(response, "update doctor failed!");
		}
	}
	
	@RequestMapping(value="delete")
	public void delete(HttpServletRequest request,HttpServletResponse response){
		int i = doctorService.deleteByExample();
		if (i>0) {
			renderSuccessString(response, "delete doctor record success!");
		} else {
			renderErrorString(response, "delete doctor record failed!");
		}
	}
}
