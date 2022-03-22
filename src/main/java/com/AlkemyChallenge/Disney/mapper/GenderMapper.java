package com.AlkemyChallenge.Disney.mapper;

import com.AlkemyChallenge.Disney.dto.GenderDTO;
import com.AlkemyChallenge.Disney.entity.GenderEntity;
import com.AlkemyChallenge.Disney.service.MovieService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class GenderMapper {

  
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private MovieService movieService;
    
    public GenderEntity genderDtoToEntity(GenderDTO genderDto){
    GenderEntity genderEntity= new GenderEntity();
    genderEntity.setImage(genderDto.getImage());
    genderEntity.setName(genderDto.getName());
    genderEntity.setDeleted(genderDto.isDeleted());
    genderEntity.setMovies(movieService.getAllEntityById(genderDto.getMoviesId()));
    return genderEntity;
    }
    
    public GenderDTO genderEntityToDto(GenderEntity genderEntity){
    GenderDTO genderDto= new GenderDTO();
    genderDto.setId(genderEntity.getId());
    genderDto.setImage(genderEntity.getImage());
    genderDto.setName(genderEntity.getName());
    genderDto.setDeleted(genderEntity.isDeleted());
    genderDto.setMovies(movieMapper.fullDtoList(genderEntity.getMovies(), true));
    return genderDto;
    }
     public List<GenderDTO> listGendersEntityToDto(List<GenderEntity>listGendersEntity){
         List<GenderDTO>listGenderDto=new ArrayList<>();
         for (GenderEntity g : listGendersEntity) {
             listGenderDto.add(genderEntityToDto(g));
         }
         return listGenderDto;
     }
}
