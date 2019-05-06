package com.example.primeiraaplicao.entities;

public class Usuario {
    private String Name;
    private String Senha;
    private String E_mail;
    private String Celular;
    private String Endereço;
    private String Complemento;
    private String Fale;
    public Usuario(String name,String senha,String e_mail,String celular,String endereço,String complemento,String fale){
        this.setName(name);
        this.setSenha(senha);
        this.setE_mail(e_mail);
        this.setCelular(celular);
        this.setEndereço(endereço);
        this.setComplemento(complemento);
        this.setFale(fale);

    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String e_mail) {
        E_mail = e_mail;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }

    public String getEndereço() {
        return Endereço;
    }

    public void setEndereço(String endereço) {
        Endereço = endereço;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String complemento) {
        Complemento = complemento;
    }

    public String getFale() {
        return Fale;
    }

    public void setFale(String fale) {
        Fale = fale;
    }
}
