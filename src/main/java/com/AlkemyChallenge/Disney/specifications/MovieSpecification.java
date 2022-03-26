
package com.AlkemyChallenge.Disney.specifications;

import com.AlkemyChallenge.Disney.dto.MovieFilterDTO;
import com.AlkemyChallenge.Disney.entity.MovieEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Component
public class MovieSpecification {
       public Specification<MovieEntity> getByFilters(MovieFilterDTO movieFiltersDTO){

        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(movieFiltersDTO.getTitle())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("title")),
                                "%" + movieFiltersDTO.getTitle().toLowerCase() + "%"
                        )
                );

            }
            if (movieFiltersDTO.getGenderId()!= null){
                predicates.add(
                        criteriaBuilder.equal(root.<Integer>get("genderId"),movieFiltersDTO.getGenderId())
                );
            }

            

            query.distinct(true);


            String order = "title";

            query.orderBy(
                    movieFiltersDTO.isASC()?
                            criteriaBuilder.asc(root.get(order)) :
                            criteriaBuilder.desc(root.get(order))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };
    }
}


