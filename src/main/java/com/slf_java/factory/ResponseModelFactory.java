package com.slf_java.factory;

import com.slf_java.rest.model.ResponseModel;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class ResponseModelFactory {

    public ResponseModel buildUserModel(String url, Integer statusCode, long duration){

        ResponseModel responseModel = new ResponseModel();
        responseModel.setDate(Instant.now().getEpochSecond());
        responseModel.setDuration(duration);
        responseModel.setStatusCode(statusCode);
        responseModel.setUrl(url);

        return responseModel;

    }



}
