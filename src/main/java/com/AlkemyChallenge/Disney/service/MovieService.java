package com.AlkemyChallenge.Disney.service;

import com.AlkemyChallenge.Disney.dto.MovieDTO;
import com.AlkemyChallenge.Disney.dto.MovieDTOBasic;
import com.AlkemyChallenge.Disney.entity.MovieEntity;
import java.util.List;

public interface MovieService {

    MovieDTO save(MovieDTO movieDTO);

    List<MovieDTO> getAllMovieDtoFull();

    List<MovieDTOBasic> getAllMovieDtoBasic();

    void delete(Long id);

    MovieEntity getEntityById(Long id);

    List<MovieEntity> getAllEntityById(List<Long> ids);
}
