package com.tracemeds.ogranization.controller;

import com.tracemeds.ogranization.dto.drugDto.MasterDrugRequestDto;
import com.tracemeds.ogranization.dto.drugDto.MasterDrugResponseDto;
import com.tracemeds.ogranization.service.MasterDrugService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/drugs")
@RequiredArgsConstructor
public class MasterDrugController {

    private final MasterDrugService masterDrugService;

    @PostMapping
    public ResponseEntity<MasterDrugResponseDto> addDrug(
            @RequestBody MasterDrugRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(masterDrugService.addDrug(request));
    }


    @GetMapping("/{code}")
    public ResponseEntity<MasterDrugResponseDto>getDrugByCode(@PathVariable String code){
        return ResponseEntity.ok(masterDrugService.getDrugByCode(code));
    }

    @GetMapping
    public ResponseEntity<List<MasterDrugResponseDto>> getAllDrugs() {
        return ResponseEntity.ok(masterDrugService.getAllDrugs());
    }


    @PostMapping("/upload-csv")
    public ResponseEntity<List<MasterDrugResponseDto>> addDrugsFromCsv(
            @RequestParam("file") MultipartFile file) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(masterDrugService.addDrugsFromCsv(file));
    }
}
