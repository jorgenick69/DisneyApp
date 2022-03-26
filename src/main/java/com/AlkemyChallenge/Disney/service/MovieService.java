package com.AlkemyChallenge.Disney.service;

import com.AlkemyChallenge.Disney.dto.MovieDTO;
import com.AlkemyChallenge.Disney.dto.MovieDTOBasic;
import com.AlkemyChallenge.Disney.entity.MovieEntity;
import java.util.List;
import java.util.Set;

public interface MovieService {

    MovieDTO save(MovieDTO movieDTO);

    List<MovieDTO> getAllMovieDtoFull();

    List<MovieDTOBasic> getAllMovieDtoBasic();

    void delete(Long id);

    MovieEntity getEntityById(Long id);

    List<MovieEntity> getAllEntityById(List<Long> ids);

    List<MovieDTOBasic> getByFilters(String title, Long genderId, String order);
}
