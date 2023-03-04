package com.slf_java.rest;

import com.slf_java.rest.model.ResponseModel;
import com.slf_java.service.StatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TakeHomeController {

    @Autowired
    StatusService statusService;



    @GetMapping("v1/amazon-status")
    //TODO: Would pull this out into a config file
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseModel getAmazonStatus() {
        return statusService.getAmazonStatus();

    }

    @GetMapping("v1/google-status")
    //TODO: Would pull this out into a config file
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseModel getGoogleStatus() {
        return statusService.getGoogleStatus();
    }

    @GetMapping("v1/all-status")
    //TODO: Would pull this out into a config file
    @CrossOrigin(origins = "http://localhost:3000")
    public List<ResponseModel> getAllStatus() {
        return statusService.getAllStatuses();
    }



}
