package com.example.DesafioEntregableSpringboot.Entities;

import javax.persistence.*;

@Entity
@Table(name="Laptops")
public class Laptop {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private String marca;
    private Integer precio;
    private String espacio;

    public Laptop() {
    }

    public Laptop(Long id, String modelo, String marca, Integer precio, String espacio) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.espacio = espacio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getEspacio() {
        return espacio;
    }

    public void setEspacio(String espacio) {
        this.espacio = espacio;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", espacio='" + espacio + '\'' +
                '}';
    }
}
