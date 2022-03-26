package com.AlkemyChallenge.Disney.entity;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "characters")
@Data
@SQLDelete(sql = "UPDATE characters SET deleted = true WHERE id =?")
@Where(clause = "deleted = false")

public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    private String name;

    private int age;

    private double weight;

    private String history ;

   @ManyToMany(mappedBy = "characters_entity", cascade = CascadeType.ALL)
    private List<MovieEntity> movies = new ArrayList<>();

    private boolean deleted=Boolean.FALSE;

 
    
    
}
