package com.portfolio.DaiaUrquilla.Controller;

import com.portfolio.DaiaUrquilla.Dto.dtoExperiencia;
import com.portfolio.DaiaUrquilla.Entity.Experiencia;
import com.portfolio.DaiaUrquilla.Security.Controller.Mensaje;
import com.portfolio.DaiaUrquilla.Service.ExperienciaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author daiau
 */
@RestController
@RequestMapping("experiencia")
@CrossOrigin(origins ={"https://portfolio-frontend-daia.web.app","http://localhost:4200"})
public class ExperienciaController {

    @Autowired
    ExperienciaService expService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Experiencia>> listaExperiencia(){
        List<Experiencia> listaExp = expService.listaExperiencia();
        return new ResponseEntity(listaExp, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
            
        if(!expService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = expService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoExp){
        if(StringUtils.isBlank(dtoExp.getNombreExp())){
            return new ResponseEntity(new Mensaje("Debe ingresa un nombre de experiencia"), HttpStatus.BAD_REQUEST);
        }
        if(expService.existsByNombreExp(dtoExp.getNombreExp())){
            return new ResponseEntity (new Mensaje("Ya existe esta experiencia"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = new Experiencia(dtoExp.getNombreExp(), dtoExp.getDescripcionExp())         ;
        
        expService.saveExp(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia creada"), HttpStatus.OK);        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id ,@RequestBody dtoExperiencia dtoExp){
        
        if(!expService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),HttpStatus.BAD_REQUEST);
        }
//        Long idAux = expService.getByNombreExp(dtoExp.getNombreExp()).get().getId();
//        
//        if(expService.existsByNombreExp(dtoExp.getNombreExp()) && !Objects.equals(idAux, id)){
//            return new ResponseEntity(new Mensaje("Ese nombre de experiencia ya existe"), HttpStatus.BAD_REQUEST);
//        }
        
        if(StringUtils.isBlank(dtoExp.getNombreExp())){
            return new ResponseEntity(new Mensaje("Ingrese un nombre"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = expService.getOne(id).get();        
        experiencia.setNombreExp(dtoExp.getNombreExp());
        experiencia.setDescripcionExp(dtoExp.getDescripcionExp());
        expService.saveExp(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia modificada"),HttpStatus.OK);
        
    }
    
    

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        
        if(!expService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),HttpStatus.BAD_REQUEST);
        }
        
        expService.deleteExpId(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
    
   
    
}
