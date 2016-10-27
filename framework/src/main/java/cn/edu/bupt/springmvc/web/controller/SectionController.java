package cn.edu.bupt.springmvc.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.bupt.springmvc.core.generic.GenericController;
import cn.edu.bupt.springmvc.web.model.Doctor;
import cn.edu.bupt.springmvc.web.model.Releasenum;
import cn.edu.bupt.springmvc.web.model.Section;
import cn.edu.bupt.springmvc.web.service.ReleasenumService;
import cn.edu.bupt.springmvc.web.service.SectionService;

@Controller
@RequestMapping(value="section")
public class SectionController extends GenericController {

	@Resource
	private SectionService sectionService;
	
	@RequestMapping(value="insert")
	public void insert(HttpServletRequest request, HttpServletResponse response){
		Section section = new Section();
		int i = sectionService.insert(section);
		if (i>0) {
			renderSuccessString(response, section);
		} else {
			renderErrorString(response, "insert section failed!");
		}
	}
	
	@RequestMapping(value="selectByExample")
	public void select(HttpServletRequest request, HttpServletResponse response){
		List<Section> list = sectionService.selectByExample();
		if(list!=null){
			renderSuccessString(response, list);
		} else {
			renderErrorString(response, "select section no data");
		}
		
	}
	
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response){
		Section section = new Section();
		int i = sectionService.updateByPrimaryKeySelective(section);
		if (i>0) {
			renderSuccessString(response, "update section success!");
		} else {
			renderErrorString(response, "update section failed!");
		}
	}
	
	@RequestMapping(value="delete")
	public void delete(HttpServletRequest request,HttpServletResponse response){
		int i = sectionService.deleteByExample();
		if (i>0) {
			renderSuccessString(response, "delete section record success!");
		} else {
			renderErrorString(response, "delete section record failed!");
		}
	}
	
	/**
	 * 根据科室主键得到科室下的所有的医生
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "getSeciontDoctorListBySectionId", method = RequestMethod.GET)
	public void getSeciontDoctorListBySectionId(HttpServletRequest request, HttpServletResponse response) {
		
		List<Doctor> doctorList = new ArrayList<>();
		String sectionId = request.getParameter("sectionId");
		
		if (sectionId != null && !"".equals(sectionId)) {
			try {
				doctorList = sectionService.getSectionDoctorList(sectionId);
				renderSuccessString(response, doctorList);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				renderErrorString(response, "can't obtain doctorList!");
				e.printStackTrace();
			}
		} else {
			renderErrorString(response, "NullPointException！");
		}

	}

}

