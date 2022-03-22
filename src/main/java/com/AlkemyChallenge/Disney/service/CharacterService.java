package com.AlkemyChallenge.Disney.service;

import com.AlkemyChallenge.Disney.dto.CharacterDTO;
import com.AlkemyChallenge.Disney.dto.CharacterDTOBasic;
import com.AlkemyChallenge.Disney.entity.CharacterEntity;
import java.util.List;

public interface CharacterService {
   CharacterDTO save(CharacterDTO characterDTO);
   
    List<CharacterDTO> getAllCharacterDtoFull();
    List<CharacterDTOBasic> getAllCharacterDtoBasic();

    void delete(Long id);
    
    CharacterEntity getEntityById(Long id);
    
    List<CharacterEntity> getAllEntityById(List<Long> ids);

   List<CharacterDTOBasic> getByFilters(String name, Integer age, List<Long> idMovie);
}
