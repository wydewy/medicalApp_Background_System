package cn.edu.bupt.springmvc.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.bupt.springmvc.core.generic.GenericController;
import cn.edu.bupt.springmvc.web.model.Interest;
import cn.edu.bupt.springmvc.web.service.InterestService;

@Controller
@RequestMapping(value="interest")
public class InterestController extends GenericController {

	@Resource
	private InterestService interestService;
	
	@RequestMapping(value="insert")
	public void insert(HttpServletRequest request, HttpServletResponse response){
		Interest interest = new Interest();
		int i = interestService.insert(interest);
		if (i>0) {
			renderSuccessString(response, interest);
		} else {
			renderErrorString(response, "insert interest failed!");
		}
	}
	
	@RequestMapping(value="selectByExample")
	public void select(HttpServletRequest request, HttpServletResponse response){
		List<Interest> list = interestService.selectByExample();
		if(list!=null){
			renderSuccessString(response, list);
		} else {
			renderErrorString(response, "select interest no data");
		}
		
	}
	
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response){
		Interest interest = new Interest();
		int i = interestService.updateByPrimaryKeySelective(interest);
		if (i>0) {
			renderSuccessString(response, "update interest success!");
		} else {
			renderErrorString(response, "update interest failed!");
		}
	}
	
	@RequestMapping(value="delete")
	public void delete(HttpServletRequest request,HttpServletResponse response){
		int i = interestService.deleteByExample();
		if (i>0) {
			renderSuccessString(response, "delete interest record success!");
		} else {
			renderErrorString(response, "delete interest record failed!");
		}
	}
}

