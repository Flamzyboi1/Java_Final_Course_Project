package lv.venta.CvBuilder.Repo;

import lv.venta.CvBuilder.Model.Education;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public interface IEducation extends CrudRepository<Education, Integer> {

    // Finds all education records for a specific institution
    ArrayList<Education> findByInstitutionIgnoreCase(String institution);

    // Finds all education records associated with a specific CV Profile ID
    ArrayList<Education> findByCvProfileIdcp(int idcp);
}