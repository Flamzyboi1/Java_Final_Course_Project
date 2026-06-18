package lv.venta.CvBuilder.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "CV_PROFILE_TABLE")
public class CVProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Idcp")
    private int idcp;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "First_Name")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s\\-]{1,49}$")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "Last_Name")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s\\-]{1,49}$")
    private String lastName;

    @NotNull
    @Email
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")
    @Column(name = "Email", unique = true)
    private String email;

    @Size(max = 500)
    @Column(name = "Summary_Description", length = 500)
    private String summaryDescription;

    @OneToMany(mappedBy = "cvProfile", cascade = CascadeType.ALL)
    private Collection<Experience> experiences = new ArrayList<>();

    @OneToMany(mappedBy = "cvProfile", cascade = CascadeType.ALL)
    private Collection<Education> educations = new ArrayList<>();

    @OneToMany(mappedBy = "cvProfile", cascade = CascadeType.ALL)
    private Collection<CVSkillLink> cvSkillLinks = new ArrayList<>();

    public CVProfile() {}

    public CVProfile(String firstName, String lastName, String email, String summaryDescription, Collection<Education> educations,
    	 Collection<CVSkillLink> cvSkillLinks, Collection<Experience> experiences) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.summaryDescription = summaryDescription;
        this.educations = educations;
        this.cvSkillLinks = cvSkillLinks;
        this.experiences = experiences;
        
    }

    public int getIdcp() { return idcp; }
    public void setIdcp(int idcp) { this.idcp = idcp; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSummaryDescription() { return summaryDescription; }
    public void setSummaryDescription(String summaryDescription) { this.summaryDescription = summaryDescription; }

    public Collection<Experience> getExperiences() { return experiences; }
    public void setExperiences(Collection<Experience> experiences) { this.experiences = experiences; }

    public Collection<Education> getEducations() { return educations; }
    public void setEducations(Collection<Education> educations) { this.educations = educations; }

    public Collection<CVSkillLink> getCvSkillLinks() { return cvSkillLinks; }
    public void setCvSkillLinks(Collection<CVSkillLink> cvSkillLinks) { this.cvSkillLinks = cvSkillLinks; }

	@Override
	public String toString() {
		return "CVProfile [idcp=" + idcp + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", summaryDescription=" + summaryDescription + ", experiences=" + experiences + ", educations="
				+ educations + ", cvSkillLinks=" + cvSkillLinks + "]";
	}
}