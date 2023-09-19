package com.backend.hyunfit.domain.trn.controller;

import com.backend.hyunfit.domain.auth.dto.AuthDTO;
import com.backend.hyunfit.domain.mbr.dto.MemberDTO;
import com.backend.hyunfit.domain.pt.dto.PersonalTrainingDTO;
import com.backend.hyunfit.domain.pt.dto.TimeslotDTO;
import com.backend.hyunfit.domain.trn.dto.TrainerDTO;
import com.backend.hyunfit.domain.trn.service.TrainerService;
import com.backend.hyunfit.domain.trnf.dto.TrainerFeedbackDTO;
import com.backend.hyunfit.global.security.provider.JwtProvider;
import com.backend.hyunfit.global.dto.SearchDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/trainers")
public class TrainerControllerImpl implements TrainerController {
    private final TrainerService trainerService;
    private final JwtProvider jwtProvider;
    @GetMapping("/me")
    public TrainerDTO selectOneTrainerByToken(@RequestHeader("authorization") String authorizationHeader){
        AuthDTO authDTO = jwtProvider.getUserInfo(authorizationHeader);
        return trainerService.selectOneTrnByTrnId(authDTO.getUsername());
    }
    @GetMapping("{trnSeq}/personal-training")
    @Override
    public ResponseEntity<List<PersonalTrainingDTO>> findAllPtBytrnSeq(@PathVariable String trnSeq){
        TrainerDTO trainerDTO = new TrainerDTO();
        trainerDTO = trainerService.selectAllPtByTrnSeq(trnSeq);
        List<PersonalTrainingDTO> ptList = trainerDTO.getPtList();
        return ResponseEntity.ok(ptList);
    }

    @GetMapping("{trnSeq}/nofeedback")
    @Override
    public ResponseEntity<List<TrainerFeedbackDTO>> findNoFeedbackBytrnSeq(@PathVariable String trnSeq){
        TrainerDTO trainerDTO = trainerService.selectNoFeedbackBytrnSeq(trnSeq);
        List<TrainerFeedbackDTO> nfbList = trainerDTO.getNoFeedbackList();
        return ResponseEntity.ok(nfbList);
    }

    @Override
    @GetMapping("/{trnId}")
    public ResponseEntity<TrainerDTO> selectOneTrnByTrnId(@PathVariable String trnId) {
        TrainerDTO trainerDTO = trainerService.selectOneTrnByTrnId(trnId);
        return ResponseEntity.ok(trainerDTO);
    }
    @Override
    @GetMapping("/{trnId}/fully-reserved-days")
    public ResponseEntity<TimeslotDTO> selectFullyReservedDaysByMonth(@PathVariable String trnId,
                                                                            @RequestParam Timestamp startDate,
                                                                            @RequestParam Timestamp endDate) {
        var searchDTO = SearchDTO.ofTrainerId(trnId, startDate, endDate);
        return ResponseEntity.ok(trainerService.selectFullyReservedDaysByMonth(searchDTO));
    }
    @Override
    @GetMapping("/{trnId}/all-reserved-timeslots")

    public ResponseEntity<TimeslotDTO> selectAllReservedTimeslotsByDay(@PathVariable String trnId,
                                                                               @RequestParam Timestamp startDate,
                                                                               @RequestParam Timestamp endDate) {
        var searchDTO = SearchDTO.ofTrainerId(trnId, startDate, endDate);
        return ResponseEntity.ok(trainerService.selectAllReservedTimeslotsByDay(searchDTO));
    }
}
