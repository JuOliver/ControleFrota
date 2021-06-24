package com.controlefrota.model;

public class Usuario {
    private String email;
    private String senha;
    private String senhaconf;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenhaconf() {
        return senhaconf;
    }

    public void setSenhaconf(String senhaconf) {
        this.senhaconf = senhaconf;
    }
}
