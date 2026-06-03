package lv.venta.CvBuilder.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
  //localhost:8080/
    @GetMapping("/")
    public String getHome() {
        return "cv-home-page"; 
    }
}