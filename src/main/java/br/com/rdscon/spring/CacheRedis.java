package br.com.rdscon.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import redis.clients.jedis.Jedis;

@RestController
@EnableAutoConfiguration
public class CacheRedis {

    @RequestMapping("/spring-boot-test")
    public String home() {
    		Jedis jedis = new Jedis("54.94.184.30", 55);
    		jedis.set("foo", "bar");
    		
    		jedis.close();
    		
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CacheRedis.class, args);
    }

}