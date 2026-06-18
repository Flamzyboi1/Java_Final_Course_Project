package lv.venta.CvBuilder;

import lv.venta.CvBuilder.Model.CVProfile;
import lv.venta.CvBuilder.Model.Experience;
import lv.venta.CvBuilder.Model.CVSkillLink;
import lv.venta.CvBuilder.Model.Education;
import lv.venta.CvBuilder.Model.Skill;
import lv.venta.CvBuilder.Model.CEFRProficiency;
import lv.venta.CvBuilder.Repo.ICVProfile;
import lv.venta.CvBuilder.Repo.ICVSkillLink;
import lv.venta.CvBuilder.Repo.IEducation;
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
            ISkill skillRepo,IEducation eduRepo) {
        
        return args -> {
            if (cvRepo.count() == 0) {
                
                Skill javaSkill = new Skill("Java Spring Boot");
                Skill webSkill = new Skill("Full-stack Development");
                Skill pythonSkill = new Skill("Python Scripting");
                Skill iotSkill = new Skill("IoT & Embedded Systems");
                Skill cppSkill = new Skill("C++ Hardware Programming");
                Skill sqlSkill = new Skill("PostgreSQL Database Management");
                Skill qaSkill = new Skill("Automated Testing & QA");
                Skill devopsSkill = new Skill("DevOps & Cloud Infrastructure");

                skillRepo.save(javaSkill);
                skillRepo.save(webSkill);
                skillRepo.save(pythonSkill);
                skillRepo.save(iotSkill);
                skillRepo.save(cppSkill);
                skillRepo.save(sqlSkill);
                skillRepo.save(qaSkill);
                skillRepo.save(devopsSkill);

                CVProfile profile1 = new CVProfile();
                profile1.setFirstName("Christine");
                profile1.setLastName("Uzoekwe");
                profile1.setEmail("christine@venta.lv");
                profile1.setSummaryDescription("Detail-oriented academic assistant specializing in student research coordination.");
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
                profile2.setSummaryDescription("Junior software engineer passionate about scalable backend architecture.");
                //Collection<Education> edu3;
			//	profile2.setEducations(edu3);
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
                profile3.setEmail("obidfavologistics@venta.lv");
                profile3.setSummaryDescription("B.Sc. Computer Science student with specialized logistics operations expertise focusing on transit metrics and route optimization.");
                cvRepo.save(profile3);

                Experience exp3 = new Experience();
                exp3.setCompany("Bolt Delivery Systems");
                exp3.setJobTitle("Logistics Analyst Hub Operator");
                exp3.setDescription("Managed fast-paced supply chain delivery logistics, automated scheduling tracking sheets, and coordinated vehicle deployments.");
                exp3.setCvProfile(profile3);
                experienceRepo.save(exp3);

                CVSkillLink skillLink3 = new CVSkillLink();
                skillLink3.setSkill(pythonSkill);
                skillLink3.setProficiencyLevel(CEFRProficiency.B2); 
                skillLink3.setCvProfile(profile3);
                skillLinkRepo.save(skillLink3);

                CVProfile profile4 = new CVProfile();
                profile4.setFirstName("Favour");
                profile4.setLastName("Obi");
                profile4.setEmail("obidfavotech@venta.lv");
                profile4.setSummaryDescription("Developer proficient in microcontrollers and server architectures, skilled in building real-time telemetry systems.");
                cvRepo.save(profile4);

                Experience exp4 = new Experience();
                exp4.setCompany("Ventspils Smart Technology Labs");
                exp4.setJobTitle("IoT Prototyping Intern");
                exp4.setDescription("Configured ESP32 and micro:bit sensory devices connected to remote PostgreSQL environmental monitoring instances.");
                exp4.setCvProfile(profile4);
                experienceRepo.save(exp4);

                CVSkillLink skillLink4 = new CVSkillLink();
                skillLink4.setSkill(iotSkill);
                skillLink4.setProficiencyLevel(CEFRProficiency.C1);
                skillLink4.setCvProfile(profile4);
                skillLinkRepo.save(skillLink4);

                CVProfile profile5 = new CVProfile();
                profile5.setFirstName("Favour");
                profile5.setLastName("Obi");
                profile5.setEmail("obidfavodata@venta.lv");
                profile5.setSummaryDescription("Data Specialist with background monitoring concurrent match systems, ensuring fast processing times.");
                cvRepo.save(profile5);

                Experience exp5 = new Experience();
                exp5.setCompany("IMG Arena (Sportradar)");
                exp5.setJobTitle("Live Match Data Scorer");
                exp5.setDescription("Executed structural real-time evaluation of high-tempo sporting events using proprietary CRM and keying application tools.");
                exp5.setCvProfile(profile5);
                experienceRepo.save(exp5);

                CVSkillLink skillLink5 = new CVSkillLink();
                skillLink5.setSkill(javaSkill);
                skillLink5.setProficiencyLevel(CEFRProficiency.B1);
                skillLink5.setCvProfile(profile5);
                skillLinkRepo.save(skillLink5);

                CVProfile profile6 = new CVProfile();
                profile6.setFirstName("Martha");
                profile6.setLastName("Rungevica");
                profile6.setEmail("martarunge@riga.it");
                profile6.setSummaryDescription("Senior Architect specializing in high-throughput enterprise systems across banking infrastructures.");
                cvRepo.save(profile6);

                Experience exp6 = new Experience();
                exp6.setCompany("Swedbank Latvia");
                exp6.setJobTitle("Senior Java Developer");
                exp6.setDescription("Migrated complex payment microservices into modern cloud configurations safely.");
                exp6.setCvProfile(profile6);
                experienceRepo.save(exp6);

                CVSkillLink skillLink6 = new CVSkillLink();
                skillLink6.setSkill(javaSkill);
                skillLink6.setProficiencyLevel(CEFRProficiency.C2);
                skillLink6.setCvProfile(profile6);
                skillLinkRepo.save(skillLink6);

                CVProfile profile7 = new CVProfile();
                profile7.setFirstName("Anna");
                profile7.setLastName("Mariana");
                profile7.setEmail("annamaria@lmt.lv");
                profile7.setSummaryDescription("Network systems expert looking into modern 5G cellular communication integrations.");
                cvRepo.save(profile7);

                Experience exp7 = new Experience();
                exp7.setCompany("LMT (Latvijas Mobilais Telefons)");
                exp7.setJobTitle("Systems Engineer");
                exp7.setDescription("Maintained server communications hardware and engineered core networking scripting protocols.");
                exp7.setCvProfile(profile7);
                experienceRepo.save(exp7);

                CVSkillLink skillLink7 = new CVSkillLink();
                skillLink7.setSkill(pythonSkill);
                skillLink7.setProficiencyLevel(CEFRProficiency.B1);
                skillLink7.setCvProfile(profile7);
                skillLinkRepo.save(skillLink7);

                CVProfile profile8 = new CVProfile();
                profile8.setFirstName("Aleksejs");
                profile8.setLastName("Ivanovs");
                profile8.setEmail("aleksej@evolution.com");
                profile8.setSummaryDescription("Quality Assurance specialist focusing on regression test automation and automated UI workflows.");
                cvRepo.save(profile8);

                Experience exp8 = new Experience();
                exp8.setCompany("Evolution Gaming");
                exp8.setJobTitle("QA Test Automation Engineer");
                exp8.setDescription("Designed integration suites for continuous testing using advanced programmatic frameworks.");
                exp8.setCvProfile(profile8);
                experienceRepo.save(exp8);

                CVSkillLink skillLink8 = new CVSkillLink();
                skillLink8.setSkill(qaSkill);
                skillLink8.setProficiencyLevel(CEFRProficiency.C1);
                skillLink8.setCvProfile(profile8);
                skillLinkRepo.save(skillLink8);

                CVProfile profile9 = new CVProfile();
                profile9.setFirstName("Elena");
                profile9.setLastName("Petrova");
                profile9.setEmail("elenpetrova@printful.com");
                profile9.setSummaryDescription("Frontend Engineer passionate about user interfaces, design system compliance, and performance scaling.");
                cvRepo.save(profile9);

                Experience exp9 = new Experience();
                exp9.setCompany("Printful");
                exp9.setJobTitle("Frontend Web Developer");
                exp9.setDescription("Optimized component rendering processes for dynamic global e-commerce systems.");
                exp9.setCvProfile(profile9);
                experienceRepo.save(exp9);

                CVSkillLink skillLink9 = new CVSkillLink();
                skillLink9.setSkill(webSkill);
                skillLink9.setProficiencyLevel(CEFRProficiency.A2);
                skillLink9.setCvProfile(profile9);
                skillLinkRepo.save(skillLink9);

                CVProfile profile10 = new CVProfile();
                profile10.setFirstName("Roberts");
                profile10.setLastName("Kings");
                profile10.setEmail("roberts@mikrotik.lv");
                profile10.setSummaryDescription("Hardware level engineer specializing in embedded Linux kernels and low-level firmware optimizations.");
                cvRepo.save(profile10);

                Experience exp10 = new Experience();
                exp10.setCompany("MikroTik");
                exp10.setJobTitle("Embedded Software Dev");
                exp10.setDescription("Programmed proprietary router functionalities using efficient kernel manipulation designs.");
                exp10.setCvProfile(profile10);
                experienceRepo.save(exp10);

                CVSkillLink skillLink10 = new CVSkillLink();
                skillLink10.setSkill(cppSkill);
                skillLink10.setProficiencyLevel(CEFRProficiency.C2);
                skillLink10.setCvProfile(profile10);
                skillLinkRepo.save(skillLink10);

                CVProfile profile11 = new CVProfile();
                profile11.setFirstName("Sophia");
                profile11.setLastName("Mike");
                profile11.setEmail("sophia@cloudtech.de");
                profile11.setSummaryDescription("DevOps engineer focusing on Docker orchestration and continuous infrastructure integrations.");
                cvRepo.save(profile11);

                Experience exp11 = new Experience();
                exp11.setCompany("TET Technology Services");
                exp11.setJobTitle("Cloud Systems Architect");
                exp11.setDescription("Constructed automated delivery tracks managing server application structures securely.");
                exp11.setCvProfile(profile11);
                experienceRepo.save(exp11);

                CVSkillLink skillLink11 = new CVSkillLink();
                skillLink11.setSkill(devopsSkill);
                skillLink11.setProficiencyLevel(CEFRProficiency.B2);
                skillLink11.setCvProfile(profile11);
                skillLinkRepo.save(skillLink11);

                CVProfile profile12 = new CVProfile();
                profile12.setFirstName("Karina");
                profile12.setLastName("Paul");
                profile12.setEmail("karin@balticdata.lt");
                profile12.setSummaryDescription("Database specialist specializing in safe query scaling and database clusters optimization.");
                cvRepo.save(profile12);

                Experience exp12 = new Experience();
                exp12.setCompany("Baltic Data Systems");
                exp12.setJobTitle("Data Engineer");
                exp12.setDescription("Maintained multi-node structural systems ensuring continuous safe processing across tables.");
                exp12.setCvProfile(profile12);
                experienceRepo.save(exp12);

                CVSkillLink skillLink12 = new CVSkillLink();
                skillLink12.setSkill(sqlSkill);
                skillLink12.setProficiencyLevel(CEFRProficiency.C1);
                skillLink12.setCvProfile(profile12);
                skillLinkRepo.save(skillLink12);

                CVProfile profile13 = new CVProfile();
                profile13.setFirstName("Laura");
                profile13.setLastName("Peters");
                profile13.setEmail("laupet@wolt.com");
                profile13.setSummaryDescription("Full-Stack engineer with extensive operational logic implementation experience across dispatch platforms.");
                cvRepo.save(profile13);

                Experience exp13 = new Experience();
                exp13.setCompany("Wolt Baltics Hub");
                exp13.setJobTitle("Full-Stack Software Engineer");
                exp13.setDescription("Engineered modern front-facing tracking elements while adjusting server-side connection modules.");
                exp13.setCvProfile(profile13);
                experienceRepo.save(exp13);

                CVSkillLink skillLink13 = new CVSkillLink();
                skillLink13.setSkill(webSkill);
                skillLink13.setProficiencyLevel(CEFRProficiency.B1);
                skillLink13.setCvProfile(profile13);
                skillLinkRepo.save(skillLink13);
                
                Education edu1 = new  Education();
                //edu1.setIded(1);
                edu1.setDegree("Master");
                edu1.setInstitution("Ventspils University");
                edu1.setCvProfile(profile1);
                eduRepo.save(edu1);
                
                Education edu2 = new  Education();
                //edu2.setIded(2);
                edu2.setDegree("Bachelor");
                edu2.setInstitution("Riga University");
                edu2.setCvProfile(profile2);
                eduRepo.save(edu2);
                
                Education edu3 = new  Education();
                //edu3.setIded(3);
                edu3.setDegree("Bachelor");
                edu3.setInstitution("Jelgava University");
                edu3.setCvProfile(profile3);
                eduRepo.save(edu3);
                
                System.out.println("--> Success: Initialized 13  records.");
            }
        };
    }
}