package com.triana.salesianos.dam.bares.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Bar {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String nombre, direccion, descripcion, urlFoto;

    @Column(nullable = false)
    private double latitud, longitud;
}
