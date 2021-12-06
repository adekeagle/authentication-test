package pl.adcom.authenticationtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.adcom.authenticationtest.service.GreetingMeaasge;

import java.security.Principal;

@RestController
public class UserController {

    private GreetingMeaasge greetingMeaasge;

    @Autowired
    public UserController(GreetingMeaasge greetingMeaasge) {
        this.greetingMeaasge = greetingMeaasge;
    }

    @GetMapping("/admin")
    public String getAdmin(Principal principal){
        return greetingMeaasge.messageForAdmin(principal);
    }

    @GetMapping("/user")
    public String getUser(Principal principal){
        return greetingMeaasge.messageForUser(principal);
    }

    @GetMapping("/forAll")
    public String getAll(Principal principal){
        return greetingMeaasge.messageForUnknown(principal);
    }

    @GetMapping("/papa")
    public String getPa(){
        return greetingMeaasge.ByeBye();
    }
}
