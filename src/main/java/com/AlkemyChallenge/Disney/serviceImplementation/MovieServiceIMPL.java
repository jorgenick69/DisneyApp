package com.AlkemyChallenge.Disney.serviceImplementation;

import com.AlkemyChallenge.Disney.dto.MovieDTO;
import com.AlkemyChallenge.Disney.dto.MovieDTOBasic;
import com.AlkemyChallenge.Disney.dto.MovieFilterDTO;
import com.AlkemyChallenge.Disney.entity.MovieEntity;
import com.AlkemyChallenge.Disney.mapper.MovieMapper;
import com.AlkemyChallenge.Disney.repository.MovieRepository;
import com.AlkemyChallenge.Disney.service.MovieService;
import com.AlkemyChallenge.Disney.specifications.MovieSpecification;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceIMPL implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private MovieSpecification movieSpecification;

    @Override
    public MovieDTO save(MovieDTO movieDTO) {
        MovieEntity movieEntity = movieMapper.fullDtoToFullEntity(movieDTO);
        MovieEntity movieEntitySave = movieRepository.save(movieEntity);
        MovieDTO movieDtoResult = movieMapper.fullEntityToFullDto(movieEntitySave);

        return movieDtoResult;
    }

    @Override
    public List<MovieDTO> getAllMovieDtoFull() {
        List<MovieDTO> movieDTOlist = new ArrayList<>();
        List<MovieEntity> movieEntityList = (List<MovieEntity>) movieRepository.findAll();
        for (MovieEntity movieEntity : movieEntityList) {
            movieDTOlist.add(movieMapper.fullEntityToFullDto(movieEntity));
        }
        return movieDTOlist;
    }

    @Override
    public List<MovieDTOBasic> getAllMovieDtoBasic() {
        List<MovieEntity> movieEntityList = (List<MovieEntity>) movieRepository.findAll();
        List<MovieDTOBasic> movieDTOBasicList = movieMapper.basicDtoList(movieEntityList);
        return movieDTOBasicList;
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public MovieEntity getEntityById(Long id) {
        MovieEntity movie = movieRepository.findById(id).orElse(null);
        return movie;
    }

    @Override
    public List<MovieEntity> getAllEntityById(List<Long> ids) {
        List<MovieEntity> movieEntityList = new ArrayList<>();
        for (Long id : ids) {

            movieEntityList.add(getEntityById(id));
            System.out.println(movieEntityList.add(getEntityById(id)));
        }
        return movieEntityList;
    }

    @Override
    public List<MovieDTOBasic> getByFilters(String title, Long genderId, String order) {
        MovieFilterDTO movieFilterDTO = new MovieFilterDTO(title, genderId, order);
        System.out.println(movieFilterDTO.getTitle());
        System.out.println(movieFilterDTO.getGenderId());
        List<MovieEntity> movieEntity = movieRepository.findAll(movieSpecification.getByFilters(movieFilterDTO));
        List<MovieDTOBasic> characterDTOresult = movieMapper.basicDtoList(movieEntity);
        return characterDTOresult;

    }

}
