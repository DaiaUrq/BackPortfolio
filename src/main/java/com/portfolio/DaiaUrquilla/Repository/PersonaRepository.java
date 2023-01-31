package com.portfolio.DaiaUrquilla.Repository;

import com.portfolio.DaiaUrquilla.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Daia
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona,Integer>{
    
    public Optional<Persona> findByNombre(String nombre);
    
    public boolean existsByNombre(String nombre);
}
