package lv.venta.CvBuilder.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lv.venta.CvBuilder.Service.IFilterCVBuilderService;

@Controller
@RequestMapping("/filter")
public class FilterController {

    @Autowired
    private IFilterCVBuilderService filterService;

    @GetMapping("")
    public String getFilterPage() {
        return "data-page";
    }

    @GetMapping("/europassExperts")
    public String getHighLevelLanguages(Model model) {
        try {
            model.addAttribute("cvList", filterService.filterProfilesWithAdvancedLanguages());
            return "show-all-cv-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/searchByCompany")
    public String getCVsByWorkplace(@RequestParam(name = "company") String company, Model model) {
        try {
            model.addAttribute("cvList", filterService.filterProfilesByWorkplace(company));
            return "show-all-cv-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/searchByLastName")
    public String getCVsByLastName(@RequestParam(name = "lastName") String lastName, Model model) {
        try {
            model.addAttribute("cvList", filterService.filterProfilesByLastName(lastName));
            return "show-all-cv-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/experience/searchByJobTitle")
    public String getExperiencesByJobTitle(@RequestParam(name = "jobTitle") String jobTitle, Model model) {
        try {
            model.addAttribute("experienceList", filterService.filterExperiencesByJobTitle(jobTitle));
            return "show-all-experience-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/education/searchByInstitution")
    public String getEducationsByInstitution(@RequestParam(name = "institution") String institution, Model model) {
        try {
            model.addAttribute("educationList", filterService.filterEducationsByInstitution(institution));
            return "show-all-education-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/education/searchByDegree")
    public String getEducationsByDegree(@RequestParam(name = "degree") String degree, Model model) {
        try {
            model.addAttribute("educationList", filterService.filterEducationsByDegree(degree));
            return "show-all-education-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/skill/searchByCategory")
    public String getSkillsByCategory(@RequestParam(name = "category") String category, Model model) {
        try {
            model.addAttribute("skillList", filterService.filterSkillsByCategory(category));
            return "show-all-skill-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/cvskill/searchByLevel")
    public String getCvSkillLinksByLevel(@RequestParam(name = "level") String level, Model model) {
        try {
            model.addAttribute("linkList", filterService.filterCvSkillLinksByLevel(level));
            return "show-all-cvskill-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }
}