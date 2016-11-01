package cn.edu.bupt.springmvc.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.bupt.springmvc.core.generic.GenericController;
import cn.edu.bupt.springmvc.web.model.Customer;
import cn.edu.bupt.springmvc.web.service.CustomerService;

@Controller
@RequestMapping(value="customer")
public class CustomerController extends GenericController {
	
	@Resource
	private CustomerService customerService;
	
	@RequestMapping(value="insert")
	public void insert(HttpServletRequest request, HttpServletResponse response){
		Customer record = new Customer();
		int i = customerService.insert(record);
		if (i>0) {
			renderSuccessString(response, record);
		} else {
			renderErrorString(response, "insert table customer failed!");
		}
	}
	
	@RequestMapping(value="selectByExample")
	public void select(HttpServletRequest request, HttpServletResponse response){
		List<Customer> list = customerService.selectByExample();
		if(list!=null){
			renderSuccessString(response, list);
		} else {
			renderErrorString(response, "select customer no data");
		}
		
	}
	
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response){
		Customer record = new Customer();
		int i = customerService.updateByPrimaryKeySelective(record);
		if (i>0) {
			renderSuccessString(response, "update customer success!");
		} else {
			renderErrorString(response, "update customer failed!");
		}
	}
	
	@RequestMapping(value="delete")
	public void delete(HttpServletRequest request,HttpServletResponse response){
		int i = customerService.deleteByExample();
		if (i>0) {
			renderSuccessString(response, "delete customer record success!");
		} else {
			renderErrorString(response, "delete customer record failed!");
		}
	}
	
	/**
	 * 用户登录验证
	 * @author lhh
	 */
	@RequestMapping(value="loginVerifyByUserName", method=RequestMethod.POST)
	public void loginVerify(HttpServletRequest request, HttpServletResponse response){
		String userName = request.getParameter("account");
		// TODO
		Customer custoemr = new Customer();
		try {
			custoemr = customerService.loginVerifyByUserName(userName);
			if (custoemr != null) {
				renderSuccessString(response, custoemr);
			} else {
				renderErrorString(response, "can't obtain customer infor");
			}
		} catch (Exception e) {
			renderErrorString(response, "can't obtain customer infor");
			e.printStackTrace();
		}
		
	}
}

