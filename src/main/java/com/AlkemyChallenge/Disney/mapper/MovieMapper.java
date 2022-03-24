package com.AlkemyChallenge.Disney.mapper;

import com.AlkemyChallenge.Disney.dto.MovieDTO;
import com.AlkemyChallenge.Disney.dto.MovieDTOBasic;
import com.AlkemyChallenge.Disney.entity.CharacterEntity;
import com.AlkemyChallenge.Disney.entity.MovieEntity;
import com.AlkemyChallenge.Disney.service.CharacterService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    @Autowired
    private CharacterService characterService;
    @Autowired
    private CharacterMapper characterMapper;

    public MovieEntity fullDtoToFullEntity(MovieDTO movieDTO) {
        MovieEntity movieEntity = new MovieEntity();
        if (movieDTO.getId() != null) {
            movieEntity.setId(movieDTO.getId());
        }
        if (movieDTO.getCreationDate() != null) {
            movieEntity.setCreationDate(movieDTO.getCreationDate());
        }
        if (movieDTO.getGender() != null) {
            movieEntity.setGender(movieDTO.getGender());
        }
        if (movieDTO.getRankings() != null) {
            movieEntity.setRankings(movieDTO.getRankings());
        }
        if (movieDTO.getTitle() != null) {
            movieEntity.setTitle(movieDTO.getTitle());
        }
        if (movieDTO.getImage() != null) {
            movieEntity.setImage(movieDTO.getImage());
        }

        if (movieDTO.getCharactersId() != null) {
            movieEntity.setCharacters_entity(characterService.getAllEntityById(movieDTO.getCharactersId()));
        }

        return movieEntity;
    }

    public MovieDTO fullEntityToFullDto(MovieEntity movieEntity) {

        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movieEntity.getId());
        movieDTO.setCreationDate(movieEntity.getCreationDate());
        movieDTO.setGender(movieEntity.getGender());
        movieDTO.setRankings(movieEntity.getRankings());
        movieDTO.setTitle(movieEntity.getTitle());
        movieDTO.setImage(movieEntity.getImage());
        for (CharacterEntity c : movieEntity.getCharacters_entity()) {
            c.setMovies(null);
        }
        movieDTO.setCharacters(movieEntity.getCharacters_entity());
        
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

    public Set<MovieEntity> fullEntityList(Set<MovieDTO> listMovieDto) {
        Set<MovieEntity> listMovieEntity = new HashSet<>();
        for (MovieDTO m : listMovieDto) {
            listMovieEntity.add(fullDtoToFullEntity(m));
        }
        return listMovieEntity;
    }

    public Set<MovieDTO> fullDtoList(Set<MovieEntity> listMovieEntity) {
        Set<MovieDTO> listMovieDTO = new HashSet<>();
        for (MovieEntity m : listMovieEntity) {
            listMovieDTO.add(fullEntityToFullDto(m));
        }
        return listMovieDTO;
    }

    public Set<MovieDTOBasic> basicDtoList(Set<MovieEntity> listMovieEntity) {
        Set<MovieDTOBasic> listMovieDTOBasicbasic = new HashSet<>();
        for (MovieEntity m : listMovieEntity) {
            listMovieDTOBasicbasic.add(entityToDtoBasic(m));
        }
        return listMovieDTOBasicbasic;
    }
}
