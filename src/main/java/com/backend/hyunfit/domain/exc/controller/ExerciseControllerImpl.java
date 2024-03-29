package com.backend.hyunfit.domain.exc.controller;

import com.backend.hyunfit.domain.exc.dto.ExerciseDTO;
import com.backend.hyunfit.domain.exc.service.ExerciseService;
import com.backend.hyunfit.domain.exc.service.ExerciseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "${vue.url}")
@RequestMapping(value = "/exercises")
@RestController
@RequiredArgsConstructor
public class ExerciseControllerImpl implements ExerciseController {

    private final ExerciseService exerciseService;

    @Override
    @PostMapping
    public ResponseEntity<?> insertExercise(@RequestBody ExerciseDTO exerciseDTO) {
        ExerciseDTO excSeqInserted = exerciseService.insertExerciseAndTarget(exerciseDTO);
        return new ResponseEntity<>(excSeqInserted, HttpStatus.CREATED);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ExerciseDTO>> getAllExercises() {
        List<ExerciseDTO> exercises = exerciseService.getAllExercises();
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{excSeq}")
    public ResponseEntity<ExerciseDTO> getOneExercises(@PathVariable Long excSeq) {
        ExerciseDTO exerciseDTO = exerciseService.selectOneExercise(excSeq);
        return ResponseEntity.ok(exerciseDTO);
    }


    @Override
    @DeleteMapping("/{excSeq}")
    public ResponseEntity<Void> removeExercise(@PathVariable Long excSeq) {
        exerciseService.removeExercise(excSeq);
        return ResponseEntity.noContent().build();
    }

}
