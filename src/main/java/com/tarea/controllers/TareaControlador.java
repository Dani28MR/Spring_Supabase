package com.tarea.controllers;

import com.tarea.entities.Tarea;
import com.tarea.entities.TareaErrorResponse;
import com.tarea.services.TareaServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/tareas")
public class TareaControlador {
    TareaServicio tareaServicio;
    List<Tarea> tarea;
    public TareaControlador(TareaServicio tareaServicio){
        this.tareaServicio = tareaServicio;
    }

    @GetMapping
    public List<Tarea> getAllTareas(){
        return this.tareaServicio.getAllTareas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> getTareaById(@PathVariable Long id) {
        Optional<Tarea> tarea = tareaServicio.getTareaById(id);
        return tarea.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tarea createTarea(@RequestBody Tarea tarea) {
        return tareaServicio.createTarea(tarea);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTarea(@PathVariable Long id, @RequestBody Tarea tareaDetails) {
        try {
            Tarea updatedTarea = tareaServicio.updateTarea(id, tareaDetails);
            return ResponseEntity.ok(updatedTarea);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(404)
                    .body(new TareaErrorResponse("Error al actualizar la tarea. Tarea no encontrada o datos inválidos."));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,String>> deleteTarea(@PathVariable Long id) {
        tareaServicio.deleteTarea(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Tarea eliminada con éxito");

        return ResponseEntity.ok(response);
    }


}
