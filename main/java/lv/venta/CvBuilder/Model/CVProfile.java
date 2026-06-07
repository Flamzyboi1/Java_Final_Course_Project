package lv.venta.CvBuilder.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "CV_PROFILE_TABLE")
public class CVProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Idcp")
    private int idcp;

    @NotNull
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    @Column(name = "First_Name")
    @Pattern( regexp = "[A-Z]{1}[a-z]{0,9}",
    		message = "First Name must Start with capital letter (e.g., Favour)")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    @Column(name = "Last_Name")
    @Pattern( regexp = "[A-Z]{1}[a-z]{0,9}" ,
    		message = "Last Name must Start with capital letter (e.g., Obi)")
    private String lastName;
    @NotNull(message = "Electronic contact address mail cannot be blank")
    @NotNull
    @Email(message = "Invalid email format")
    @Pattern(
        
        regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", 
        message = "Email must contain exactly one '@' and follow standard address syntax (e.g., s24obidfavo@venta.lv, favobi@gmail.com)"
    )
    @Column(name = "Email")
    private String email;

    @Size(max = 500, message = "Professional summary cannot exceed 500 characters")
    @Column(name = "Summary", length = 500)
    private String summary;

    @OneToMany(mappedBy = "cvProfile", cascade = CascadeType.ALL)
    private Collection<Experience> experiences;

    @OneToMany(mappedBy = "cvProfile", cascade = CascadeType.ALL)
    private Collection<Education> educations;

    @OneToMany(mappedBy = "cvProfile", cascade = CascadeType.ALL)
    private Collection<CVSkillLink> cvSkillLinks;

    public CVProfile() {}

   

    public int getIdcp() { return idcp; }
    public void setIdcp(int idcp) { this.idcp = idcp; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }
    public Collection<Experience> getExperiences() { return experiences; }
    public void setExperiences(Collection<Experience> experiences) { this.experiences = experiences; }
    public Collection<Education> getEducations() { return educations; }
    public void setEducations(Collection<Education> educations) { this.educations = educations; }
    public Collection<CVSkillLink> getCvSkillLinks() { return cvSkillLinks; }
    public void setCvSkillLinks(Collection<CVSkillLink> cvSkillLinks) { this.cvSkillLinks = cvSkillLinks; }
    
    public CVProfile(String firstName, String lastName, String email, String summary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.summary = summary;
    }

   
    @Override
    public String toString() {
        String result = idcp + " " + firstName + " " + lastName + " (" + email + ")";
        return result;
    }
}