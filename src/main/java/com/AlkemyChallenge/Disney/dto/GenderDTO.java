package com.AlkemyChallenge.Disney.dto;


import java.util.List;
import lombok.Data;

@Data
public class GenderDTO {

    private Long id;

    private String name;

    private String image;

    private boolean deleted;

    private List<MovieDTO> movies;

    private List<Long> moviesId;

}
