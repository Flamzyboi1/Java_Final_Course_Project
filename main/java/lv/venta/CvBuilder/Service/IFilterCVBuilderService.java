package lv.venta.CvBuilder.Service;

import java.util.ArrayList;
import lv.venta.CvBuilder.Model.CVProfile;
import lv.venta.CvBuilder.Model.CVSkillLink;
import lv.venta.CvBuilder.Model.Education;
import lv.venta.CvBuilder.Model.Experience;
import lv.venta.CvBuilder.Model.Skill;

public interface IFilterCVBuilderService {
    ArrayList<CVProfile> filterProfilesWithAdvancedLanguages() throws Exception;
    ArrayList<CVProfile> filterProfilesByWorkplace(String companyName) throws Exception;
    ArrayList<CVProfile> filterProfilesByLastName(String lastName) throws Exception;
    ArrayList<Experience> filterExperiencesByJobTitle(String jobTitle) throws Exception;
    ArrayList<Education> filterEducationsByInstitution(String institution) throws Exception;
    ArrayList<Education> filterEducationsByDegree(String degree) throws Exception;
    ArrayList<Skill> filterSkillsByCategory(String category) throws Exception;
    ArrayList<CVSkillLink> filterCvSkillLinksByLevel(String level) throws Exception;
}