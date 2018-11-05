package com.yan.demo.controller;

import java.util.List;

import com.yan.demo.entity.UserInfo;
import com.yan.demo.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//日志
	private Logger log = Logger.getLogger(UserController.class);
	
	@RequestMapping("/getUsers.do")
	public String getUserList(Model model) {
		log.info("查询用户信息Controller");
		List<UserInfo> userList = userService.getUserList();
		model.addAttribute("userList", userList);
		return "/userInfo";
	}

}
