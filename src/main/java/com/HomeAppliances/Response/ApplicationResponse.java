package com.HomeAppliances.Response;

import lombok.Data;

@Data
public class ApplicationResponse {

    private Long responseCode;

    private String responseMessage;

    private Object payload;

//    public ApplicationResponse(Long responseCode, String responseMessage, Object payload) {
//        this.responseCode = responseCode;
//        this.responseMessage = responseMessage;
//        this.payload = payload;
//    }
//
//    public void ApplianceResponse() {
//    }

}
