package com.triana.salesianos.dam.bares.controllers;

import com.triana.salesianos.dam.bares.models.Bar;
import com.triana.salesianos.dam.bares.models.Tags;
import com.triana.salesianos.dam.bares.repositories.TagRepository;
import com.triana.salesianos.dam.bares.services.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/place")
public class BarController {

    @Autowired
    private BarService barService;

    @Autowired
    private TagRepository tagRepository;


    @GetMapping("/")
    public ResponseEntity<List<Bar>> mostrarTodos() {

        if (barService.findAll().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(barService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bar> mostrarBarById(Long id) {
        if (barService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(barService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Bar> addBar(@RequestBody Bar bar) {
        Bar nuevoBar = barService.addBar(bar);
        return ResponseEntity.status(HttpStatus.CREATED).body(barService.addBar(bar));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bar> editBar(@RequestBody Bar bar, @PathVariable Long id) {

        Bar barbuscado = barService.findById(id);

        if (barbuscado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        barService.editBar(bar, id);
        return ResponseEntity.ok(barService.editBar(bar, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Bar> deleteBar(@PathVariable Long id) {
        barService.deleteBarById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/tag/add/{nuevo_tag}")
    public ResponseEntity<Tags> anadirTag(@PathVariable Long id, @PathVariable Long nuevo_tag) {

        Bar barBuscado = barService.findById(id);

        if (barBuscado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        barService.anadirTag(id, nuevo_tag);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/tag/del/{tag}")
    public ResponseEntity<Tags> eliminarTag(@PathVariable Long id, @PathVariable Long tag) {

        Bar barBuscado = barService.findById(id);

        if (barBuscado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        barService.borrarTag(id, tag);
        return ResponseEntity.ok().build();
    }


}
