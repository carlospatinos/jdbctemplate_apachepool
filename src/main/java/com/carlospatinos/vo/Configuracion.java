package com.carlospatinos.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


public class Configuracion implements Serializable {
    private static final long serialVersionUID = -123123123123L;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String usuario;
    private String password;
    private String url;
}
