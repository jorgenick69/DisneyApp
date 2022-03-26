
package com.AlkemyChallenge.Disney.controller;

import com.AlkemyChallenge.Disney.dto.CharacterDTO;
import com.AlkemyChallenge.Disney.dto.CharacterDTOBasic;
import com.AlkemyChallenge.Disney.service.CharacterService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    @Autowired
    private CharacterService characterService;
   

    @GetMapping("/{id}")
    public CharacterDTO getById(@PathVariable Long id){
    
    CharacterDTO characterDTO=characterService.getCharacterDTOById(id);
    return characterDTO;
    }
    
    @GetMapping
    public ResponseEntity<List<CharacterDTOBasic>> getAllbyFilter(
    @RequestParam(required = false)String name,
    @RequestParam(required = false)Integer age,
    @RequestParam(required = false)Long idMovie
    ){
    List<CharacterDTOBasic>CharacterDtoBasicList=characterService.getByFilters(name,age,idMovie);
    return ResponseEntity.ok(CharacterDtoBasicList);
    }
    
    @PostMapping
    public ResponseEntity<CharacterDTO>save(@RequestBody CharacterDTO character){
    CharacterDTO characterSave=characterService.save(character);
    return ResponseEntity.status(HttpStatus.CREATED).body(characterSave);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
    characterService.delete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
