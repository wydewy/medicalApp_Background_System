package cn.edu.bupt.springmvc.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.bupt.springmvc.core.generic.GenericController;
import cn.edu.bupt.springmvc.web.model.Releasenum;
import cn.edu.bupt.springmvc.web.service.ReleasenumService;

@Controller
@RequestMapping(value="releasenum")
public class ReleasenumController extends GenericController {

	@Resource
	private ReleasenumService releasenumService;
	
	@RequestMapping(value="insert")
	public void insert(HttpServletRequest request, HttpServletResponse response){
		Releasenum releasenum = new Releasenum();
		int i = releasenumService.insert(releasenum);
		if (i>0) {
			renderSuccessString(response, releasenum);
		} else {
			renderErrorString(response, "insert releasenum failed!");
		}
	}
	
	@RequestMapping(value="selectByExample")
	public void select(HttpServletRequest request, HttpServletResponse response){
		List<Releasenum> list = releasenumService.selectByExample();
		if(list!=null){
			renderSuccessString(response, list);
		} else {
			renderErrorString(response, "select releasenum no data");
		}
		
	}
	
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response){
		Releasenum releasenum = new Releasenum();
		int i = releasenumService.updateByPrimaryKeySelective(releasenum);
		if (i>0) {
			renderSuccessString(response, "update releasenum success!");
		} else {
			renderErrorString(response, "update releasenum failed!");
		}
	}
	
	@RequestMapping(value="delete")
	public void delete(HttpServletRequest request,HttpServletResponse response){
		int i = releasenumService.deleteByExample();
		if (i>0) {
			renderSuccessString(response, "delete releasenum record success!");
		} else {
			renderErrorString(response, "delete releasenum record failed!");
		}
	}
}



