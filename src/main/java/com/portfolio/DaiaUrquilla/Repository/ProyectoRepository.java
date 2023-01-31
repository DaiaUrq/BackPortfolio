package com.portfolio.DaiaUrquilla.Repository;

import com.portfolio.DaiaUrquilla.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author daiau
 */

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer>{
    
     public Optional<Proyecto> findByNombreProy(String nombreProy);
    
    public boolean existsByNombreProy(String nombreProy);
}
