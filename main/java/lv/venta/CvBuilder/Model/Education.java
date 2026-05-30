package lv.venta.CvBuilder.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "EDUCATION_TABLE")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDed")
    private int ided;

    @NotNull
    @Size(min = 2, max = 150, message = "Institution name must be between 2 and 150 characters")
    @Column(name = "Institution")
    private String institution;

    @NotNull
    @Size(min = 2, max = 100, message = "Degree program must be between 2 and 100 characters")
    @Column(name = "Degree")
    private String degree;

    @ManyToOne
    @JoinColumn(name = "Idcp")
    private CVProfile cvProfile;

    public Education() {}

    public Education(String institution, String degree, CVProfile cvProfile) {
        this.institution = institution;
        this.degree = degree;
        this.cvProfile = cvProfile;
    }

    public int getIded() { return ided; }
    public String getInstitution() { return institution; }
    public void setInstitution(String institution) { this.institution = institution; }
    public String getDegree() { return degree; }
    public void setDegree(String degree) { this.degree = degree; }
    public CVProfile getCvProfile() { return cvProfile; }
    public void setCvProfile(CVProfile cvProfile) { this.cvProfile = cvProfile; }

    @Override
    public String toString() {
        String result = ided + " " + degree + " from " + institution;
        return result;
    }
}