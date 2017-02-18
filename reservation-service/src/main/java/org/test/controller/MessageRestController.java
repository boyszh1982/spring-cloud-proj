package org.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageRestController {
	
	@Value("${message}")
	private String message ;
	
	@RequestMapping("/message")
	String message(){
		/*
		刷新前返回:Hello World Git Config Update 5 !,396875464,org.test.MessageRestController@17a7d6c8
		刷新后返回:Hello World Git Config Update 6 !,1212493204,org.test.MessageRestController@48452d94
		每次刷新后是重新生成了实例对象
		 */
		return this.message + "," + this.hashCode() + "," + this.toString();
	}
}
