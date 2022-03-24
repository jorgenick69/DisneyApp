package com.AlkemyChallenge.Disney.dto;

import com.AlkemyChallenge.Disney.entity.CharacterEntity;
import com.AlkemyChallenge.Disney.entity.GenderEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.constraints.Min;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class MovieDTO {

    private Long id;

    private String image;

    private String title;

    private LocalDate creationDate;

    @Range(min = 1, max = 5, message = "la evaluacion debe ser de 1 a 5")
    private Integer rankings;

    private GenderEntity gender;

    private Long genderId;

    private Set<CharacterEntity> characters = new HashSet<>();

    private Set<Long> charactersId = new HashSet<>();

    private boolean deleted;
}
