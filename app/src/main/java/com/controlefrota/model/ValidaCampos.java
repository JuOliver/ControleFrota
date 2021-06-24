package com.controlefrota.model;

public class ValidaCampos {
    public static boolean Email(String email){
        if(email.isEmpty()){
            return false;
        }
        return true;
    }
}
