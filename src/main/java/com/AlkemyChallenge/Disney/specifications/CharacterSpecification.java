/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.AlkemyChallenge.Disney.specifications;


import com.AlkemyChallenge.Disney.dto.CharacterFilterDTO;
import com.AlkemyChallenge.Disney.entity.CharacterEntity;
import com.AlkemyChallenge.Disney.entity.MovieEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 *
 * @author Jorge Dominguez
 */
@Component
public class CharacterSpecification {
    public Specification<CharacterEntity>getByFilter(CharacterFilterDTO filterDto){
    return(root,query,criteriaBuilder)->{
        List<Predicate>predicates=new ArrayList<>();
        if (StringUtils.hasLength(filterDto.getName())) {
            predicates.add(
            criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("name")), "%"+filterDto.getName().toLowerCase()+"%")
            );            
        }
        if (filterDto.getAge()!=null) {
            predicates.add(
            criteriaBuilder.equal(root.<Integer>get("age"),filterDto.getAge())
            );            
        }
         if (filterDto.getIdMovie() != null){
                Join<MovieEntity, CharacterEntity> join = root.join("movies" , JoinType.INNER);
                Expression<String> idMovie = join.get("id");
                predicates.add(idMovie.in(filterDto.getIdMovie()));
            }
         query.distinct(true);
         return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    };
    }
}
