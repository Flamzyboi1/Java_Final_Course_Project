package lv.venta.CvBuilder.Repo;

import lv.venta.CvBuilder.Model.Experience;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public interface IExperience extends CrudRepository<Experience, Integer> {

   
    ArrayList<Experience> findByCompanyIgnoreCase(String company);

    ArrayList<Experience> findByCvProfileIdcp(long idcp);
}