package com.portfolio.DaiaUrquilla.Service;

import com.portfolio.DaiaUrquilla.Entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.DaiaUrquilla.Repository.PersonaRepository;
import java.util.Optional;
import javax.transaction.Transactional;


/**
 *
 * @author Daia
 */

@Service
@Transactional
public class PersonaService {

    @Autowired 
    PersonaRepository personaRepository;
    
   
    public List<Persona> listaPersona() {              
        return personaRepository.findAll();
    }

     public Optional<Persona> getOne(int id){
        return personaRepository.findById(id);
    }
   
     public Optional<Persona> getByNombre(String nombre){
        return personaRepository.findByNombre(nombre);
    } 
     
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }    
   
    public void deletePersona(int id) {
        personaRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return personaRepository.existsById(id);
    }
   
    public boolean existsByNombre(String nombre) {
        return personaRepository.existsByNombre(nombre);
    }      
}
