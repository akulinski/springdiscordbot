package core.beans.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("testController")
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/testServer",method = {RequestMethod.GET})
    public ResponseEntity<String> testServer(){
        System.out.println("TEST");
        return new ResponseEntity<String>("\"success\":\"true\"", HttpStatus.ACCEPTED) ;
    }
}
