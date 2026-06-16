package lv.venta.CvBuilder.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "EXPERIENCE_TABLE")
public class Experience {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Idex")
    private int idex;

    @NotNull
    @Size(min = 2, max = 100, message = "Company name must be between 2 and 100 characters")
    @Column(name = "Company")
    private String company;

    @NotNull
    @Size(min = 2, max = 100, message = "Job title must be between 2 and 100 characters")
    @Column(name = "Job_Title")
    private String jobTitle;

    @Size(max = 1000, message = "Job description cannot exceed 1000 characters")
    @Column(name = "Description", length = 1000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "Idcp")
    private CVProfile cvProfile;

    public Experience() {}

    public Experience(int idex, String company, String jobTitle, String description, CVProfile cvProfile) {
        setIdex(idex);
        setCompany(company);
        setJobTitle(jobTitle);
        setDescription(description);
        setCvProfile(cvProfile);
    }

    public Experience(String company, String jobTitle, String description, CVProfile cvProfile) {
        setCompany(company);
        setJobTitle(jobTitle);
        setDescription(description);
        setCvProfile(cvProfile);
    }

    public int getIdex() { 
        return idex; 
    }
    
    public void setIdex(int idex) {
        this.idex = idex;
    }

    public String getCompany() { 
        return company; 
    }
    
    public void setCompany(String company) { 
        this.company = company; 
    }

    public String getJobTitle() { 
        return jobTitle; 
    }
    
    public void setJobTitle(String jobTitle) { 
        this.jobTitle = jobTitle; 
    }

    public String getDescription() { 
        return description; 
    }
    
    public void setDescription(String description) { 
        this.description = description; 
    }

    public CVProfile getCvProfile() { 
        return cvProfile; 
    }
    
    public void setCvProfile(CVProfile cvProfile) { 
        this.cvProfile = cvProfile; 
    }

    @Override
    public String toString() {
        return "Experience ID: " + idex + " | " + jobTitle + " at " + company;
    }
}