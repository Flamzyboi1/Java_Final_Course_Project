package lv.venta.CvBuilder;

import lv.venta.CvBuilder.Model.CVProfile;
import lv.venta.CvBuilder.Model.Experience;
import lv.venta.CvBuilder.Model.CVSkillLink;
import lv.venta.CvBuilder.Model.Skill;
import lv.venta.CvBuilder.Model.CEFRProficiency;

import lv.venta.CvBuilder.Repo.ICVProfile;
import lv.venta.CvBuilder.Repo.ICVSkillLink;
import lv.venta.CvBuilder.Repo.IExperience;
import lv.venta.CvBuilder.Repo.ISkill;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlineCvBuilderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineCvBuilderApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(
            ICVProfile cvRepo, 
            IExperience experienceRepo, 
            ICVSkillLink skillLinkRepo,
            ISkill skillRepo) {
        
        return args -> {
            if (cvRepo.count() == 0) {
                
                Skill javaSkill = new Skill("Java Spring Boot");
                Skill webSkill = new Skill("Full-stack Development");
                Skill pythonSkill = new Skill("Python Scripting");
                
                skillRepo.save(javaSkill);
                skillRepo.save(webSkill);
                skillRepo.save(pythonSkill);

                CVProfile profile1 = new CVProfile();
                profile1.setFirstName("Christine");
                profile1.setLastName("Uzoekwe");
                profile1.setEmail("christine@venta.lv");
                profile1.setSummary("Detail-oriented academic assistant specializing in student research coordination.");
                cvRepo.save(profile1); 

                Experience exp1 = new Experience();
                exp1.setCompany("Ventspils University of Applied Sciences");
                exp1.setJobTitle("Research Assistant");
                exp1.setDescription("Assisted faculty members in compiling data and managing technical documentation.");
                exp1.setCvProfile(profile1); 
                experienceRepo.save(exp1);

                CVSkillLink skillLink1 = new CVSkillLink();
                skillLink1.setSkill(javaSkill);
                skillLink1.setProficiencyLevel(CEFRProficiency.C1); 
                skillLink1.setCvProfile(profile1); 
                skillLinkRepo.save(skillLink1);

                
                CVProfile profile2 = new CVProfile();
                profile2.setFirstName("Daniel");
                profile2.setLastName("Nwachukwu");
                profile2.setEmail("Lovedaniel@gmail.com");
                profile2.setSummary("Junior software engineer passionate about scalable backend architecture.");
                cvRepo.save(profile2);

                Experience exp2 = new Experience();
                exp2.setCompany("Accenture Baltics");
                exp2.setJobTitle("Junior Software Engineer");
                exp2.setDescription("Developed and unit-tested RESTful API endpoints using Spring Boot frameworks.");
                exp2.setCvProfile(profile2);
                experienceRepo.save(exp2);

                CVSkillLink skillLink2 = new CVSkillLink();
                skillLink2.setSkill(webSkill);
                skillLink2.setProficiencyLevel(CEFRProficiency.C2); 
                skillLink2.setCvProfile(profile2);
                skillLinkRepo.save(skillLink2);

                
                CVProfile profile3 = new CVProfile();
                profile3.setFirstName("Favour");
                profile3.setLastName("Obi");
                profile3.setEmail("obidfavo@venta.lv");
                profile3.setSummary("B.Sc. Computer Science student with practical experience in full-stack development and data management systems.");
                cvRepo.save(profile3);

                Experience exp3 = new Experience();
                exp3.setCompany("Bolt Delivery Systems");
                exp3.setJobTitle("Logistics Analyst");
                exp3.setDescription("Managed fast-paced supply chain delivery logistics, analyzing transit metrics for route optimization.");
                exp3.setCvProfile(profile3);
                experienceRepo.save(exp3);

                CVSkillLink skillLink3 = new CVSkillLink();
                skillLink3.setSkill(pythonSkill);
                skillLink3.setProficiencyLevel(CEFRProficiency.A2); 
                skillLink3.setCvProfile(profile3);
                skillLinkRepo.save(skillLink3);

                System.out.println("--> Success: Added 3 relational profiles with unified skill and company test data.");
            }
        };
    }
}