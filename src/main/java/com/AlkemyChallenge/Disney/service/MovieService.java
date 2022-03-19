package com.AlkemyChallenge.Disney.service;

import com.AlkemyChallenge.Disney.dto.MovieDTO;
import com.AlkemyChallenge.Disney.dto.MovieDTOBasic;
import java.util.List;


public interface MovieService {
    
       MovieDTO save(MovieDTO movieDTO);

    List<MovieDTO> getAllMovieFull();
    List<MovieDTOBasic> getAllMovieBasic();

    void delete(Long id);
}
