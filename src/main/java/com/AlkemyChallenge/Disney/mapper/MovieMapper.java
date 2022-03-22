package com.AlkemyChallenge.Disney.mapper;

import com.AlkemyChallenge.Disney.dto.MovieDTO;
import com.AlkemyChallenge.Disney.dto.MovieDTOBasic;
import com.AlkemyChallenge.Disney.entity.MovieEntity;
import com.AlkemyChallenge.Disney.service.CharacterService;
import com.AlkemyChallenge.Disney.service.MovieService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public  class MovieMapper {
  
    @Autowired
    private CharacterService characterService;
   

    public MovieEntity fullDtoToFullEntity(MovieDTO movieDTO) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setCreationDate(movieDTO.getCreationDate());
        movieEntity.setGender(movieDTO.getGender());
        movieEntity.setId(movieDTO.getId());
        movieEntity.setRankings(movieDTO.getRankings());
        movieEntity.setTitle(movieDTO.getTitle());
        movieEntity.setImage(movieDTO.getImage());
        movieEntity.setCharacters_entity(characterService.getAllEntityById(movieDTO.getCharactersId()));
        return movieEntity;
    }

    public MovieDTO fullEntityToFullDto(MovieEntity movieEntity, boolean load) {
        CharacterMapper characterMapper=new CharacterMapper();
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movieEntity.getId());
        //movieDTO.setCreationDate(movieEntity.getCreationDate());
        movieDTO.setGender(movieEntity.getGender());
        movieDTO.setRankings(movieEntity.getRankings());
        movieDTO.setTitle(movieEntity.getTitle());
        movieDTO.setImage(movieEntity.getImage());
        if (load) {
           movieDTO.setCharacters(movieEntity.getCharacters_entity());
        }
        return movieDTO;
    }

    public MovieDTOBasic entityToDtoBasic(MovieEntity movieEntity) {
        MovieDTOBasic movieDTOBasic = new MovieDTOBasic();
        movieDTOBasic.setId(movieEntity.getId());
        movieDTOBasic.setTitle(movieEntity.getTitle());
        movieDTOBasic.setImage(movieEntity.getImage());
       // movieDTOBasic.setCreationDate(movieEntity.getCreationDate());
        return movieDTOBasic;
    }

    public List<MovieEntity> fullEntityList(List<MovieDTO> listMovieDto) {
        List<MovieEntity> listMovieEntity = new ArrayList<>();
        for (MovieDTO m : listMovieDto) {
            listMovieEntity.add(fullDtoToFullEntity(m));
        }
        return listMovieEntity;
    }

    public List<MovieDTO> fullDtoList(List<MovieEntity> listMovieEntity, boolean load) {
        List<MovieDTO> listMovieDTO = new ArrayList<>();
        for (MovieEntity m : listMovieEntity) {
            listMovieDTO.add(fullEntityToFullDto(m, load));
        }
        return listMovieDTO;
    }

    public List<MovieDTOBasic> basicDtoList(List<MovieEntity> listMovieEntity) {
        List<MovieDTOBasic> listMovieDTOBasicbasic = new ArrayList<>();
        for (MovieEntity m : listMovieEntity) {
            listMovieDTOBasicbasic.add(entityToDtoBasic(m));
        }
        return listMovieDTOBasicbasic;
    }
}
