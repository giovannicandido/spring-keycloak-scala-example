package info.atende.ssc.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Giovanni Silva
 *         02/06/15.
 */
@           Controller
public class Hello {
    @RequestMapping("/")
    public String home(){
        return "index";
    }
    @RequestMapping("/customers")
    public String custumers(){
        return "Authenticated man";
    }
}
