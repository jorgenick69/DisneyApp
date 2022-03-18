package com.AlkemyChallenge.Disney.dto;

import com.AlkemyChallenge.Disney.entity.CharacterEntity;
import com.AlkemyChallenge.Disney.entity.GenderEntity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;


@Data
public class MovieDTO {

    private Long id;

    private String image;

    private String title;

    private LocalDate creationDate;

    private int rankings;

    private GenderEntity gender;

    private Long genderId;

    private List<CharacterEntity> characters = new ArrayList<>();

    private boolean deleted ;
}
