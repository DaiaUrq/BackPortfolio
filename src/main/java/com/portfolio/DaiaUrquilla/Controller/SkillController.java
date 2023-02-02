package com.portfolio.DaiaUrquilla.Controller;

import com.portfolio.DaiaUrquilla.Dto.dtoSkill;
import com.portfolio.DaiaUrquilla.Entity.Skill;
import com.portfolio.DaiaUrquilla.Security.Controller.Mensaje;
import com.portfolio.DaiaUrquilla.Service.SkillService;
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
@RequestMapping("skill")
@CrossOrigin(origins ={" https://portfolio-frontend-daia.web.app","http://localhost:4200"})
public class SkillController {

    @Autowired
    SkillService sService;

    @GetMapping("/list")
    public ResponseEntity<List<Skill>> listaSkill() {
        List<Skill> listaExp = sService.listaSkill();
        return new ResponseEntity(listaExp, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id) {

        if (!sService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Skill skill = sService.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkill dto) {
        if (StringUtils.isBlank(dto.getNombreSkill())) {
            return new ResponseEntity(new Mensaje("Debe ingresa un nombre de Skill"), HttpStatus.BAD_REQUEST);
        }
        if (sService.existsByNombreSkill(dto.getNombreSkill())) {
            return new ResponseEntity(new Mensaje("Ya existe esta skill"), HttpStatus.BAD_REQUEST);
        }

        Skill skill = new Skill(dto.getNombreSkill(), dto.getPorcentaje());

        sService.saveSkill(skill);

        return new ResponseEntity(new Mensaje("Skill creada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkill dto) {
        //Validamos si existe el ID
        if (!sService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (sService.existsByNombreSkill(dto.getNombreSkill()) && sService.getByNombreSkill(dto.getNombreSkill()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dto.getNombreSkill())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Skill skill = sService.getOne(id).get();
        skill.setNombreSkill(dto.getNombreSkill());
        skill.setPorcentaje(dto.getPorcentaje());

        sService.saveSkill(skill);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }


   @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sService.deleteSkillId(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }

}
