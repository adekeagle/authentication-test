package pl.adcom.authenticationtest.service;

import java.security.Principal;

public interface GreetingMeaasge {

    String messageForAdmin(Principal principal);

    String messageForUser(Principal principal);

    String messageForUnknown(Principal principal);

    String ByeBye();

}
