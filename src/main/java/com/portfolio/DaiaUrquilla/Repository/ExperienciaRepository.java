package com.portfolio.DaiaUrquilla.Repository;


import com.portfolio.DaiaUrquilla.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author daiau
 */
@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia,Integer> {
   
    public Optional<Experiencia> findByNombreExp(String nombreExp);
    
    public boolean existsByNombreExp(String nombreExp);
}
