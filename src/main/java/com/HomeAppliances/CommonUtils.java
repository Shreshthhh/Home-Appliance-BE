package com.HomeAppliances;

import org.apache.commons.lang3.RandomStringUtils;

public class CommonUtils {

    private static final String SUCCESS = "SUCCESS";

    private static final String APPLIANCE_ID_PREFIX = "APP";

    public static String generateApplianceId() {
        return APPLIANCE_ID_PREFIX + RandomStringUtils.randomAlphanumeric(7).toUpperCase();
    }

}
