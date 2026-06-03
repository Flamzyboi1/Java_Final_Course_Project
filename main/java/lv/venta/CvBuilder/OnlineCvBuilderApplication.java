package lv.venta.CvBuilder;

import lv.venta.CvBuilder.Model.CVProfile;
import lv.venta.CvBuilder.Repo.ICVProfile;
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
    public CommandLineRunner loadInitialData(ICVProfile cvRepo) {
        return args -> {
            if (cvRepo.count() == 0) {
                
                // Profile 1 
                CVProfile profile1 = new CVProfile();
                profile1.setFirstName("Christine");
                profile1.setLastName("Uzoekwe");
                profile1.setEmail("christine@venta.lv");

                // Profile 2
                CVProfile profile2 = new CVProfile();
                profile2.setFirstName("Daniel");
                profile2.setLastName("Nwachukwu");
                profile2.setEmail("Lovedaniel@gmail.com");

                // Profile 3
                CVProfile profile3 = new CVProfile();
                profile3.setFirstName("Favour");
                profile3.setLastName("Obi");
                profile3.setEmail("obidfavo@venta.lv");

                
                cvRepo.save(profile1);
                cvRepo.save(profile2);
                cvRepo.save(profile3);

                System.out.println("--> Add: added 3 Europass CV Profiles into the database.");
            }
        };
    }
}