package com.triana.salesianos.dam.bares.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Bar {

    @Id
    @GeneratedValue
    private long idBar;

    @Column(nullable = false)
    private String nombre, direccion, descripcion, urlFoto;

    @Column(nullable = false)
    private double latitud, longitud;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(name= "bar_tags", joinColumns = @JoinColumn(name = "idBar"), inverseJoinColumns = @JoinColumn(name = "idTag"))
    @JsonIgnoreProperties("listaBares")
    private List<Tags> listaTags;

    public void setTag(Tags tag) {
        if (this.listaTags == null) {
            this.listaTags = new ArrayList<>();
        }
        this.listaTags.add(tag);
    }


}
