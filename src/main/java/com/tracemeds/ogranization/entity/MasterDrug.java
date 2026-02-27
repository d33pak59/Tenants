package com.tracemeds.ogranization.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "master_drug_list")
public class MasterDrug {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String drugCode;

    @Column(nullable = false)
    private String drugName;

    private Integer price;
}