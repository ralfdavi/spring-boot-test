package br.com.rdscon.spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;

import com.google.gson.Gson;

@Component
public class RedisService {
	
	private static final Integer NUMBER_OF_OBJECTS = 1000000;

	public String getValueFromMap() {
		Long dataInicio = System.currentTimeMillis();

		StringBuffer sb = new StringBuffer();

		Map<Long, UserDTO> users = new HashMap<Long, UserDTO>();
		for(int i = 1; i <= NUMBER_OF_OBJECTS; i++) {
			UserDTO user = new UserDTO();
			user.setId(String.valueOf(i));
			user.setName("USER NAME #" + i);
			user.setEmail("email_" + i +"@domain.com");
			users.put(Long.valueOf(i), user);
		}
		sb.append("Value 43234 from Redis at first time -> " + users.get(43234L));

		Long dataFim = System.currentTimeMillis();
		System.out.println((dataFim - dataInicio) / 1000.0);

		String timeToRead = String.valueOf((dataFim - dataInicio) / 1000.0);
		
		sb.append("Time to read -> " + timeToRead);
		System.out.println(timeToRead);
		
    return sb.toString();
	}

	public String getValueFromRedis() {
		Long dataInicio = System.currentTimeMillis();
  	
		Jedis jedis = new Jedis("54.94.184.30", 6379);
		
		String object = jedis.get("users");
		StringBuffer sb = new StringBuffer();
		Gson json = new Gson();	

		if(object == null) {
  		
  		Map<Long, UserDTO> users = new HashMap<Long, UserDTO>();
  		for(int i = 1; i <= NUMBER_OF_OBJECTS; i++) {
  			UserDTO user = new UserDTO();
  			user.setId(String.valueOf(i));
  			user.setName("USER NAME #" + i);
  			user.setEmail("email_" + i +"@domain.com");
  			users.put(Long.valueOf(i), user);
  		}
			sb.append("Value 43234 from Redis at first time -> " + users.get(43234));
  		
  		jedis.set("users", json.toJson(users));
  		jedis.expire("users", 50);
  		
		} else {
			Map<Long, UserDTO> users = json.fromJson(object, Map.class);
			sb.append("Value 43234 from Redis before first -> " + users.get(43234));
		}
		
		jedis.close();

		Long dataFim = System.currentTimeMillis();
		
		String timeToRead = String.valueOf((dataFim - dataInicio) / 1000.0);
		
		sb.append("Time to read -> " + timeToRead);
		System.out.println(timeToRead);
		
    return sb.toString();
	}

}