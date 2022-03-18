package com.AlkemyChallenge.Disney.serviceImplementation;

import com.AlkemyChallenge.Disney.dto.CharacterDTO;
import com.AlkemyChallenge.Disney.dto.CharacterDTOBasic;
import com.AlkemyChallenge.Disney.entity.CharacterEntity;
import com.AlkemyChallenge.Disney.mapper.CharacterMapper;
import com.AlkemyChallenge.Disney.repository.CharacterRepository;
import com.AlkemyChallenge.Disney.service.CharacterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceIMPL implements CharacterService {

    @Autowired
    private CharacterMapper characterMapper;
    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public CharacterDTO save(CharacterDTO characterDTO) {
        System.out.println("Save this Character");
        CharacterEntity characterEntity = characterMapper.FullcharacterDtoToEntity(characterDTO);
        CharacterEntity characterEntitySave = characterRepository.save(characterEntity);
        CharacterDTO charcCharacterDTOResult = characterMapper.FullcharacterEntityToDto(characterEntitySave);
        return charcCharacterDTOResult;
    }
   @Override
    public void delete(Long id) {
        characterRepository.deleteById(id);

    } 
    
    @Override
    public List<CharacterDTO> getAllCharacterFull() {
        List<CharacterEntity> characterEntityList = characterRepository.findAll();
        List<CharacterDTO> characterDtoList = characterMapper.listFullCharacterDto(characterEntityList);
        return characterDtoList;

    }

    @Override
    public List<CharacterDTOBasic> getAllCharacterBasic() {
      List<CharacterEntity> characterEntityList = characterRepository.findAll();
        List<CharacterDTOBasic> characterDtoList = characterMapper.listBasicCharacterDto(characterEntityList);
        return characterDtoList;
    }

    

}
