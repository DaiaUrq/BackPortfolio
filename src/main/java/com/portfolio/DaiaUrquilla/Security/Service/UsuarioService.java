package com.portfolio.DaiaUrquilla.Security.Service;

import com.portfolio.DaiaUrquilla.Security.Entity.Usuario;
import com.portfolio.DaiaUrquilla.Security.Repository.iUsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Daia
 */
@Service
public class UsuarioService {
    @Autowired
    iUsuarioRepository iusuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsaurio){
        return iusuarioRepository.findByNombreUsuario(nombreUsaurio);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return iusuarioRepository.existsByEmail(email);
    }    
    @Transactional
    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }
}
