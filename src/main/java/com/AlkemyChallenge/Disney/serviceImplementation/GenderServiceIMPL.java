package com.AlkemyChallenge.Disney.serviceImplementation;

import com.AlkemyChallenge.Disney.dto.GenderDTO;
import com.AlkemyChallenge.Disney.entity.GenderEntity;
import com.AlkemyChallenge.Disney.mapper.GenderMapper;
import com.AlkemyChallenge.Disney.repository.GenderRepository;
import org.springframework.stereotype.Service;
import com.AlkemyChallenge.Disney.service.GenderService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class GenderServiceIMPL implements GenderService {

    @Autowired
    private GenderMapper genderMapper;
    @Autowired
    private GenderRepository genderRepository;

    @Override
    public GenderDTO save(GenderDTO genderDTO) {
        // receives a gender of data transfer object type and converts it to an entity, saves this entity and returns a genderDto with the data of the entity
        System.out.println("Save this gender");
        GenderEntity genderEntity = genderMapper.genderDtoToEntity(genderDTO);
        GenderEntity genderEntitySave = genderRepository.save(genderEntity);
        GenderDTO genderDTOresult = genderMapper.genderEntityToDto(genderEntitySave);
        genderDTOresult.setMoviesId(genderDTO.getMoviesId());
        return genderDTOresult;
    }

    @Override
    public Set<GenderDTO> getAllGenders() {
        Set<GenderEntity>genderEntityList=(Set<GenderEntity>) genderRepository.findAll();
        Set<GenderDTO>genderDtoList=genderMapper.listGendersEntityToDto(genderEntityList);
        return genderDtoList;
    }

    @Override
    public void delete(Long id) {
     genderRepository.deleteById(id);
    }

    @Override
    public GenderEntity getGenderEntityById(Long id) {
      return genderRepository.findById(id).orElse(null);
    }
}
