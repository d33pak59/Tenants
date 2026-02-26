package com.tracemeds.ogranization.service;

import com.tracemeds.ogranization.Mapper.TenantMapper;
import com.tracemeds.ogranization.dto.TenantRequestDTO;
import com.tracemeds.ogranization.dto.TenantResponseDTO;
import com.tracemeds.ogranization.entity.Tenant;
import com.tracemeds.ogranization.entity.TenantType;
import com.tracemeds.ogranization.repository.TenantRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TenantService {

    private final TenantRepository tenantRepository;
    private final TenantMapper tenantMapper;

    public String generateTenantCode(TenantType type) {

        String prefix = switch (type) {
            case HOSPITAL -> "HOSP";
            case WAREHOUSE -> "WH";
            case SUPPLIER -> "SUP";
            case QC_COMPANY -> "QC";
            case PLATFORM_ADMIN -> "ADMIN";
            case THIRD_PARTY_LOGISTICS -> "3PL";
        };

        Long count = tenantRepository.countByTenantType(type);

        long nextNumber = count + 1;

        return prefix + "-" + String.format("%03d", nextNumber);
    }

    @Transactional
    public TenantResponseDTO registerTenant(TenantRequestDTO request) {

//        Tenant  tenant = new Tenant();
//        tenant.setTenantCode(generateTenantCode(request.getTenantType()));
//         tenant = tenantMapper.toEntity(request);

        Tenant tenant=tenantMapper.toEntity(request);
        tenant.setTenantCode(generateTenantCode(tenant.getTenantType()));
        return tenantMapper.toResponse(tenantRepository.save(tenant));
    }

    public TenantResponseDTO getTenantByCode(String tenantCode) {
        Tenant tenant = tenantRepository.findByTenantCode(tenantCode).orElseThrow(() -> new RuntimeException("Tenant not found with code: " + tenantCode));
        return tenantMapper.toResponse(tenant);
    }


    public List<TenantResponseDTO> getTenantByTenantType(TenantType tenantType) {
        return tenantRepository.findAllByTenantType(tenantType)
                .stream()
                .map(tenantMapper::toResponse)
                .toList();
    }
}