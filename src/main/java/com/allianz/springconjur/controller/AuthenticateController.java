package com.allianz.springconjur.controller;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AuthenticateController {
    private static Logger LOG = LoggerFactory.getLogger(AuthenticateController.class);
    @Value("${conjur.orgId}")
    private String orgId;
    @Value("${conjur.urlAuthenticate}")
    private String urlAuthenticate;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(path = "authn/getPayloadOfConjur/{orgId}/{user}")
    public ResponseEntity<String> getPayloadAuthentication(
                                            @PathVariable(name = "orgId") String orgId,
                                            @PathVariable(name = "user") String user,
                                            @RequestBody String apiKey){

        LOG.info("You are accessing conjur authentication..");

        String fullUrl = urlAuthenticate+orgId+"/"+user+"/authenticate";
        LOG.info("FULL URL AUTHENTICATE {}",fullUrl);
        LOG.info("API KEY PASSED {} ",apiKey);

        return restTemplate.exchange(fullUrl, HttpMethod.POST,
                httpEntity(apiKey, new HttpHeaders()),String.class);
    }

    private HttpEntity<?> httpEntity(String apiKey,HttpHeaders headers){
        return new HttpEntity<>(apiKey,headers);
    }
}
