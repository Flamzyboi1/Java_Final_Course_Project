package lv.venta.CvBuilder.Repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import lv.venta.CvBuilder.Model.CVProfile;

public interface ICVProfile extends CrudRepository<CVProfile, Integer> {

    List<CVProfile> findByLastNameContainingIgnoreCase(String lastName);

    List<CVProfile> findByExperiencesCompanyContainingIgnoreCase(String companyName);

    Optional<CVProfile> findByEmail(String email);

    @Query("SELECT DISTINCT c FROM CVProfile c JOIN c.cvSkillLinks l WHERE l.proficiencyLevel IN (lv.venta.CvBuilder.Model.CEFRProficiency.C1, lv.venta.CvBuilder.Model.CEFRProficiency.C2)")
    List<CVProfile> findProfilesWithCefrLevelAdvanced();
}