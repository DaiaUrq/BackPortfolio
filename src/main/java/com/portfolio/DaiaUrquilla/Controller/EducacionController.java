package com.portfolio.DaiaUrquilla.Controller;

import com.portfolio.DaiaUrquilla.Dto.dtoEducacion;
import com.portfolio.DaiaUrquilla.Entity.Educacion;
import com.portfolio.DaiaUrquilla.Security.Controller.Mensaje;
import com.portfolio.DaiaUrquilla.Service.EducacionService;
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
@RequestMapping("educacion")
@CrossOrigin(origins = "https://portfolio-frontend-daia.web.app")

public class EducacionController {

    @Autowired
    EducacionService eduService;

    @GetMapping("/list")
    public ResponseEntity<List<Educacion>> listaEducacion() {
        List<Educacion> listaEdu = eduService.listaEducacion();
        return new ResponseEntity(listaEdu, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {

        if (!eduService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Educacion educacion = eduService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoEdu) {
        if (StringUtils.isBlank(dtoEdu.getNombreEdu())) {
            return new ResponseEntity(new Mensaje("Debe ingresa un nombre para educacion"), HttpStatus.BAD_REQUEST);
        }
        if (eduService.existsByNombreEdu(dtoEdu.getNombreEdu())) {
            return new ResponseEntity(new Mensaje("Ya existe esta educación"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(dtoEdu.getNombreEdu(), dtoEdu.getDescripcionEdu());
        eduService.saveEdu(educacion);

        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoEdu) {

        if (!eduService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(eduService.existsByNombreEdu(dtoEdu.getNombreEdu()) && eduService.getByNombreEdu(dtoEdu.getNombreEdu()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Este nombre ya existe"), HttpStatus.BAD_GATEWAY);
        }

        if (StringUtils.isBlank(dtoEdu.getNombreEdu())) {
            return new ResponseEntity(new Mensaje("Ingrese un nombre"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = eduService.getOne(id).get();
        educacion.setNombreEdu(dtoEdu.getNombreEdu());
        educacion.setDescripcionEdu(dtoEdu.getDescripcionEdu());
        eduService.saveEdu(educacion);

        return new ResponseEntity(new Mensaje("Educacion modificada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {

        if (!eduService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        eduService.deleteExp(id);

        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }

}

