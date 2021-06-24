package com.controlefrota;

public class Utilizador {
    String marca;
    String placa;


    public Utilizador() {
        marca =" ";
        placa ="";
    }

    public Utilizador(String marca, String placa) {
        this.marca = marca;
        this.placa = placa;
    }

    public Utilizador(Utilizador u) {
        this.marca = u.marca;
        this.placa = u.placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return marca;
    }
}
