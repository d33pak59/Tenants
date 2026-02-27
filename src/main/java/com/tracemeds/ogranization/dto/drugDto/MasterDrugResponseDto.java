package com.tracemeds.ogranization.dto.drugDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MasterDrugResponseDto {
    private UUID id;
    private String drugCode;
    private String drugName;
    private Integer price;
}
