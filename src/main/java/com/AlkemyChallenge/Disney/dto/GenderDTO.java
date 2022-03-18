package com.AlkemyChallenge.Disney.dto;

import com.AlkemyChallenge.Disney.entity.MovieEntity;
import java.util.List;
import lombok.Data;


@Data
public class GenderDTO {
 
    private Long id;

    private String name;

    private String image;

    private boolean deleted;

   private List<MovieEntity>movies;
   
}
