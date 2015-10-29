package br.com.rdscon.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class RedisController {
	
	@Bean
	public RedisService getService() {
		return new RedisService();
	}
	
	@RequestMapping("/spring-redis")
	public String home() {
//		RedisService service = new RedisService();
//		return getService().getValueFromRedis();
		return getService().getValueFromMap();
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RedisController.class, args);
	}

}