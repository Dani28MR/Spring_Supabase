package com.tarea.services;

import com.tarea.entities.Tarea;
import java.util.Optional;
import com.tarea.repositories.TareaRepositorio;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TareaServicio {
    private TareaRepositorio tareaRepository;

    public TareaServicio(TareaRepositorio tareaRepository) {
        this.tareaRepository = tareaRepository;
    }
    public List<Tarea> getAllTareas(){
        return this.tareaRepository.findAll();
    }

    public Optional<Tarea> getTareaById(Long id) {
        return tareaRepository.findById(id);
    }

    public Tarea createTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Tarea updateTarea(Long id, Tarea tareaDetails) {
        return tareaRepository.findById(id).map(tarea -> {
            tarea.setName(tareaDetails.getName());
            tarea.setDescription(tareaDetails.getDescription());
            tarea.setDate(tareaDetails.getDate());
            tarea.setEstatus(tareaDetails.getEstatus());
            return tareaRepository.save(tarea);
        }).orElseThrow(() -> new RuntimeException("Tarea no encontrada con ID: " + id));
    }

    public void deleteTarea(Long id) {
        tareaRepository.deleteById(id);
    }

}
