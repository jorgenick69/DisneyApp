package com.AlkemyChallenge.Disney.service;

import com.AlkemyChallenge.Disney.dto.MovieDTO;
import com.AlkemyChallenge.Disney.dto.MovieDTOBasic;
import com.AlkemyChallenge.Disney.entity.MovieEntity;
import java.util.List;
import java.util.Set;

public interface MovieService {

    MovieDTO save(MovieDTO movieDTO);

    Set<MovieDTO> getAllMovieDtoFull();

    Set<MovieDTOBasic> getAllMovieDtoBasic();

    void delete(Long id);

    MovieEntity getEntityById(Long id);

    Set<MovieEntity> getAllEntityById(Set<Long> ids);
}
