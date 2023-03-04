package com.slf_java.rest.model;

import lombok.Data;

@Data
public class ResponseModel {

    public String url;
    public Integer statusCode;
    public Long duration;
    public Long date;

}
