package com.AlkemyChallenge.Disney.mapper;

import com.AlkemyChallenge.Disney.dto.MovieDTO;
import com.AlkemyChallenge.Disney.dto.MovieDTOBasic;
import com.AlkemyChallenge.Disney.entity.MovieEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieEntity FullMovieDtoToEntity(MovieDTO movieDTO) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setCharacters(movieDTO.getCharacters());
        movieEntity.setCreationDate(movieDTO.getCreationDate());
        movieEntity.setGender(movieDTO.getGender());
        movieEntity.setId(movieDTO.getId());
        movieEntity.setRankings(movieDTO.getRankings());
        movieEntity.setTitle(movieDTO.getTitle());
        movieEntity.setImage(movieDTO.getImage());
        return movieEntity;
    }

    public MovieDTO FullMovieEntityToDto(MovieEntity movieEntity) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movieEntity.getId());
        movieDTO.setCharacters(movieEntity.getCharacters());
        movieDTO.setCreationDate(movieEntity.getCreationDate());
        movieDTO.setGender(movieEntity.getGender());
        movieDTO.setRankings(movieEntity.getRankings());
        movieDTO.setTitle(movieEntity.getTitle());
        movieDTO.setImage(movieEntity.getImage());
        return movieDTO;
    }

    public MovieDTOBasic BasicMovieEntityToDto(MovieEntity movieEntity) {
        MovieDTOBasic movieDTOBasic = new MovieDTOBasic();
        movieDTOBasic.setId(movieEntity.getId());
        movieDTOBasic.setTitle(movieEntity.getTitle());
        movieDTOBasic.setImage(movieEntity.getImage());
        movieDTOBasic.setCreationDate(movieEntity.getCreationDate());
        return movieDTOBasic;
    }

    public List<MovieDTO> listFullMovieDto(List<MovieEntity> listMovieEntity) {
        List<MovieDTO> listMovieDTO = new ArrayList<>();
        for (MovieEntity m : listMovieEntity) {
            listMovieDTO.add(FullMovieEntityToDto(m));
        }
        return listMovieDTO;
    }

    public List<MovieDTOBasic> listBasicMovieEntity(List<MovieEntity> listMovieEntity) {
        List<MovieDTOBasic> listMovieDTOBasicbasic = new ArrayList<>();
        for (MovieEntity m : listMovieEntity) {
            listMovieDTOBasicbasic.add(BasicMovieEntityToDto(m));
        }
        return listMovieDTOBasicbasic;
    }
}
