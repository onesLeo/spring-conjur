package com.allianz.springconjur.conjur;

import net.conjur.api.Conjur;
import net.conjur.api.Credentials;

public class ConjurController {
    private Conjur conjur;
    private Credentials credentials;
    private String mySecretVar;

    public ConjurController(){
        conjur = new Conjur();
        mySecretVar = "";
    }

    public String retrieveSecret(){
        mySecretVar = conjur.variables().retrieveSecret("CustomPolicy/mySecretVar");
        return mySecretVar;
    }
}
