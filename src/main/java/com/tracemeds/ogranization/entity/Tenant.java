package com.tracemeds.ogranization.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tenants")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String tenantCode;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TenantType tenantType;

    private Boolean active;

    @CreationTimestamp
    private LocalDateTime createdAt;

    // Tenant OWNS the relationship — FK is in tenant_details table
    // mappedBy means "the other side owns the FK column"
    @OneToOne(mappedBy = "tenant", cascade = CascadeType.ALL)
    private TenantDetails tenantDetails;
}