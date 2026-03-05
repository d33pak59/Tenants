package com.tracemeds.ogranization.controller;

import com.tracemeds.ogranization.dto.TenantRequestDTO;
import com.tracemeds.ogranization.dto.TenantResponseDTO;
import com.tracemeds.ogranization.entity.Tenant;
import com.tracemeds.ogranization.entity.TenantType;
import com.tracemeds.ogranization.repository.TenantRepository;
import com.tracemeds.ogranization.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/tenant")
@RequiredArgsConstructor
public class TenantController {
    private final TenantService tenantservice;
    private final TenantRepository tenantrepository;
    @PostMapping("/register")
    public ResponseEntity<TenantResponseDTO> registerTenant(@RequestBody TenantRequestDTO request) {
        return ResponseEntity.ok(tenantservice.registerTenant(request));
    }

    @GetMapping("/{tenantCode}")
    public ResponseEntity<TenantResponseDTO> getTenantByCode(@PathVariable String tenantCode) {
        return ResponseEntity.ok(tenantservice.getTenantByCode(tenantCode));
    }

    @GetMapping("/type")
    public ResponseEntity<List<TenantResponseDTO>> getAllTenantsOfType(@RequestParam TenantType tenantType) {
        return ResponseEntity.ok(tenantservice.getTenantByTenantType(tenantType));
    }

    @GetMapping("/isRegistered")
    public Boolean checkTenant(@RequestParam String tenantCode) {
        Tenant tenant=tenantrepository.findByTenantCode(tenantCode).orElse(null);
        return tenant != null && Objects.equals(tenant.getTenantType().toString(), "HOSPITAL");
    }

    @GetMapping("/isAdmin")
    public Boolean checkTenantAdmin(@RequestParam String tenantCode) {
        Tenant tenant=tenantrepository.findByTenantCode(tenantCode).orElse(null);
        return tenant != null && Objects.equals(tenant.getTenantType().toString(), "PLATFORM_ADMIN");
    }
}