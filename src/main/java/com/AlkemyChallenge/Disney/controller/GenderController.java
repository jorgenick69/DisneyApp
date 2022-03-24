package com.AlkemyChallenge.Disney.controller;

import com.AlkemyChallenge.Disney.dto.GenderDTO;
import com.AlkemyChallenge.Disney.service.GenderService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/genders")
public class GenderController {
    @Autowired
    private GenderService genderService;

    @GetMapping
    public ResponseEntity<Set<GenderDTO>> getAll(){
    Set<GenderDTO>genderDtoList=genderService.getAllGenders();
    return ResponseEntity.ok().body(genderDtoList);
    }
    @PostMapping
    public ResponseEntity<GenderDTO>save(@RequestBody GenderDTO gender){
        GenderDTO genderSave=genderService.save(gender);
    return ResponseEntity.status(HttpStatus.CREATED).body(genderSave);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
    genderService.delete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}
