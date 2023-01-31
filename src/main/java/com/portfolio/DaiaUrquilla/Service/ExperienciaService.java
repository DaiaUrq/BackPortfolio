package com.portfolio.DaiaUrquilla.Service;

import com.portfolio.DaiaUrquilla.Repository.ExperienciaRepository;
import com.portfolio.DaiaUrquilla.Entity.Experiencia;
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
public class ExperienciaService {
    
    @Autowired
    ExperienciaRepository expRepository;
    
    public List<Experiencia> listaExperiencia(){
        return expRepository.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return expRepository.findById(id);
    }
    
    public Optional<Experiencia> getByNombreExp(String nombreExp){
        return expRepository.findByNombreExp(nombreExp);
    }
    
    public void saveExp(Experiencia exp){
        expRepository.save(exp);
    }
    
    public void deleteExpId(int id){
        expRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return expRepository.existsById(id);
    }
    
    public boolean existsByNombreExp(String nombreExp){
        return expRepository.existsByNombreExp(nombreExp);
    }
}
