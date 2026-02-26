package com.tracemeds.ogranization.repository;
import com.tracemeds.ogranization.entity.Tenant;
import com.tracemeds.ogranization.entity.TenantType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TenantRepository extends JpaRepository<Tenant, UUID> {

    Optional<Tenant> findByTenantCode(String tenantCode);

    List<Tenant> findAllByTenantType(TenantType tenantType);

    long countByTenantType(TenantType type);
}
