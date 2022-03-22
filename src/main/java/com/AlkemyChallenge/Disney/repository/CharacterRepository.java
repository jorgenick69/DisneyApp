package com.AlkemyChallenge.Disney.repository;

import com.AlkemyChallenge.Disney.entity.CharacterEntity;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Long>{
   
    List<CharacterEntity>findAll(Specification<CharacterEntity>spec);
}
