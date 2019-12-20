package com.allianz.springconjur.controller;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
public class RetrieveSecretVariableValue {
    private final Logger LOG = LoggerFactory.getLogger(RetrieveSecretVariableValue.class);
    @Value("${conjur.urlSecretVar}")
    private String urlSecretVar;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/retrieve/variable")
    public ResponseEntity<String> getTheSecretValue(@RequestBody String payload,
                                                    @RequestParam("variableToRetrieve") String variableToRetrieve) {
        String fullUrlSecretVar = urlSecretVar+"/"+variableToRetrieve;
        String tokenTrimmed = payload.replace("\r","").replace("\n","");
        tokenTrimmed = tokenTrimmed.replace(" ","");
        String encodedToken = Base64.encodeBase64String(tokenTrimmed.getBytes());

        return restTemplate.exchange(fullUrlSecretVar, HttpMethod.GET, httpEntity(httpHeaders(encodedToken)),String.class);
    }

    private HttpEntity<String> httpEntity(HttpHeaders headers){
        return new HttpEntity<>(headers);
    }

    private HttpHeaders httpHeaders(String token){
        MultiValueMap<String, String> headersMap = new LinkedMultiValueMap<>();
        headersMap.set(HttpHeaders.AUTHORIZATION, " Token token=\""+token+"\"");
        return new HttpHeaders(headersMap);
    }
}
