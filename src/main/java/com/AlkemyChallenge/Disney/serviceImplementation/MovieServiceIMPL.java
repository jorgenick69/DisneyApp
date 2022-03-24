package com.AlkemyChallenge.Disney.serviceImplementation;

import com.AlkemyChallenge.Disney.dto.MovieDTO;
import com.AlkemyChallenge.Disney.dto.MovieDTOBasic;
import com.AlkemyChallenge.Disney.entity.MovieEntity;
import com.AlkemyChallenge.Disney.mapper.MovieMapper;
import com.AlkemyChallenge.Disney.repository.MovieRepository;
import com.AlkemyChallenge.Disney.service.MovieService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceIMPL implements MovieService{
    @Autowired
   private MovieRepository movieRepository;
   @Autowired
   private MovieMapper movieMapper;
    
    
    
    @Override
    public MovieDTO save(MovieDTO movieDTO) {
       MovieEntity movieEntity=movieMapper.fullDtoToFullEntity(movieDTO);
       MovieEntity movieEntitySave=movieRepository.save(movieEntity);
       MovieDTO movieDtoResult=movieMapper.fullEntityToFullDto(movieEntitySave);
       
       return movieDtoResult;
    }

    @Override
    public Set<MovieDTO> getAllMovieDtoFull() {
       Set<MovieDTO> movieDTOlist=new HashSet<>();
       Set<MovieEntity> movieEntityList = (Set<MovieEntity>) movieRepository.findAll();
        for (MovieEntity movieEntity : movieEntityList) {
            movieDTOlist.add(movieMapper.fullEntityToFullDto(movieEntity));
        }
        return movieDTOlist;
    }

    @Override
    public Set<MovieDTOBasic> getAllMovieDtoBasic() {
       Set<MovieEntity> movieEntityList = (Set<MovieEntity>) movieRepository.findAll();
        Set<MovieDTOBasic> movieDTOBasicList = movieMapper.basicDtoList(movieEntityList);
        return movieDTOBasicList;
    }

    @Override
    public void delete(Long id) {
    movieRepository.deleteById(id);
    }

    @Override
    public MovieEntity getEntityById(Long id) {
     MovieEntity movie=movieRepository.findById(id).orElse(null);
     return movie;
    }

    @Override
    public Set<MovieEntity> getAllEntityById(Set<Long> ids) {
        Set<MovieEntity> movieEntityList=new HashSet<>();
        for (Long id : ids) {
            
            movieEntityList.add(getEntityById(id));
            System.out.println(movieEntityList.add(getEntityById(id)));
        }
        return movieEntityList;
    }
    
}
