package com.triana.salesianos.dam.bares.services;

import com.triana.salesianos.dam.bares.models.Bar;
import com.triana.salesianos.dam.bares.models.Tags;
import com.triana.salesianos.dam.bares.repositories.BarRepository;
import com.triana.salesianos.dam.bares.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarService {

    @Autowired
    private BarRepository barRepository;

    @Autowired
    private TagRepository tagRepository;

    public List<Bar> findAll() {
        return barRepository.findAll();
    }

    public Bar findById(Long id) {

        return barRepository.findById(id).orElse(null);
    }

    public Bar editBar(Bar b, Long id) {

        barRepository.findById(id).map(
                bar -> {
                    bar.setNombre(b.getNombre());
                    bar.setDireccion(b.getDireccion());
                    bar.setDescripcion(b.getDescripcion());
                    bar.setLatitud(b.getLatitud());
                    bar.setLongitud(b.getLongitud());
                    bar.setUrlFoto(b.getUrlFoto());
                    return barRepository.save(bar);
                }
        );
        return b;
    }

    public void deleteBarById(Long id) {
        barRepository.deleteById(id);
    }

    public Bar addBar(Bar bar) {
        return barRepository.save(bar);
    }

    public Bar anadirTag(Long id, Long idTag) {
        Bar bar = barRepository.findById(id).orElse(null);
        Tags nuevo_tag = tagRepository.findById(idTag).orElse(null);

        if (nuevo_tag == null) {
            return null;
        } else
            bar.getListaTags().add(tagRepository.findById(idTag).orElse(null));
        return barRepository.save(bar);

    }

    public Bar borrarTag(Long id, Long idTag){
        Bar bar = barRepository.findById(id).orElse(null);
        Tags tag = tagRepository.findById(idTag).orElse(null);

        if(tag == null || bar.getListaTags().stream().allMatch(t -> t.getIdTag() != idTag)){
            return null;
        }else
            bar.getListaTags().remove(tag);
        return barRepository.save(bar);
    }
}
