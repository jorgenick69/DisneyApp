package com.AlkemyChallenge.Disney.mapper;

import com.AlkemyChallenge.Disney.dto.CharacterDTO;
import com.AlkemyChallenge.Disney.dto.CharacterDTOBasic;
import com.AlkemyChallenge.Disney.entity.CharacterEntity;
import com.AlkemyChallenge.Disney.entity.MovieEntity;
import com.AlkemyChallenge.Disney.repository.CharacterRepository;
import com.AlkemyChallenge.Disney.service.CharacterService;
import com.AlkemyChallenge.Disney.service.MovieService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CharacterMapper {

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private MovieService movieService;

    public CharacterEntity FullcharacterDtoToEntity(CharacterDTO characterDTO) {
        CharacterEntity characterEntity = new CharacterEntity();
        if (characterDTO.getId() != null) {
            characterEntity.setId(characterDTO.getId());
        }
        if (characterDTO.getAge() != null) {
            characterEntity.setAge(characterDTO.getAge());
        }
        if (characterDTO.getHistory() != null) {
            characterEntity.setHistory(characterDTO.getHistory());
        }
        if (characterDTO.getImage() != null) {
            characterEntity.setImage(characterDTO.getImage());
        }
        if (characterDTO.getName() != null) {
            characterEntity.setName(characterDTO.getName());
        }
        if (characterDTO.getWeight() != null) {
            characterEntity.setWeight(characterDTO.getWeight());
        }
        if (characterDTO.getMoviesId() != null) {
            characterEntity.setMovies(null);
            characterEntity.setMovies(movieService.getAllEntityById(characterDTO.getMoviesId()));
        }

        return characterEntity;
    }

    public CharacterDTO FullcharacterEntityToDto(CharacterEntity characterEntity) {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setId(characterEntity.getId());
        characterDTO.setAge(characterEntity.getAge());
        characterDTO.setHistory(characterEntity.getHistory());
        characterDTO.setImage(characterEntity.getImage());
        characterDTO.setName(characterEntity.getName());
        characterDTO.setWeight(characterEntity.getWeight());
        
        for (MovieEntity m : characterEntity.getMovies()) {
            m.setCharacters_entity(null);
        }
        
        characterDTO.setMovies(characterEntity.getMovies());

        return characterDTO;
    }

    public CharacterDTOBasic BasicCharacterEntityToDto(CharacterEntity characterEntity) {
        CharacterDTOBasic characterDTOBasic = new CharacterDTOBasic();
        characterDTOBasic.setId(characterEntity.getId());
        characterDTOBasic.setImage(characterEntity.getImage());
        characterDTOBasic.setName(characterEntity.getName());

        return characterDTOBasic;
    }

    public List<CharacterEntity> listFullCharacterEntity(Set<CharacterDTO> listCharacterDTO) {
        List<CharacterEntity> listCharacterEntity = new ArrayList<>();
        for (CharacterDTO c : listCharacterDTO) {
            listCharacterEntity.add(FullcharacterDtoToEntity(c));
        }
        return listCharacterEntity;
    }

    public List<CharacterDTO> listFullCharacterDto(List<CharacterEntity> listCharacterEntity) {
        List<CharacterDTO> listCharacterDTO = new ArrayList<>();
        for (CharacterEntity c : listCharacterEntity) {
            listCharacterDTO.add(FullcharacterEntityToDto(c));
        }
        return listCharacterDTO;
    }

    public List<CharacterDTOBasic> listBasicCharacterDto(List<CharacterEntity> listCharacterEntity) {
        List<CharacterDTOBasic> listCharacterDTObasic = new ArrayList<>();
        for (CharacterEntity c : listCharacterEntity) {
            listCharacterDTObasic.add(BasicCharacterEntityToDto(c));
        }
        return listCharacterDTObasic;
    }
}
