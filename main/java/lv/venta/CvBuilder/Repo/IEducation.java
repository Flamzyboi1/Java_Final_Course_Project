package lv.venta.CvBuilder.Repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import lv.venta.CvBuilder.Model.Education;

public interface IEducation extends CrudRepository<Education, Integer> {
    List<Education> findByInstitutionContainingIgnoreCase(String institution);
    List<Education> findByDegreeContainingIgnoreCase(String degree);
}