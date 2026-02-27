package com.tracemeds.ogranization.dto.drugDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MasterDrugRequestDto {
    private String drugName;
    private Integer price;
}
