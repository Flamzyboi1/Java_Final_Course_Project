package lv.venta.CvBuilder.fullForm;

public class CVProfileFullForm {

    private String firstName;
    private String lastName;
    private String email;
    private String summaryDescription;

    private String educationInstitution;
    private String educationDegree;

    private String experienceCompany;
    private String experienceJobTitle;
    private String experienceDescription;

    private Integer skillId;
    private String proficiencyLevel;

    public CVProfileFullForm() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSummaryDescription() {
        return summaryDescription;
    }

    public void setSummaryDescription(String summaryDescription) {
        this.summaryDescription = summaryDescription;
    }

    public String getEducationInstitution() {
        return educationInstitution;
    }

    public void setEducationInstitution(String educationInstitution) {
        this.educationInstitution = educationInstitution;
    }

    public String getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(String educationDegree) {
        this.educationDegree = educationDegree;
    }

    public String getExperienceCompany() {
        return experienceCompany;
    }

    public void setExperienceCompany(String experienceCompany) {
        this.experienceCompany = experienceCompany;
    }

    public String getExperienceJobTitle() {
        return experienceJobTitle;
    }

    public void setExperienceJobTitle(String experienceJobTitle) {
        this.experienceJobTitle = experienceJobTitle;
    }

    public String getExperienceDescription() {
        return experienceDescription;
    }

    public void setExperienceDescription(String experienceDescription) {
        this.experienceDescription = experienceDescription;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(String proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }
}