package com.slf_java.service;

import com.slf_java.factory.ResponseModelFactory;
import com.slf_java.rest.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class StatusService {


    @Autowired
    ResponseModelFactory responseModelFactory;

    //TODO: Could pull this out into a config file
    final String AMAZON_API = "https://www.amazon.com";
    final String GOOGLE_API = "https://www.google.com";


    public ResponseModel getStatus(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36");

        HttpEntity<String> entity = new HttpEntity<>("", headers);


        RestTemplate restTemplate = new RestTemplate();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        stopWatch.stop();

        return responseModelFactory.buildUserModel(url, responseEntity.getStatusCode().value(), stopWatch.getTotalTimeMillis());

    }

    public List<ResponseModel> getAllStatuses() {

        List<String> urls = Arrays.asList(GOOGLE_API, AMAZON_API);

        return urls.stream().map(this::getStatus).toList();

    }

    public ResponseModel getGoogleStatus() {
        return getStatus(GOOGLE_API);
    }

    public ResponseModel getAmazonStatus() {
        return getStatus(AMAZON_API);
    }

}
