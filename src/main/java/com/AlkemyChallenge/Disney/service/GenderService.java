package com.AlkemyChallenge.Disney.service;

import com.AlkemyChallenge.Disney.dto.GenderDTO;
import java.util.List;


public interface GenderService {

    GenderDTO save(GenderDTO genderDTO);

    List<GenderDTO> getAllGenders();

    void delete(Long id);
}
