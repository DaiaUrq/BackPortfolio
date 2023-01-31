package com.portfolio.DaiaUrquilla.Service;

import com.portfolio.DaiaUrquilla.Entity.Educacion;
import com.portfolio.DaiaUrquilla.Repository.EducacionRepository;
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
public class EducacionService {
    @Autowired
    EducacionRepository eduRepository;
    
    public List<Educacion> listaEducacion(){
        return eduRepository.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return eduRepository.findById(id);
    }
    
    public Optional<Educacion> getByNombreEdu(String nombreEdu){
        return eduRepository.findByNombreEdu(nombreEdu);
    }
    
    public void saveEdu(Educacion edu){
        eduRepository.save(edu);
    }
    
    public void deleteExp(int id){
        eduRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
       return eduRepository.existsById(id);
    }
    public boolean existsByNombreEdu(String nombreEdu){
        return eduRepository.existsByNombreEdu(nombreEdu);
    }    
}