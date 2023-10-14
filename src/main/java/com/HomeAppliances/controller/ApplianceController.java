package com.HomeAppliances.controller;

import com.HomeAppliances.Request.ApplianceRequest;
import com.HomeAppliances.Response.ApplianceResponse;
import com.HomeAppliances.service.ApplianceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "/api/v0/appliance")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ApplianceController {

    private final ApplianceService applianceService;

    @PostMapping()
    public ApplianceResponse createAppliance(@RequestBody ApplianceRequest applianceRequest) {
        log.info("Received request to create Appliance: {}", applianceRequest);
        return applianceService.createAppliance(applianceRequest);
    }

    @GetMapping("/{applianceId}")
    public ApplianceResponse getApplianceById(@PathVariable(value = "applianceId") String applianceId) {
        log.info("Received request to get Appliance by Id: {}", applianceId);
        return applianceService.getApplianceById(applianceId);
    }

    @GetMapping(value = "/all")
    public List<ApplianceResponse> getAll() {
        log.info("Received request to get all appliances");
        return applianceService.getAll();
    }

    @PutMapping("/{applianceId}")
    public ApplianceResponse updateAppliance(@RequestBody ApplianceRequest applianceRequest, @PathVariable(value = "applianceId") String applianceId) {
        log.info("Received request to update Appliance: {} by ApplianceId: {}", applianceRequest, applianceId);
        return applianceService.updateAppliance(applianceRequest, applianceId);
    }

    @DeleteMapping()
    public void deleteAppliances(@RequestBody List<String> applianceIds) {
        log.info("Received request to delete Appliances by Ids: {}", applianceIds);
        applianceService.deleteAppliances(applianceIds);
    }

    @DeleteMapping(value = "/{applianceId}")
    public void deleteAppliances(@PathVariable(value = "applianceId") String applianceId) {
        log.info("Received request to delete Appliance by Id: {}", applianceId);
        applianceService.deleteAppliance(applianceId);
    }

}
