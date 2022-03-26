
package com.AlkemyChallenge.Disney.dto;


import lombok.Data;


@Data
public class CharacterFilterDTO {
 private  String name;
 private  Integer age;
 private Long idMovie;

    public CharacterFilterDTO(String name, Integer age, Long idMovie) {
        this.name = name;
        this.age = age;
        this.idMovie = idMovie;
    }
 
   
}
