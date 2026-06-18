package lv.venta.CvBuilder.Repo;

import lv.venta.CvBuilder.Model.Skill;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ISkill extends CrudRepository<Skill, Integer> {
    List<Skill> findByNameContainingIgnoreCase(String name);
}