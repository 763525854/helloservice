package helloservice.controller;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() throws InterruptedException {
		ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
		int sleepTime=new Random().nextInt(2000);
		logger.info("sleepTime"+sleepTime);
		Thread.sleep(sleepTime);
		logger.info("hello ,host:" + serviceInstance.getHost() + ",service id:" + serviceInstance.getServiceId());
		return "HelloWorld";
	}
	
	@RequestMapping({"/nice/{version:.+}"})
	public String hello(@PathVariable String version) {
		System.out.println(version);
		return "HelloWorld";
	}
}