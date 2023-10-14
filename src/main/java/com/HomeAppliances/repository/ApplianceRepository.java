package com.HomeAppliances.repository;

import com.HomeAppliances.entity.Appliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplianceRepository extends JpaRepository<Appliance, Long> {

    Appliance findByApplianceId(String applianceId);

    @Query(value = "Update Appliance SET deleted = true WHERE applianceId IN (:applianceIds)")
    @Modifying
    void deleteByApplianceIds(List<String> applianceIds);

}
