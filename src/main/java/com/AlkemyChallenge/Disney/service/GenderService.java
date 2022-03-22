package com.AlkemyChallenge.Disney.service;

import com.AlkemyChallenge.Disney.dto.GenderDTO;
import com.AlkemyChallenge.Disney.entity.GenderEntity;
import java.util.List;


public interface GenderService {

    GenderDTO save(GenderDTO genderDTO);

    List<GenderDTO> getAllGenders();

    void delete(Long id);
    
    GenderEntity getGenderEntityById(Long id);
}
