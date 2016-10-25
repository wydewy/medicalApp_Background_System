package cn.edu.bupt.springmvc.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.bupt.springmvc.core.generic.GenericController;
import cn.edu.bupt.springmvc.web.model.Hospital;
import cn.edu.bupt.springmvc.web.service.HospitalService;

@Controller
@RequestMapping(value="hospital")
public class HospitalController extends GenericController {

	@Resource 
	private HospitalService hospitalService;
	
	@RequestMapping(value="insert")
	public void insert(HttpServletRequest request,HttpServletResponse response,Hospital record){
		int i = hospitalService.insert(record);
		if (i>0) {
			renderSuccessString(response, record);
		} else {
			renderErrorString(response, "insert table Hospital failed!");
		}
	}
	
	@RequestMapping(value="select")
	public void select(HttpServletRequest request, HttpServletResponse response){
		List<Hospital> list = hospitalService.selectByExample();
		if ( list!=null) {
			renderSuccessString(response, list);
		} else {
			renderErrorString(response, "select from Hospital no data!");
		}
	}
	
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response){
		Hospital hospital = new Hospital();
		int i = hospitalService.updateByPrimaryKeySelective(hospital);
		if (i>0) {
			renderSuccessString(response, hospital);
		} else {
			renderSuccessString(response, "update table Hospital failed!");
		}
	}
	
	@RequestMapping(value="delete")
	public void delete(HttpServletRequest request, HttpServletResponse response){
		int i = hospitalService.deleteByExample();
		if (i>0) {
			renderSuccessString(response, "delete table Hospital record");
		} else {
			renderErrorString(response, "delete table Hospital error!");
		}
	}
}
