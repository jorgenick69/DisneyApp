
package com.AlkemyChallenge.Disney.repository;

import com.AlkemyChallenge.Disney.entity.GenderEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GenderRepository extends JpaRepository<GenderEntity,Long>{
    
}
