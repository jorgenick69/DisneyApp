package com.AlkemyChallenge.Disney.repository;

import com.AlkemyChallenge.Disney.entity.MovieEntity;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long>{
      List<MovieEntity>findAll(Specification<MovieEntity>spec);
}
