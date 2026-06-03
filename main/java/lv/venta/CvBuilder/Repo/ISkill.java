package lv.venta.CvBuilder.Repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.CvBuilder.Model.Skill;

import java.util.Optional;

public interface ISkill extends CrudRepository<Skill, Integer> {
    Optional<Skill> findByNameIgnoreCase(String name);
}