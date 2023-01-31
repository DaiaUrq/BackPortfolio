package com.portfolio.DaiaUrquilla.Controller;

import com.portfolio.DaiaUrquilla.Dto.dtoProyecto;
import com.portfolio.DaiaUrquilla.Entity.Proyecto;
import com.portfolio.DaiaUrquilla.Security.Controller.Mensaje;
import com.portfolio.DaiaUrquilla.Service.ProyectoService;
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
@RequestMapping("proyecto")
@CrossOrigin(origins = {"https://frontportfoliodu.web.app" ,"http://localhost:4200"})
public class ProyectoController {

    @Autowired
    ProyectoService proyService;

    @GetMapping("/list")
    public ResponseEntity<List<Proyecto>> listaProyecto() {
        List<Proyecto> listaProy = proyService.listaProyecto();
        return new ResponseEntity(listaProy, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {

        if (!proyService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = proyService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoProy) {
        if (StringUtils.isBlank(dtoProy.getNombreProy())) {
            return new ResponseEntity(new Mensaje("Debe ingresa un nombre de proyecto"), HttpStatus.BAD_REQUEST);
        }
        if (proyService.existsByNombreProy(dtoProy.getNombreProy())) {
            return new ResponseEntity(new Mensaje("Ya existe este proyecto"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = new Proyecto(dtoProy.getNombreProy(), dtoProy.getDescripcionProy(), dtoProy.getDireccion(),dtoProy.getImagenP());

        proyService.save(proyecto);

        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoProy) {

        if (!proyService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
//        Long idAux = proyService.getByNombreExp(dtoProy.getNombreProy()).get().getId();
//        
//        if(proyService.existsByNombreExp(dtoProy.getNombreProy()) && !Objects.equals(idAux, id)){
//            return new ResponseEntity(new Mensaje("Ese nombre de proyecto ya existe"), HttpStatus.BAD_REQUEST);
//        }
        if (proyService.existsByNombreProy(dtoProy.getNombreProy()) && proyService.getByNombreProy(dtoProy.getNombreProy()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Este nombre ya existe"), HttpStatus.BAD_GATEWAY);
        }

        if (StringUtils.isBlank(dtoProy.getNombreProy())) {
            return new ResponseEntity(new Mensaje("Ingrese un nombre"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = proyService.getOne(id).get();
        proyecto.setNombreProy(dtoProy.getNombreProy());
        proyecto.setDescripcionProy(dtoProy.getDescripcionProy());
        proyecto.setDireccion(dtoProy.getDireccion());
        proyecto.setImagenP(dtoProy.getImagenP());

        proyService.save(proyecto);

        return new ResponseEntity(new Mensaje("Proyecto modificada"), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {

        if (!proyService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        proyService.deleteExpId(id);

        return new ResponseEntity(new Mensaje("Proyecto eliminada"), HttpStatus.OK);
    }
}
