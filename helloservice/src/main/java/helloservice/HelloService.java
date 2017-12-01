package helloservice;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
// @MapperScan("helloservice.model.mapper")
@SpringBootApplication(scanBasePackages = "helloservice")
public class HelloService {
	public static void main(String[] args) {
		SpringApplication.run(HelloService.class, args);
	}
}