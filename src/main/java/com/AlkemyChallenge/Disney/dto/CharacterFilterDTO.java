/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.AlkemyChallenge.Disney.dto;

import java.util.List;
import lombok.Data;

/**
 *
 * @author Jorge Dominguez
 */
@Data
public class CharacterFilterDTO {
 private  String name;
 private  Integer age;
 private List<Long>idMovie;

    public CharacterFilterDTO(String name, Integer age, List<Long> idMovie) {
        this.name = name;
        this.age = age;
        this.idMovie = idMovie;
    }
 
   
}
