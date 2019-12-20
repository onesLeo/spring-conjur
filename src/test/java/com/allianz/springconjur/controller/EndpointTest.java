package com.allianz.springconjur.controller;

import net.conjur.api.Endpoints;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Properties;

public class EndpointTest {

    @Test
    public void testURI() throws MalformedURLException {
        String service = "authn";
        String accountName ="myAnotherAccountForConjur";
        String path="";

        URI uri = URI.create(String.format("%s/%s/%s/%s", "https://127.0.0.1:8443" , service, accountName, path));
        System.out.println("URI --> "+uri.toString());
        URL url = uri.toURL();
        System.out.println("URL --> "+url.toString());
    }

    @Test
    public void getSysVar(){
        URI uri = Endpoints.fromSystemProperties().getAuthnUri();
        URI uriSecret = Endpoints.fromSystemProperties().getSecretsUri();

        System.out.println("URI --> "+uri);
        System.out.println("SECRET --> "+uriSecret);

        System.out.println("ACCOUNT "+System.getProperty("CONJUR_ACCOUNT"));

        System.out.println(System.getenv("JAVA_HOME"));
    }

    @Test
    public void showSysProp(){
        Properties properties = System.getProperties();
        properties.list(System.out);
    }

//    @Test
//    public void setSysProp(){
//        System.setProperty("CONJUR_ACCOUNT", System.getenv("CONJUR_ACCOUNT"));
//
//        System.setProperty("CONJUR_AUTHN_API_KEY", System.getenv("CONJUR_AUTHN_API_KEY"));
//
//        System.setProperty("CONJUR_AUTHN_LOGIN", System.getenv("CONJUR_AUTHN_LOGIN"));
//
//        System.setProperty("CONJUR_APPLIANCE_URL", System.getenv("CONJUR_APPLIANCE_URL"));
//    }

    @Test
    public void enumeratesSysEnv(){
        System.getenv().entrySet().forEach(System.out::println);
        System.out.println(System.getenv().get("CONJUR_ACCOUNT"));
    }
}
