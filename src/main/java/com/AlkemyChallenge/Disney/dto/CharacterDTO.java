package com.AlkemyChallenge.Disney.dto;


import com.AlkemyChallenge.Disney.entity.MovieEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Data;

@Data
public class CharacterDTO {

    private Long id;

    private String image;

    private String name;

    private Integer age;

    private Double weight;

    private String history;

    private Set<MovieEntity> movies = new HashSet<>();
    
    private Set<Long> moviesId = new HashSet<>();

    private boolean deleted;

}
