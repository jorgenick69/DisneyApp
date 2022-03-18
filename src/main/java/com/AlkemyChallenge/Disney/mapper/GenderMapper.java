package com.AlkemyChallenge.Disney.mapper;

import com.AlkemyChallenge.Disney.dto.GenderDTO;
import com.AlkemyChallenge.Disney.entity.GenderEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;


@Component
public class GenderMapper {
    public GenderEntity genderDtoToEntity(GenderDTO genderDto){
    GenderEntity genderEntity= new GenderEntity();
    genderEntity.setImage(genderDto.getImage());
    genderEntity.setName(genderDto.getName());
    genderEntity.setDeleted(genderDto.isDeleted());
    return genderEntity;
    }
    public GenderDTO genderEntityToDto(GenderEntity genderEntity){
    GenderDTO genderDto= new GenderDTO();
    genderDto.setId(genderEntity.getId());
    genderDto.setImage(genderEntity.getImage());
    genderDto.setName(genderEntity.getName());
    genderDto.setDeleted(genderEntity.isDeleted());
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
