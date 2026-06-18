package lv.venta.CvBuilder.Service;

import lv.venta.CvBuilder.Model.*;
import java.util.ArrayList;

public interface ICRUDCVBuilderService {
    
    ArrayList<CVProfile> selectAllCVProfiles();
    CVProfile selectCVProfileById(int id) throws Exception;
    void deleteCVProfileById(int id) throws Exception;
    void insertCVProfile(CVProfile cvProfile);
    void updateCVProfileById(int id, CVProfile cvProfile) throws Exception;

    ArrayList<Experience> selectAllExperiences();
    Experience selectExperienceById(int id) throws Exception;
    void deleteExperienceById(int id) throws Exception;
    void insertExperience(Experience experience);
    void updateExperienceById(int id, Experience experience) throws Exception;

    ArrayList<Education> selectAllEducations();
    Education selectEducationById(int id) throws Exception;
    void deleteEducationById(int id) throws Exception;
    void insertEducation(Education education);
    void updateEducationById(int id, Education education) throws Exception;

    ArrayList<Skill> selectAllSkills();
    Skill selectSkillById(int id) throws Exception;
    void deleteSkillById(int id) throws Exception;
    void insertSkill(Skill skill);
    void updateSkillById(int id, Skill skill) throws Exception;

    ArrayList<CVSkillLink> selectAllCvSkillLinks();
    CVSkillLink selectCvSkillLinkById(int id) throws Exception;
    void deleteCvSkillLinkById(int id) throws Exception;
    void insertCvSkillLink(CVSkillLink cvSkillLink);
    void updateCvSkillLinkById(int id, CVSkillLink cvSkillLink) throws Exception;

    void addEducationToCV(int idcp, Education education) throws Exception;
    void addExperienceToCV(int idcp, Experience experience) throws Exception;
}