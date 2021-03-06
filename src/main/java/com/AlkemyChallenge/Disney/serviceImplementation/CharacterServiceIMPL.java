package com.AlkemyChallenge.Disney.serviceImplementation;

import com.AlkemyChallenge.Disney.dto.CharacterDTO;
import com.AlkemyChallenge.Disney.dto.CharacterDTOBasic;
import com.AlkemyChallenge.Disney.dto.CharacterFilterDTO;
import com.AlkemyChallenge.Disney.entity.CharacterEntity;
import com.AlkemyChallenge.Disney.entity.MovieEntity;
import com.AlkemyChallenge.Disney.mapper.CharacterMapper;
import com.AlkemyChallenge.Disney.repository.CharacterRepository;
import com.AlkemyChallenge.Disney.service.CharacterService;
import com.AlkemyChallenge.Disney.service.MovieService;
import com.AlkemyChallenge.Disney.specifications.CharacterSpecification;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceIMPL implements CharacterService {
    @Autowired
    CharacterSpecification characterSpecification;
    @Autowired
    private CharacterMapper characterMapper;
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private MovieService movieService;
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
    public List<CharacterDTO> getAllCharacterDtoFull() {
        List<CharacterEntity> characterEntityList = characterRepository.findAll();
        List<CharacterDTO> characterDtoList = characterMapper.listFullCharacterDto(characterEntityList);
        return characterDtoList;

    }

    @Override
    public List<CharacterDTOBasic> getAllCharacterDtoBasic() {
        List<CharacterEntity> characterEntityList = characterRepository.findAll();
        List<CharacterDTOBasic> characterDtoList = characterMapper.listBasicCharacterDto(characterEntityList);
        return characterDtoList;
    }

    @Override
    public CharacterEntity getEntityById(Long id) {
        CharacterEntity characterEntity= characterRepository.findById(id).orElse(null);
        return characterEntity;
    }
     @Override
    public CharacterDTO getCharacterDTOById(Long id) {
     CharacterEntity characterEntity=getEntityById(id);
     CharacterDTO characterDTO=characterMapper.FullcharacterEntityToDto(characterEntity);
     return characterDTO;
    }


    @Override
    public List<CharacterEntity> getAllEntityById(List<Long> ids) {
        List<CharacterEntity> listCharacterEntity = new ArrayList<>();
        for (Long id : ids) {
            listCharacterEntity.add(getEntityById(id));
        }
        return listCharacterEntity;
    }

    @Override
    public List<CharacterDTOBasic> getByFilters(String name, Integer age, Long idMovie) {
        CharacterFilterDTO characterFilterDTO = new CharacterFilterDTO(name, age, idMovie);
        System.out.println(characterFilterDTO.getName());
        System.out.println(characterFilterDTO.getAge());
        List<CharacterEntity> characterEntityList =  characterRepository.findAll(characterSpecification.getByFilter(characterFilterDTO));
        List<CharacterDTOBasic> characterDTOresult = characterMapper.listBasicCharacterDto(characterEntityList);
        return characterDTOresult;
    }

   
}
