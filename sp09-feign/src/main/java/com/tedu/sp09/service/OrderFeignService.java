package com.tedu.sp09.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tedu.sp01.pojo.Item;
import com.tedu.sp01.pojo.Order;
import com.tedu.sp01.web.util.JsonResult;

@FeignClient(name="order-service",fallback = OrderFeignServiceFB.class)
public interface OrderFeignService {
	@GetMapping("/{orderId}")
	JsonResult<Order> getOrder(@PathVariable String orderId);

	@GetMapping("/")
	JsonResult addOrder();

}
