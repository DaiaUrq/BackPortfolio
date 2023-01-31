package com.portfolio.DaiaUrquilla.Security.Repository;

import com.portfolio.DaiaUrquilla.Security.Entity.Rol;
import com.portfolio.DaiaUrquilla.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Daia
 */
@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
