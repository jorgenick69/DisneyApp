package com.AlkemyChallenge.Disney.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Entity
@Table(name = "genders")
@Data
@SQLDelete(sql = "UPDATE genders SET deleted = true WHERE id =?")
@Where(clause = "deleted = false")
public class GenderEntity {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String image;

    private boolean deleted=Boolean.FALSE;
 
   @OneToMany(mappedBy = "gender")
   private List<MovieEntity>movies= new ArrayList<>();
    
}
