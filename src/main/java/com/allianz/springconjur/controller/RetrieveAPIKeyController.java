package com.allianz.springconjur.controller;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RetrieveAPIKeyController {
    private final Logger LOG = LoggerFactory.getLogger(RetrieveAPIKeyController.class);
    @Autowired
    private RestTemplate restTemplate;

    @Value("${conjur.urlApiKey}")
    private String url;
    @Value("${conjur.username}")
    private String username;
    @Value("${conjur.password}")
    private String password;

    public RetrieveAPIKeyController(){

    }

    @GetMapping(path = "/getconjur/api/key")
    public String getApiKey(){
        String userPass = username+":"+password;
        String encodedPass = Base64.encodeBase64String(userPass.getBytes());
        LOG.info("ENCODED PASS {} ",encodedPass);
        LOG.info("YOUR URL {} ",url);
        ResponseEntity<String> apiyKey = restTemplate.exchange(url, HttpMethod.GET, httpEntity(httpHeaders(encodedPass)), String.class);
        LOG.info("API KEY {} ",apiyKey);

        return apiyKey.getBody();
    }

    private HttpEntity<String> httpEntity(HttpHeaders headers){
        return new HttpEntity<>(headers);
    }

    private HttpHeaders httpHeaders(String encodedPass){
        MultiValueMap<String, String> headersMap = new LinkedMultiValueMap<>();
        headersMap.add(HttpHeaders.AUTHORIZATION,"Basic "+encodedPass);

        return new HttpHeaders(headersMap);
    }
}
