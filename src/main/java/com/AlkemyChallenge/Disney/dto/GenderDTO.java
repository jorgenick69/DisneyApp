package com.AlkemyChallenge.Disney.dto;


import com.AlkemyChallenge.Disney.dto.MovieDTO;
import com.AlkemyChallenge.Disney.entity.MovieEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Data;

@Data
public class GenderDTO {

    private Long id;

    private String name;

    private String image;

    private boolean deleted;

    private List<MovieEntity> movies= new ArrayList<>();

    private List<Long> moviesId= new ArrayList<>();

}
