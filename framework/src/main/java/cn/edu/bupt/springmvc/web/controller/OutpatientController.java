package cn.edu.bupt.springmvc.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.bupt.springmvc.core.generic.GenericController;
import cn.edu.bupt.springmvc.web.model.Outpatient;
import cn.edu.bupt.springmvc.web.service.OutpatientService;

@Controller
@RequestMapping(value="outpatient")
public class OutpatientController extends GenericController {

	@Resource
	private OutpatientService outpatientService;
	
	@RequestMapping(value="insert")
	public void insert(HttpServletRequest request, HttpServletResponse response){
		Outpatient outpatient = new Outpatient();
		int i = outpatientService.insert(outpatient);
		if (i>0) {
			renderSuccessString(response, outpatient);
		} else {
			renderErrorString(response, "insert outpatient failed!");
		}
	}
	
	@RequestMapping(value="selectByExample")
	public void select(HttpServletRequest request, HttpServletResponse response){
		List<Outpatient> list = outpatientService.selectByExample();
		if(list!=null){
			renderSuccessString(response, list);
		} else {
			renderErrorString(response, "select outpatient no data");
		}
		
	}
	
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response){
		Outpatient outpatient = new Outpatient();
		int i = outpatientService.updateByPrimaryKeySelective(outpatient);
		if (i>0) {
			renderSuccessString(response, "update outpatient success!");
		} else {
			renderErrorString(response, "update outpatient failed!");
		}
	}
	
	@RequestMapping(value="delete")
	public void delete(HttpServletRequest request,HttpServletResponse response){
		int i = outpatientService.deleteByExample();
		if (i>0) {
			renderSuccessString(response, "delete outpatient record success!");
		} else {
			renderErrorString(response, "delete outpatient record failed!");
		}
	}
}


