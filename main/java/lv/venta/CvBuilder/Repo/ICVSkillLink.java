package lv.venta.CvBuilder.Repo;

import lv.venta.CvBuilder.Model.CVSkillLink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public interface ICVSkillLink extends CrudRepository<CVSkillLink, Integer> {
    
    //  filter to find all profile skill links by a specific proficiency level
    ArrayList<CVSkillLink> findByProficiencyLevelIgnoreCase(String proficiencyLevel);
    
    // filter to find all skill links associated with a specific CV Profile ID
    ArrayList<CVSkillLink> findByCvProfileIdcp(long idcp);
}