package com.didispace.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {
        StringBuilder result = new StringBuilder();

        result.append(restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody()).append("<br>");

        result.append(restTemplate.getForEntity("http://HELLO-SERVICE/hello1?name={1}", String.class, "didi").getBody()).append("<br>");

        return result.toString();
    }

    public String helloFallback() {
        return "error";
    }

}