package com.AlkemyChallenge.Disney.dto;


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

    private Set<MovieDTO> movies= new HashSet<>();

    private Set<Long> moviesId= new HashSet<>();

}
