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
	
	/**
	 * @author qjk
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="selectBySection", method=RequestMethod.POST)
	public void selectBySection(HttpServletRequest request, HttpServletResponse response){
		String sectionName = request.getParameter("data");
		List<Doctor> list = doctorService.selectBySection(sectionName);
		if(list!=null){
			renderSuccessString(response, list);
		} else {
			renderErrorString(response, "select doctor no data");
		}
		
	}
	
	/**
	 * @author qjk
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="searchDoctorInfo", method=RequestMethod.POST)
	public void searchDoctorInfo(HttpServletRequest request, HttpServletResponse response){
		String doctorId = request.getParameter("data");
		//System.out.println(doctorId);
		Doctor record = doctorService.searchDoctorInfo(doctorId);
		//System.out.println(record);
		if(record!=null){
			renderSuccessString(response, record);
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
	
	
	/**
	 * 根据医生id查询医生的详细信息
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "getDoctorDetailByDoctorId", method = RequestMethod.GET)
	public void getDoctorDetailByDoctorId(HttpServletRequest request, HttpServletResponse response) {
		
		String doctorId = request.getParameter("doctorId");
		
		if (doctorId != null && !"".equals(doctorId)) {
			try {
				Doctor doctor = doctorService.getDoctorDetailInfo(doctorId);
				renderSuccessString(response, doctor);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				renderErrorString(response, "can't obtain doctorDetail!");
				e.printStackTrace();
			}
		} else {
			renderErrorString(response, "NullPointException！");
		}
	}

	/**
	 * 根据门诊Id查询所有的医生信息和医生所对应的放号的信息
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "getDoctorReleaseNumDetailByOutpatientId", method = RequestMethod.GET)
	public void getDoctorReleaseNumDetailByOutpatientId(HttpServletRequest request, HttpServletResponse response) {
		
		String outpatient = request.getParameter("outpatientId");
		List<Doctor> doctorList = new ArrayList<>();
		
		if (outpatient != null && !"".equals(outpatient)) {
			try {
				doctorList = doctorService.getDoctorReleaseNumByOutPatientId(outpatient);
				renderSuccessString(response, doctorList);
			} catch (Exception e) {
				renderErrorString(response, "can't obtain doctorReleaseNumDetail!");
				e.printStackTrace();
			}
		} else {
			renderErrorString(response, "NullPointException！");
		}
	}
}
