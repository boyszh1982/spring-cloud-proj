package org.test.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HelloBootController {

	@RequestMapping("hello")
	public String hello(){
		/*
		刷新前返回:1907517568,org.test.controller.HelloBootController@71b26880
		刷新后返回:1907517568,org.test.controller.HelloBootController@71b26880
		没有@RefreshScope注解的类不会重新实例化对象
		 */
		return this.hashCode()+","+this.toString();
	}
}
