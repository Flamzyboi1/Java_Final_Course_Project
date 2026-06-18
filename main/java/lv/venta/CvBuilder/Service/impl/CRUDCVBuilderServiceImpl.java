package lv.venta.CvBuilder.Service.impl;

import lv.venta.CvBuilder.Model.*;
import lv.venta.CvBuilder.Repo.*;
import lv.venta.CvBuilder.Service.ICRUDCVBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;

@Service
public class CRUDCVBuilderServiceImpl implements ICRUDCVBuilderService {

    @Autowired private ICVProfile cvRepo;
    @Autowired private IExperience experienceRepo;
    @Autowired private IEducation educationRepo;
    @Autowired private ISkill skillRepo;
    @Autowired private ICVSkillLink cvSkillLinkRepo;

    @Override
    public ArrayList<CVProfile> selectAllCVProfiles() {
        ArrayList<CVProfile> allProfiles = new ArrayList<>();
        cvRepo.findAll().forEach(allProfiles::add);
        return allProfiles;
    }

    @Override
    @Transactional
    public CVProfile selectCVProfileById(int id) throws Exception {
        return cvRepo.findById(id).orElseThrow(() -> new Exception("Europass CV Profile entry not found"));
    }

    @Override
    public void deleteCVProfileById(int id) throws Exception {
        if (cvRepo.existsById(id)) {
            cvRepo.deleteById(id);
        } else {
            throw new Exception("CV profile entry cannot be deleted - target record not found");
        }
    }

    @Override
    public void insertCVProfile(CVProfile cvProfile) {
        cvRepo.save(cvProfile);
    }

    @Override
    public void updateCVProfileById(int id, CVProfile cvProfile) throws Exception {
        CVProfile existingProfile = cvRepo.findById(id)
                .orElseThrow(() -> new Exception("CV record update targets an invalid reference ID"));
        existingProfile.setFirstName(cvProfile.getFirstName());
        existingProfile.setLastName(cvProfile.getLastName());
        existingProfile.setEmail(cvProfile.getEmail());
        existingProfile.setSummaryDescription(cvProfile.getSummaryDescription());
        cvRepo.save(existingProfile);
    }

    @Override
    public ArrayList<Experience> selectAllExperiences() {
        ArrayList<Experience> allExperiences = new ArrayList<>();
        experienceRepo.findAll().forEach(allExperiences::add);
        return allExperiences;
    }

    @Override
    public Experience selectExperienceById(int id) throws Exception {
        return experienceRepo.findById(id).orElseThrow(() -> new Exception("Experience entry not found"));
    }

    @Override
    public void deleteExperienceById(int id) throws Exception {
        if (experienceRepo.existsById(id)) {
            experienceRepo.deleteById(id);
        } else {
            throw new Exception("Experience entry cannot be deleted - target record not found");
        }
    }

    @Override
    public void insertExperience(Experience experience) {
        experienceRepo.save(experience);
    }

    @Override
    public void updateExperienceById(int id, Experience experience) throws Exception {
        Experience existingExperience = experienceRepo.findById(id)
                .orElseThrow(() -> new Exception("Experience record update targets an invalid reference ID"));
        existingExperience.setCompany(experience.getCompany());
        existingExperience.setJobTitle(experience.getJobTitle());
        existingExperience.setDescription(experience.getDescription());
        experienceRepo.save(existingExperience);
    }

    @Override
    public ArrayList<Education> selectAllEducations() {
        ArrayList<Education> allEducations = new ArrayList<>();
        educationRepo.findAll().forEach(allEducations::add);
        return allEducations;
    }

    @Override
    public Education selectEducationById(int id) throws Exception {
        return educationRepo.findById(id).orElseThrow(() -> new Exception("Education entry not found"));
    }

    @Override
    public void deleteEducationById(int id) throws Exception {
        if (educationRepo.existsById(id)) {
            educationRepo.deleteById(id);
        } else {
            throw new Exception("Education entry cannot be deleted - target record not found");
        }
    }

    @Override
    public void insertEducation(Education education) {
        educationRepo.save(education);
    }

    @Override
    public void updateEducationById(int id, Education education) throws Exception {
        Education existingEducation = educationRepo.findById(id)
                .orElseThrow(() -> new Exception("Education record update targets an invalid reference ID"));
        existingEducation.setInstitution(education.getInstitution());
        existingEducation.setDegree(education.getDegree());
        educationRepo.save(existingEducation);
    }

    @Override
    public ArrayList<Skill> selectAllSkills() {
        ArrayList<Skill> allSkills = new ArrayList<>();
        skillRepo.findAll().forEach(allSkills::add);
        return allSkills;
    }

    @Override
    public Skill selectSkillById(int id) throws Exception {
        return skillRepo.findById(id).orElseThrow(() -> new Exception("Skill entry not found"));
    }

    @Override
    public void deleteSkillById(int id) throws Exception {
        if (skillRepo.existsById(id)) {
            skillRepo.deleteById(id);
        } else {
            throw new Exception("Skill entry cannot be deleted - target record not found");
        }
    }

    @Override
    public void insertSkill(Skill skill) {
        skillRepo.save(skill);
    }

    @Override
    public void updateSkillById(int id, Skill skill) throws Exception {
        Skill existingSkill = skillRepo.findById(id)
                .orElseThrow(() -> new Exception("Skill record update targets an invalid reference ID"));
        existingSkill.setName(skill.getName());
        skillRepo.save(existingSkill);
    }

    @Override
    public ArrayList<CVSkillLink> selectAllCvSkillLinks() {
        ArrayList<CVSkillLink> allLinks = new ArrayList<>();
        cvSkillLinkRepo.findAll().forEach(allLinks::add);
        return allLinks;
    }

    @Override
    public CVSkillLink selectCvSkillLinkById(int id) throws Exception {
        return cvSkillLinkRepo.findById(id).orElseThrow(() -> new Exception("CV Skill Link entry not found"));
    }

    @Override
    public void deleteCvSkillLinkById(int id) throws Exception {
        if (cvSkillLinkRepo.existsById(id)) {
            cvSkillLinkRepo.deleteById(id);
        } else {
            throw new Exception("CV Skill Link entry cannot be deleted - target record not found");
        }
    }

    @Override
    public void insertCvSkillLink(CVSkillLink cvSkillLink) {
        cvSkillLinkRepo.save(cvSkillLink);
    }

    @Override
    public void updateCvSkillLinkById(int id, CVSkillLink cvSkillLink) throws Exception {
        CVSkillLink existingLink = cvSkillLinkRepo.findById(id)
                .orElseThrow(() -> new Exception("CV Skill Link record update targets an invalid reference ID"));
        existingLink.setCvProfile(cvSkillLink.getCvProfile());
        existingLink.setSkill(cvSkillLink.getSkill());
        existingLink.setProficiencyLevel(cvSkillLink.getProficiencyLevel());
        cvSkillLinkRepo.save(existingLink);
    }

    @Override
    @Transactional
    public void addEducationToCV(int idcp, Education education) throws Exception {
        CVProfile profile = cvRepo.findById(idcp).orElseThrow(() -> new Exception("CV not found"));
        education.setCvProfile(profile);
        educationRepo.save(education);
    }

    @Override
    @Transactional
    public void addExperienceToCV(int idcp, Experience experience) throws Exception {
        CVProfile profile = cvRepo.findById(idcp).orElseThrow(() -> new Exception("CV not found"));
        experience.setCvProfile(profile);
        experienceRepo.save(experience);
    }
}