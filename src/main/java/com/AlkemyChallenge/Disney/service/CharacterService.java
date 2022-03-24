package com.AlkemyChallenge.Disney.service;

import com.AlkemyChallenge.Disney.dto.CharacterDTO;
import com.AlkemyChallenge.Disney.dto.CharacterDTOBasic;
import com.AlkemyChallenge.Disney.entity.CharacterEntity;
import java.util.List;
import java.util.Set;

public interface CharacterService {
   CharacterDTO save(CharacterDTO characterDTO);
   
    Set<CharacterDTO> getAllCharacterDtoFull();
    List<CharacterDTOBasic> getAllCharacterDtoBasic();

    void delete(Long id);
    
    CharacterEntity getEntityById(Long id);
    
    Set<CharacterEntity> getAllEntityById(Set<Long> ids);

   List<CharacterDTOBasic> getByFilters(String name, Integer age, Long idMovie);
}
