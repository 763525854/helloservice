package helloservice.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {
	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("login.html")
	public ModelAndView index() {
		return new ModelAndView("login");
	}
	
	@RequestMapping("ok")
	public String ok() {
		System.out.println("i am ok ,.i am running");
		return "ok";
	}
	

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() throws InterruptedException {
		ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
		int sleepTime = new Random().nextInt(2000);
		logger.info("sleepTime" + sleepTime);
		Thread.sleep(sleepTime);
		logger.info("hello ,host:" + serviceInstance.getHost() + ",service id:" + serviceInstance.getServiceId());
		return "HelloWorld";
	}

	@RequestMapping({ "/nice/{version:.+}" })
	public String hello(@PathVariable String version) {
		System.out.println(version);
		return "HelloWorld";
	}

	@RequestMapping(value = "/get")
	public void testGet(HttpServletRequest request) {
		String time=request.getParameter("orderNos");
		if (StringUtils.isEmpty(time)) {
			System.out.println("time is null");
		}else {
			System.out.println(time);
		}
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		System.out.println(name);
		System.out.println(password);
		System.out.println(request.getHeader("haha"));
	}

}
