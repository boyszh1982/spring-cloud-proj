package com.nameless.ehcache.controller;

//import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nameless.ehcache.service.IUserService;

@Controller
@RequestMapping("cacheTest")
public class UserController {
	//@Resource
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/get/{userNo}", method = RequestMethod.GET)
	public String get(@PathVariable String userNo, Model model) {
		String username = userService.get(userNo);
		model.addAttribute("username", username);
		return "getUser";
	}

	@RequestMapping(value = "/update/{userNo}", method = RequestMethod.GET)
	public String update(@PathVariable String userNo, Model model) {
		userService.update(userNo);
		model.addAttribute("userNo", userNo);
		return "updateUser";
	}

	@RequestMapping(value = "/removeAll", method = RequestMethod.GET)
	public String removeAll() {
		userService.removeAll();
		return "removeAllUser";
	}
}