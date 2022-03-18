package com.AlkemyChallenge.Disney.dto;

import java.time.LocalDate;
import lombok.Data;


@Data
public class MovieDTOBasic {
    
    private Long id;

    private String image;

    private String title;

    private LocalDate creationDate;

   
   
}
