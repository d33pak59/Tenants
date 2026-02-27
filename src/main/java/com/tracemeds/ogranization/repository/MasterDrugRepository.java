package com.tracemeds.ogranization.repository;
import com.tracemeds.ogranization.entity.MasterDrug;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface MasterDrugRepository extends JpaRepository<MasterDrug, UUID> {
}
