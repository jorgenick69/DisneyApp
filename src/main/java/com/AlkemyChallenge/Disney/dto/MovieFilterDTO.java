
package com.AlkemyChallenge.Disney.dto;

import lombok.Data;

@Data
public class MovieFilterDTO {
    private String title;
    private Long genderId;
    private String order;

    public MovieFilterDTO(String title, Long genderId, String order) {
        this.title = title;
        this.genderId = genderId;
        this.order = order;
    }
    public boolean isASC(){
    return this.order.compareToIgnoreCase("ASC") == 0;
    }
    public boolean isDESC(){
    return this.order.compareToIgnoreCase("DESC") == 0;
    }
}
