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
public class TenantResponseDTO {
    private String tenantCode;
    private String name;
    private TenantType tenantType;
    private String email;
    private String contactNumber;
    private Boolean active;
}
