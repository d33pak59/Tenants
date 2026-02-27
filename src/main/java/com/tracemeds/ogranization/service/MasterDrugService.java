package com.tracemeds.ogranization.service;
import com.tracemeds.ogranization.dto.drugDto.MasterDrugRequestDto;
import com.tracemeds.ogranization.dto.drugDto.MasterDrugResponseDto;
import com.tracemeds.ogranization.entity.MasterDrug;
import com.tracemeds.ogranization.repository.MasterDrugRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
@RequiredArgsConstructor
public class MasterDrugService {

    private final MasterDrugRepository masterDrugRepository;

    // Custom drug code logic using count() method of repo;
    public String customDrugCode(){
        long count = masterDrugRepository.count();
        return "DRUG" + (101 + count);
    }

public List<MasterDrugResponseDto> addDrugsFromCsv(MultipartFile file) throws Exception {

        List<MasterDrugResponseDto> addedDrugs = new ArrayList<>();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(file.getInputStream()));

        String line;
        boolean isHeader = true;

        while ((line = reader.readLine()) != null) {

            // Skip header row
            if (isHeader) {
                isHeader = false;
                continue;
            }

            String[] cols = line.split(",");

            if (cols.length < 2) continue;

            String drugName = cols[0].trim();
            Integer price   = Integer.parseInt(cols[1].trim());

            MasterDrug drug = MasterDrug.builder()
                    .drugCode(customDrugCode())
                    .drugName(drugName)
                    .price(price)
                    .build();

            addedDrugs.add(toResponse(masterDrugRepository.save(drug)));
        }

        reader.close();
        return addedDrugs;
    }

    public MasterDrugResponseDto getDrugByCode(String code){
        MasterDrug m1=masterDrugRepository.findByDrugCode(code);
        if(m1==null) throw new RuntimeException("Drug not found");
        return toResponse(m1);
    }

    public MasterDrugResponseDto addDrug(MasterDrugRequestDto request) {

        MasterDrug drug = MasterDrug.builder()
                .drugCode(customDrugCode())
                .drugName(request.getDrugName())
                .price(request.getPrice())
                .build();
        return toResponse(masterDrugRepository.save(drug));
    }

    public List<MasterDrugResponseDto> getAllDrugs() {
        return masterDrugRepository.findAll()
                .stream().map(this::toResponse).toList();
    }

    private MasterDrugResponseDto toResponse(MasterDrug drug) {
        return MasterDrugResponseDto.builder()
                .id(drug.getId())
                .drugCode(drug.getDrugCode())
                .drugName(drug.getDrugName())
                .price(drug.getPrice())
                .build();
    }
}
