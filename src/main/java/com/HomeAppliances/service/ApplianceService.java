package com.HomeAppliances.service;

import com.HomeAppliances.CommonUtils;
import com.HomeAppliances.Request.ApplianceRequest;
import com.HomeAppliances.Response.ApplianceResponse;
import com.HomeAppliances.entity.Appliance;
import com.HomeAppliances.exception.NotFoundException;
import com.HomeAppliances.repository.ApplianceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplianceService {

    private final ApplianceRepository applianceRepository;

    private final ModelMapper modelMapper;

    public ApplianceResponse createAppliance(ApplianceRequest applianceRequest) {

        Appliance appliance = modelMapper.map(applianceRequest, Appliance.class);
        log.info("Successfully converted applianceRequest, appliance:{}", appliance);
        appliance.setApplianceId(CommonUtils.generateApplianceId());
        applianceRepository.save(appliance);
        return modelMapper.map(appliance, ApplianceResponse.class);
    }

    public ApplianceResponse getApplianceById(String applianceId) {
        Appliance appliance = applianceRepository.findByApplianceId(applianceId);
        if (Objects.isNull(appliance)) {
            log.error("Appliance doesn't exist with id:{}", applianceId);
            throw new NotFoundException(String.format("Appliance doesn't exist with id: %s", applianceId));
        }
        return modelMapper.map(appliance, ApplianceResponse.class);
    }

    public List<ApplianceResponse> getAll() {
        List<Appliance> appliances = applianceRepository.findAll();
        return appliances.stream().map(appliance -> modelMapper.map(appliance, ApplianceResponse.class)).collect(Collectors.toList());
    }

    public ApplianceResponse updateAppliance(ApplianceRequest applianceRequest, String applianceId) {
        Appliance appliance = applianceRepository.findByApplianceId(applianceId);
        log.info("appliance before update :{}", appliance);
        if (Objects.isNull(appliance)) {
            log.error("Appliance doesn't exist with id:{}", applianceId);
            throw new NotFoundException(String.format("Appliance doesn't exist with id: %s", applianceId));
        }
        if (Objects.nonNull(applianceRequest.getName()))
            appliance.setName(applianceRequest.getName());
        if (Objects.nonNull(applianceRequest.getDescription()))
            appliance.setDescription(applianceRequest.getDescription());

        applianceRepository.save(appliance);
        return modelMapper.map(appliance, ApplianceResponse.class);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteAppliances(List<String> applianceIds) {
        log.info("deleting appliances for ids: {}", applianceIds);
        applianceRepository.deleteByApplianceIds(applianceIds);

    }

    @Transactional
    public void deleteAppliance(String applianceId) {
        log.info(applianceId);
        applianceRepository.deleteByApplianceIds(Collections.singletonList(applianceId));
    }
}
