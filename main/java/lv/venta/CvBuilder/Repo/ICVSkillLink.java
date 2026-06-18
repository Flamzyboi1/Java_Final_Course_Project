package lv.venta.CvBuilder.Repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import lv.venta.CvBuilder.Model.CEFRProficiency;
import lv.venta.CvBuilder.Model.CVSkillLink;

public interface ICVSkillLink extends CrudRepository<CVSkillLink, Integer> {
    List<CVSkillLink> findByProficiencyLevel(CEFRProficiency proficiencyLevel);
    List<CVSkillLink> findAll();
}