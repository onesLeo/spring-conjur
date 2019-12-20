package com.allianz.springconjur.controller;

import net.conjur.api.Conjur;
import net.conjur.api.Credentials;

public class ConjurController {
    private Conjur conjur;
    private Credentials credentials;
    private String mySecretVar;

    public ConjurController(){
        setupEnv();
        System.out.println("TRYING TO INITIALIZE THE CONJUR OBJECT");
        conjur = new Conjur("Leonardo@CustomPolicy","1p16srg266q9bg38pept1sby97e2xdbde120txpq92rpxhcz1dbvf5m");
        System.out.println("FINISH INITIALIZED THE CONJUR OBJECT");
        mySecretVar = "";

    }

    public void setupEnv(){
        System.setProperty("CONJUR_ACCOUNT", System.getenv("CONJUR_ACCOUNT"));

        System.setProperty("CONJUR_AUTHN_API_KEY", System.getenv("CONJUR_AUTHN_API_KEY"));

        System.setProperty("CONJUR_AUTHN_LOGIN", System.getenv("CONJUR_AUTHN_LOGIN"));

        System.setProperty("CONJUR_APPLIANCE_URL", System.getenv("CONJUR_APPLIANCE_URL"));
    }

    public String retrieveSecret(){
        mySecretVar = conjur.variables().retrieveSecret("CustomPolicy/mySecretVar");
        return mySecretVar;
    }
}
