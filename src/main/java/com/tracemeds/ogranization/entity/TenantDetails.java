package com.tracemeds.ogranization.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tenant_details")
public class TenantDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String email;
    private String contactNumber;
    private String registrationNumber;
    private String licenseNumber;
    private Integer establishedYear;
    private String founderName;
    private String gstNumber;
    private String panNumber;
    private String website;
    private String country;
    private String state;
    private String city;

    // TenantDetails owns the FK — JoinColumn goes HERE only
    @OneToOne
    @JoinColumn(name = "tenant_id", nullable = false, unique = true)
    private Tenant tenant;
}