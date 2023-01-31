package com.portfolio.DaiaUrquilla.Repository;

import com.portfolio.DaiaUrquilla.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author daiau
 */
@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Integer> {
    
    public Optional<Educacion> findByNombreEdu(String nombreEdu);
    
    public boolean existsByNombreEdu(String nombreEdu);
}