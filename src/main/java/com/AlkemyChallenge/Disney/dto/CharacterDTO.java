package com.AlkemyChallenge.Disney.dto;

import com.AlkemyChallenge.Disney.entity.MovieEntity;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;


@Data
public class CharacterDTO {

    private Long id;

    private String image;

    private String name;

    private int age;

    private double weight;

    private String history ;

    private List<MovieEntity> movies = new ArrayList<>();

     private boolean deleted;

   
}
