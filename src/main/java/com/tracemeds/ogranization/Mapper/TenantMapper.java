package com.tracemeds.ogranization.Mapper;

import com.tracemeds.ogranization.dto.TenantRequestDTO;
import com.tracemeds.ogranization.dto.TenantResponseDTO;
import com.tracemeds.ogranization.entity.Tenant;
import com.tracemeds.ogranization.entity.TenantDetails;
import com.tracemeds.ogranization.repository.TenantRepository;
import com.tracemeds.ogranization.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class TenantMapper {
    public Tenant toEntity(TenantRequestDTO request) {

        Tenant tenant = Tenant.builder()
//                .tenantCode(tenantService.generateTenantCode(request.getTenantType()))
                .name(request.getName())
                .tenantType(request.getTenantType())
                .active(true)
                .build();

        TenantDetails tenantDetails = TenantDetails.builder()
                .email(request.getEmail())
                .contactNumber(request.getContactNumber())
                .registrationNumber(request.getRegistrationNumber())
                .licenseNumber(request.getLicenseNumber())
                .establishedYear(request.getEstablishedYear())
                .founderName(request.getFounderName())
                .gstNumber(request.getGstNumber())
                .panNumber(request.getPanNumber())
                .website(request.getWebsite())
                .country(request.getCountry())
                .state(request.getState())
                .city(request.getCity())
                .tenant(tenant)
                .build();

        tenant.setTenantDetails(tenantDetails);
        return tenant;
    }

    public TenantResponseDTO toResponse(Tenant tenant) {
        return TenantResponseDTO.builder()
                .tenantCode(tenant.getTenantCode())
                .name(tenant.getName())
                .tenantType(tenant.getTenantType())
                .active(tenant.getActive())
                .email(tenant.getTenantDetails().getEmail())
                .contactNumber(tenant.getTenantDetails().getContactNumber())
                .build();
    }
}