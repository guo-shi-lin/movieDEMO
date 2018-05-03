package com.movie.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.movie.pojo.Movies;
import com.movie.pojo.User;
import com.movie.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserAction {
	@Resource(name = "userService")
	private IUserService userService;

	@RequestMapping("/getAllUser")
	public ModelAndView getAllUser(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("userList", userService.getAllUser());
		mv.setViewName("user/list");
		return mv;
	}

	@RequestMapping("/toAddUser")
	public String toAddUser() {
		return "user/addUser";
	}
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	
	public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap map, Movies movie) {
		synchronized(user){
				if (result.hasErrors()) {
					List<FieldError> errorList = result.getFieldErrors();
					for (FieldError error : errorList) {
						map.put("ERR_" + error.getField(), error.getDefaultMessage());
					}
					return "user/addUser";
				} else {
					userService.addUser(user);
					return "redirect:/userlogin.jsp";
				}
		}
	}

	@RequestMapping("/delUser")
	public String delUser(String id, HttpServletResponse response) {
		userService.delUser(id);
		return "redirect:/user/getAllUser";
	}

	@RequestMapping("/getUser")
	public String getUser(String id, HttpServletRequest request) {
		request.setAttribute("user", userService.getUser(id));
		return "user/editUser";
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap map,
			HttpServletRequest request) {
		synchronized (user) {
			if (result.hasErrors()) {
				List<FieldError> errorList = result.getFieldErrors();
				for (FieldError error : errorList) {
					map.put("ERR_" + error.getField(), error.getDefaultMessage());
				}
				return "user/editUser";
			}
			userService.updateUser(user);
			user = userService.getUser(user.getId());
			request.setAttribute("user", user);
			return "redirect:/movie/getAllMovie";
		}
		
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String loginUser(ModelMap model, User user, HttpServletRequest request, HttpSession httpSession) {
		synchronized (user) {
			User loginUser = null;
			loginUser = userService.login(user.getUserName(), user.getUserPassword());
			if (loginUser != null) {
				httpSession.setAttribute("loginUser", loginUser);
				return "redirect:/movie/getAllMovie";

			} else{
				request.setAttribute("msg", "账号或密码填写错误！！！");
			return "userlogin";
			}
		}
	}

	@RequestMapping("/loginOut")
	public String loginOut(HttpServletRequest request, HttpSession session) {
		request.getSession().removeAttribute("loginUser");
		request.getSession().invalidate();
		return "redirect:/movie/getAllMovie";
	}
	@RequestMapping("/name")
	public void name(String userName,HttpServletResponse response){
		System.out.println("userName:"+userName);
		PrintWriter out=null;
		List<User>list = null;
		response.setContentType("text/html;charset=utf-8");
		try {
		out = response.getWriter();
		list = userService.findByName(userName);
		System.out.println("list:"+list);
		if(list!=null){
			out.println("用户名已存在");
		 }
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(out!=null){
				out.close();
			}
		}
	}
	
}
