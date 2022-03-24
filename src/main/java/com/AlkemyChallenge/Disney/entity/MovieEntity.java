package com.AlkemyChallenge.Disney.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "movies")
@Data
@SQLDelete(sql = "UPDATE movies SET deleted = true WHERE id =?")
@Where(clause = "deleted = false")

public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    private String title;

    @Column(name = "creationDate")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate creationDate;

    private int rankings;


    @ManyToOne
    @JoinColumn(name = "gender" , insertable = false, updatable = false)
    private GenderEntity gender;

  //@Column(name = "genderId", nullable = false )
 //  private Long genderId;

   @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "charactersMovies",
            joinColumns = @JoinColumn(name = "movieId"),
            inverseJoinColumns = @JoinColumn(name = "characterId")

    )
    private Set<CharacterEntity> characters_entity = new HashSet<>();
  

     private boolean deleted=Boolean.FALSE;

    

   

    
 
}
