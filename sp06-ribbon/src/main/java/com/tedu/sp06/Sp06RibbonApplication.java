package com.tedu.sp06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class Sp06RibbonApplication {
	//新建RestTemplate实例,放入Spring 容器
	//生成一个动态代理对象,切入负载均衡代码
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		SimpleClientHttpRequestFactory f = new SimpleClientHttpRequestFactory();
		f.setConnectTimeout(1000);
		f.setReadTimeout(1000);
		return new RestTemplate(f);
		
		//RestTemplate 中默认的 Factory 实例中，两个超时属性默认是 -1，
		//未启用超时，也不会触发重试
		//return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(Sp06RibbonApplication.class, args);
	}

}


