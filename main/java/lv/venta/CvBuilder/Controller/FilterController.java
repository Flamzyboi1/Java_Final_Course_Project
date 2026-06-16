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

    //localhost:8080/filter
    @GetMapping("")
    public String getFilterPage() {
        return "data-page";
    }

    //localhost:8080/filter/europassExperts
    @GetMapping("/europassExperts")
    public String getHighLevelLanguages(Model model) {
        try {
            model.addAttribute("cvList", filterService.filterProfilesWithAdvancedLanguages());
            return "show-all-cv-page";
        } catch (Exception e) {
            model.addAttribute("box", e.getMessage());
            return "error-page";
        }
    }

    //localhost:8080/filter/searchByCompany?company=Bolt
    @GetMapping("/searchByCompany")
    public String getCVsByWorkplace(@RequestParam(name = "company") String company, Model model) {
        try {
            model.addAttribute("cvList", filterService.filterProfilesByWorkplace(company));
            return "show-all-cv-page";
        } catch (Exception e) {
            model.addAttribute("box", e.getMessage());
            return "error-page";
        }
    }
}