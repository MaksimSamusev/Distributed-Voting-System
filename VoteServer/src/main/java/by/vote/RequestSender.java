package by.vote;

import org.springframework.web.client.RestTemplate;

public class RequestSender {

	public static void getEmployees()
	{
	    final String uri = "http://localhost:8080/VoteServer/test";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	     
	    System.out.println(result);
	}
}
