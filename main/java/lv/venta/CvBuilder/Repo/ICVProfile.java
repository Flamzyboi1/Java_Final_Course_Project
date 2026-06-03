package lv.venta.CvBuilder.Repo;

import lv.venta.CvBuilder.Model.CVProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public interface ICVProfile extends CrudRepository<CVProfile, Integer> {

    
    @Query("SELECT cv FROM CVProfile cv JOIN cv.cvSkillLinks links WHERE UPPER(links.proficiencyLevel) IN ('C1', 'C2', 'ADVANCED')")
    ArrayList<CVProfile> findProfilesWithCefrLevelAdvanced();

    
    @Query("SELECT cv FROM CVProfile cv JOIN cv.experiences exp WHERE UPPER(exp.company) LIKE UPPER(CONCAT('%', :company, '%'))")
    ArrayList<CVProfile> findByExperiencesCompanyContainingIgnoreCase(@Param("company") String company);
}