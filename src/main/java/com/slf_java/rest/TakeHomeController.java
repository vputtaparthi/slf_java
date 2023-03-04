package com.slf_java.rest;

import com.slf_java.factory.ResponseModelFactory;
import com.slf_java.rest.model.ResponseModel;
import com.slf_java.service.UptimeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TakeHomeController {

    @Autowired
    UptimeService uptimeService;



    @GetMapping("v1/amazon-status")
    public ResponseModel getAmazonStatus() {
        return uptimeService.getStatus("https://www.amazon.com");
    }

    @GetMapping("v1/google-status")
    public ResponseModel getGoogleStatus() {
        return uptimeService.getStatus("https://www.google.com");
    }

    @GetMapping("v1/all-status")
    public List<ResponseModel> getAllStatus() {
        return uptimeService.getAllStatuses();
    }



}
