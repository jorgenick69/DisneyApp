package com.AlkemyChallenge.Disney.repository;

import com.AlkemyChallenge.Disney.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long>{
    
}
