package com.labyrinth.mryxlarkbot.tools;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Component
public class RestTemplateTools {

    @Resource
    RestTemplate restTemplate;

    public ResponseEntity<String> sendJson(String url, String json){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(json, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(url,formEntity,String.class);
        return result;
    }

}
