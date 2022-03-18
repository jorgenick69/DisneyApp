package com.AlkemyChallenge.Disney.service;

import com.AlkemyChallenge.Disney.dto.CharacterDTO;
import com.AlkemyChallenge.Disney.dto.CharacterDTOBasic;
import java.util.List;

public interface CharacterService {
   CharacterDTO save(CharacterDTO characterDTO);
   
    List<CharacterDTO> getAllCharacterFull();
    List<CharacterDTOBasic> getAllCharacterBasic();

    void delete(Long id);
}
