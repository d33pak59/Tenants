package com.tracemeds.ogranization.dto;

import com.tracemeds.ogranization.entity.TenantType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TenantRequestDTO {
//    private String tenantCode;
    private String name;
    private TenantType tenantType;
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
}
