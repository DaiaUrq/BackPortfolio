package com.portfolio.DaiaUrquilla.Service;

import com.portfolio.DaiaUrquilla.Entity.Proyecto;
import com.portfolio.DaiaUrquilla.Repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author daiau
 */
@Service
@Transactional
public class ProyectoService {
    @Autowired
    ProyectoRepository proyRepository;
    
    public List<Proyecto> listaProyecto(){
        return proyRepository.findAll();
    }
    
    public Optional<Proyecto> getOne(int id){
        return proyRepository.findById(id);
    }
    
    public Optional<Proyecto> getByNombreProy(String nombreProy){
        return proyRepository.findByNombreProy(nombreProy);
    }
    
    public void save(Proyecto exp){
       proyRepository.save(exp);
    }
    
    public void deleteExpId(int id){
        proyRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return proyRepository.existsById(id);
    }
    
    public boolean existsByNombreProy(String nombreProy){
        return proyRepository.existsByNombreProy(nombreProy);
    }
}
