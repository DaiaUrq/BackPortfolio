package com.portfolio.DaiaUrquilla.Repository;

import com.portfolio.DaiaUrquilla.Entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author daiau
 */
@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer>{
    
    Optional<Skill> findByNombreSkill(String nombre);
    
    public boolean existsByNombreSkill(String nombre);
    
}
