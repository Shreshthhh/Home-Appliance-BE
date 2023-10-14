package com.HomeAppliances.Response;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ApplianceResponse {

    private String applianceId;

    private String name;

    private String description;

    private Timestamp createdOn;

}
