package Controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActivityController {
    @RequestMapping("/")
    public String registerActivity() {
        return "Controller/ActivityController";

    }
}
