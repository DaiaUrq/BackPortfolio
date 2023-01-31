package com.portfolio.DaiaUrquilla.Service;

import com.portfolio.DaiaUrquilla.Entity.Skill;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.DaiaUrquilla.Repository.SkillRepository;

/**
 *
 * @author daiau
 */
@Transactional
@Service
public class SkillService {
    @Autowired  SkillRepository skillRepository;
    
    public List<Skill> listaSkill(){
        return skillRepository.findAll();
    }
      
    
    public Optional <Skill> getOne(int id){
        return skillRepository.findById(id);
    }
    
    public Optional <Skill> getByNombreSkill(String nombreSkill){
        return skillRepository.findByNombreSkill(nombreSkill);
    }
    
    public void saveSkill(Skill skill){
        skillRepository.save(skill);
    }
    
    public void deleteSkillId(int id){
        skillRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return skillRepository.existsById(id);
    }
    
    public boolean existsByNombreSkill(String nombreSkill){
        return skillRepository.existsByNombreSkill(nombreSkill);
    }
    
}
