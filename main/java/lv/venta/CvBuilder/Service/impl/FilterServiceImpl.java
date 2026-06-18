package lv.venta.CvBuilder.Service.impl;

import lv.venta.CvBuilder.Model.*;
import lv.venta.CvBuilder.Repo.*;
import lv.venta.CvBuilder.Service.IFilterCVBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FilterServiceImpl implements IFilterCVBuilderService {

    @Autowired
    private ICVProfile cvRepo;

    @Autowired
    private IExperience experienceRepo;

    @Autowired
    private IEducation educationRepo;

    @Autowired
    private ISkill skillRepo;

    @Autowired
    private ICVSkillLink cvSkillLinkRepo;

    @Override
    public ArrayList<CVProfile> filterProfilesWithAdvancedLanguages() throws Exception {
        List<CVProfile> rawResult = cvRepo.findProfilesWithCefrLevelAdvanced();
        if (rawResult == null || rawResult.isEmpty()) {
            throw new Exception("There are no CV profiles with advanced language levels");
        }
        return new ArrayList<>(rawResult);
    }

    @Override
    public ArrayList<CVProfile> filterProfilesByWorkplace(String companyName) throws Exception {
        if (companyName == null || companyName.isEmpty()) {
            throw new Exception("Company name input is incorrect!");
        }
        List<CVProfile> rawResult = cvRepo.findByExperiencesCompanyContainingIgnoreCase(companyName);
        if (rawResult == null || rawResult.isEmpty()) {
            throw new Exception("There are no CV profiles under company: " + companyName);
        }
        return new ArrayList<>(rawResult);
    }

    @Override
    public ArrayList<CVProfile> filterProfilesByLastName(String lastName) throws Exception {
        if (lastName == null || lastName.isEmpty()) {
            throw new Exception("Last name input is incorrect!");
        }
        List<CVProfile> rawResult = cvRepo.findByLastNameContainingIgnoreCase(lastName);
        if (rawResult == null || rawResult.isEmpty()) {
            throw new Exception("There are no CV profiles found with last name: " + lastName);
        }
        return new ArrayList<>(rawResult);
    }

    @Override
    public ArrayList<Experience> filterExperiencesByJobTitle(String jobTitle) throws Exception {
        if (jobTitle == null || jobTitle.isEmpty()) {
            throw new Exception("Job title input is incorrect!");
        }
        List<Experience> rawResult = experienceRepo.findByJobTitleContainingIgnoreCase(jobTitle);
        if (rawResult == null || rawResult.isEmpty()) {
            throw new Exception("There are no experience records found with job title: " + jobTitle);
        }
        return new ArrayList<>(rawResult);
    }

    @Override
    public ArrayList<Education> filterEducationsByInstitution(String institution) throws Exception {
        if (institution == null || institution.isEmpty()) {
            throw new Exception("Institution input is incorrect!");
        }
        List<Education> rawResult = educationRepo.findByInstitutionContainingIgnoreCase(institution);
        if (rawResult == null || rawResult.isEmpty()) {
            throw new Exception("There are no education records found for institution: " + institution);
        }
        return new ArrayList<>(rawResult);
    }

    @Override
    public ArrayList<Education> filterEducationsByDegree(String degree) throws Exception {
        if (degree == null || degree.isEmpty()) {
            throw new Exception("Degree input is incorrect!");
        }
        List<Education> rawResult = educationRepo.findByDegreeContainingIgnoreCase(degree);
        if (rawResult == null || rawResult.isEmpty()) {
            throw new Exception("There are no education records found for degree: " + degree);
        }
        return new ArrayList<>(rawResult);
    }

    @Override
    public ArrayList<Skill> filterSkillsByCategory(String category) throws Exception {
        if (category == null || category.isEmpty()) {
            throw new Exception("Category input is incorrect!");
        }
        List<Skill> rawResult = skillRepo.findByNameContainingIgnoreCase(category);
        if (rawResult == null || rawResult.isEmpty()) {
            throw new Exception("There are no skills found under: " + category);
        }
        return new ArrayList<>(rawResult);
    }

    @Override
    public ArrayList<CVSkillLink> filterCvSkillLinksByLevel(String level) throws Exception {
        if (level == null || level.isEmpty()) {
            throw new Exception("Skill level input is incorrect!");
        }
        try {
            CEFRProficiency levelEnum = CEFRProficiency.valueOf(level.toUpperCase().trim());
            List<CVSkillLink> rawResult = cvSkillLinkRepo.findByProficiencyLevel(levelEnum);
            if (rawResult == null || rawResult.isEmpty()) {
                throw new Exception("There are no CV skill mapping connections found with level: " + levelEnum);
            }
            return new ArrayList<>(rawResult);
        } catch (IllegalArgumentException e) {
            throw new Exception("Provided string is not a valid CEFR Proficiency Enum value");
        }
    }
}