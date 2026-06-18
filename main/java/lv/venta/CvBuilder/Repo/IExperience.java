package lv.venta.CvBuilder.Repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import lv.venta.CvBuilder.Model.Experience;

public interface IExperience extends CrudRepository<Experience, Integer> {
    List<Experience> findByJobTitleContainingIgnoreCase(String jobTitle);
}