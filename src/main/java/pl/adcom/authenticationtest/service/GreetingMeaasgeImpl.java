package pl.adcom.authenticationtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class GreetingMeaasgeImpl implements GreetingMeaasge {

    private LoginCounter loginCounter;

    @Autowired
    public GreetingMeaasgeImpl(LoginCounter loginCounter) {
        this.loginCounter = loginCounter;
    }

    @Override
    public String messageForAdmin(Principal principal) {
        return "Cześć admin: " + principal.getName() + " zalogowałeś się po raz: " + loginCounter.getAllVisits(principal.getName());
    }

    @Override
    public String messageForUser(Principal principal) {
        return "Cześć user: " + principal.getName() + " zalogowałeś się po raz: " + loginCounter.getAllVisits(principal.getName());
    }

    @Override
    public String messageForUnknown(Principal principal) {
        if (principal != null)
            return "Cześć: " + principal.getName() + " zalogowałeś się po raz: " + loginCounter.getAllVisits(principal.getName());
        return "Cześć nieznajomy";
    }

    @Override
    public String ByeBye() {
        return "PaPa";
    }
}