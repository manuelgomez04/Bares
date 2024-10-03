package com.triana.salesianos.dam.bares.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Tags {

    @Id
    @GeneratedValue
    private Long idTag;

    @Column(nullable = false)
    private String name;

    @ManyToMany (fetch = FetchType.EAGER, mappedBy = "listaTags")
    @JsonIgnoreProperties("listaTags")
    private List<Bar> listaBares;
}
