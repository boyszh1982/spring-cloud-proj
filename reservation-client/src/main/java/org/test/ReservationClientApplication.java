package org.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 必有有zuul一类的gatekeeper ，才能去eureka-server选择接口。
 * http://192.168.1.100:8050/reservation-service/message 通过zuul访问接口
 * http://192.168.1.100:8001/message 直接访问接口
 * sts 报错，找不到ZuulFilter可忽略，用命令行启动reservation-client即可
 * @author Administrator
 *
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ReservationClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationClientApplication.class, args);
	}
}
