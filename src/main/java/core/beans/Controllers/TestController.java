package core.beans.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller("testController")
public class TestController {

    @RequestMapping(value = "/testServer",method = {RequestMethod.GET})
    public ResponseEntity<String> testServer(){
        System.out.println("TEST");
        return new ResponseEntity<String>("\"success\":\"true\"", HttpStatus.ACCEPTED) ;
    }

    @RequestMapping(value = "/",method = {RequestMethod.GET})
    public String index(Locale locale, ModelMap model){

        model.addAttribute("text","text");
        model.addAttribute("title","Index");

        return "index";
    }
}
