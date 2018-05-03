package com.movie.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.movie.pojo.Adminse;
import com.movie.service.IAdminService;

@Controller
@RequestMapping("/admin")
public class AdminAction {
	@Resource(name = "adminService")
	private IAdminService adminService;

	@RequestMapping(value = "/loginAdmin", method = RequestMethod.POST)
	public String loginAdmin(Adminse adminse, String account, String adminPassword, HttpServletRequest request,
			HttpSession httpSession) {
		System.out.println("accout:"+account);
		System.out.println("adminPassword:"+adminPassword);
		System.out.println("adminse:"+adminse);
		Adminse loginAdminse = null;
		loginAdminse = adminService.login(adminse.getAccount(), adminse.getAdminPassword());
		if (loginAdminse != null) {
			httpSession.setAttribute("loginAdminse", loginAdminse);
			return "admin/manage";
		} else {
			request.setAttribute("msgg", "账号或密码错误，请重新输入！！！");
			return "admin/login";
		}
	}
}
