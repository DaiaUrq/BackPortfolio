package com.portfolio.DaiaUrquilla.Controller;

import com.portfolio.DaiaUrquilla.Dto.dtoPerso;
import com.portfolio.DaiaUrquilla.Entity.Persona;
import com.portfolio.DaiaUrquilla.Security.Controller.Mensaje;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.DaiaUrquilla.Service.PersonaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Daia
 */
@RestController
@RequestMapping("persona")
@CrossOrigin(origins = "https://portfolio-frontend-daia.web.app")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/list")
    public ResponseEntity<List<Persona>> listaPersona() {
        List<Persona> listaExp = personaService.listaPersona();
        return new ResponseEntity(listaExp, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {

        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPerso dtoP) {

        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }

        if (StringUtils.isBlank(dtoP.getNombre())) {
            return new ResponseEntity(new Mensaje("Ingrese un nombre"), HttpStatus.BAD_REQUEST);
        }

        if (personaService.existsByNombre(dtoP.getNombre()) && personaService.getByNombre(dtoP.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Este nombre ya existe"), HttpStatus.BAD_GATEWAY);
        }

        Persona persona = personaService.getOne(id).get();
        persona.setNombre(dtoP.getNombre());
        persona.setApellido(dtoP.getApellido());
        persona.setAcercaDe(dtoP.getAcercaDe());
        persona.setTitulo1(dtoP.getTitulo1());
        persona.setTitulo2(dtoP.getTitulo2());
        persona.setImg(dtoP.getImg());
        personaService.savePersona(persona);

        return new ResponseEntity(new Mensaje("Persona modificada"), HttpStatus.OK);

    }

//    @PostMapping("/create")
//    public ResponseEntity<?> create(@RequestBody dtoPerso dtoP ) {
//       
//        if (StringUtils.isBlank(dtoP.getNombre())) {
//            return new ResponseEntity(new Mensaje("Debe ingresa un nombre de persona"), HttpStatus.BAD_REQUEST);
//        }
//        if (personaService.existsByNombre(dtoP.getNombre())) {
//            return new ResponseEntity(new Mensaje("Ya existe esta persona"), HttpStatus.BAD_REQUEST);
//        }
//        
//        Persona persona = new Persona(dtoP.getNombre(), dtoP.getApellido(), dtoP.getAcercaDe(), dtoP.getImg() );
//
//        personaService.savePersona(persona);
//
//        return new ResponseEntity(new Mensaje("Persona creada"), HttpStatus.OK);
//    }
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable("id") int id) {
//
//        if (!personaService.existsById(id)) {
//            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
//        }
//
//        personaService.deletePersona(id);
//
//        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
//    }
}
