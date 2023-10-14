package com.HomeAppliances.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@Where(clause = "deleted = 0")
@Table(name = "appliance")
public class Appliance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "appliance_id", length = 30)
    private String applianceId;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "created_on")
    @CreationTimestamp()
    private Timestamp createdOn;

    @Column(name = "modified_on")
    @UpdateTimestamp()
    private Timestamp modifiedOn;

    @Column(name = "deleted")
    private boolean deleted;

}