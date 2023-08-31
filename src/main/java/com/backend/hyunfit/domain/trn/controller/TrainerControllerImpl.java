package com.backend.hyunfit.domain.trn.controller;

import com.backend.hyunfit.domain.pt.dto.PtDTO;
import com.backend.hyunfit.domain.trn.dto.TrainerDTO;
import com.backend.hyunfit.domain.trn.service.TrainerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/trainers")
public class TrainerControllerImpl implements TrainerController {
    private final TrainerService trainerService;

    @GetMapping("{trnSeq}/personal-training")
    @Override
    public ResponseEntity<TrainerDTO> findAllPtBytrnSeq(@PathVariable String trnSeq){
        TrainerDTO trainerDTO = new TrainerDTO();
        trainerDTO = trainerService.selectAllPtBytrnSeq(trnSeq);
        return ResponseEntity.ok(trainerDTO);
    }

}