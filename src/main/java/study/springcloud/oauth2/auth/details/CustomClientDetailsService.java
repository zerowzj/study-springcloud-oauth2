package study.springcloud.oauth2.auth.details;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

public class CustomClientDetailsService implements ClientDetailsService {

    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        return null;
    }
}
