package com.AlkemyChallenge.Disney.mapper;


import com.AlkemyChallenge.Disney.dto.CharacterDTO;
import com.AlkemyChallenge.Disney.dto.CharacterDTOBasic;
import com.AlkemyChallenge.Disney.entity.CharacterEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;


@Component
public class CharacterMapper {
    public CharacterEntity FullcharacterDtoToEntity(CharacterDTO characterDTO){
    CharacterEntity characterEntity= new CharacterEntity();
    characterEntity.setAge(characterDTO.getAge());
    characterEntity.setHistory(characterDTO.getHistory());
    characterEntity.setImage(characterDTO.getImage());
    characterEntity.setName(characterDTO.getName());
    characterEntity.setWeight(characterDTO.getWeight());
    characterEntity.setMovies(characterDTO.getMovies());
    return characterEntity;
    }
   
    public CharacterDTO FullcharacterEntityToDto(CharacterEntity characterEntity){
    CharacterDTO characterDTO= new CharacterDTO();
    characterDTO.setId(characterEntity.getId());
    characterDTO.setAge(characterEntity.getAge());
    characterDTO.setHistory(characterEntity.getHistory());
    characterDTO.setImage(characterEntity.getImage());
    characterDTO.setName(characterEntity.getName());
    characterDTO.setWeight(characterEntity.getWeight());
    characterDTO.setMovies(characterEntity.getMovies());
    return characterDTO;
    }
   
   
    public CharacterDTOBasic BasicCharacterEntityToDto(CharacterEntity characterEntity){
    CharacterDTOBasic characterDTOBasic= new CharacterDTOBasic();
    characterDTOBasic.setId(characterEntity.getId());
    characterDTOBasic.setImage(characterEntity.getImage());
    characterDTOBasic.setName(characterEntity.getName());
   
    return characterDTOBasic;
    }
   
     public List<CharacterDTO> listFullCharacterDto(List<CharacterEntity>listCharacterEntity){
         List<CharacterDTO>listCharacterDTO=new ArrayList<>();
         for (CharacterEntity c : listCharacterEntity) {
             listCharacterDTO.add(FullcharacterEntityToDto(c));
         }
         return listCharacterDTO;
     }
     public List<CharacterDTOBasic> listBasicCharacterDto(List<CharacterEntity>listCharacterEntity){
         List<CharacterDTOBasic>listCharacterDTObasic=new ArrayList<>();
         for (CharacterEntity c : listCharacterEntity) {
             listCharacterDTObasic.add(BasicCharacterEntityToDto(c));
         }
         return listCharacterDTObasic;
     }
}
