package com.tarea.controllers;

import com.tarea.entities.Tarea;
import com.tarea.entities.TareaErrorResponse;
import com.tarea.entities.ValidationErrorResponse;
import com.tarea.services.TareaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public ResponseEntity<?> getTareaById(@PathVariable Long id) {
        Optional<Tarea> tarea = tareaServicio.getTareaById(id);

        // Si la tarea no existe, retornar un 404 con un mensaje
        if (!tarea.isPresent()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "No existe la tarea con id: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        // Si existe, retornar la tarea
        return ResponseEntity.ok(tarea.get());
    }



    @PostMapping
    public ResponseEntity<?> createTarea(@RequestBody Tarea tarea) {
        ValidationErrorResponse validationError = validateTarea(tarea);
        if (validationError != null) {
            return ResponseEntity.badRequest().body(validationError);
        }
        Tarea nuevaTarea = tareaServicio.createTarea(tarea);
        return ResponseEntity.ok(nuevaTarea);
    }



    @PutMapping("/{id}")
    public ResponseEntity updateTarea(@PathVariable Long id, @RequestBody Tarea tareaDetails) {
        // Validar los datos de la tarea
        ValidationErrorResponse errors = validateTarea(tareaDetails);
        if (errors != null) {
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            Tarea updatedTarea = tareaServicio.updateTarea(id, tareaDetails);
            return ResponseEntity.ok(updatedTarea);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new TareaErrorResponse("Error al actualizar la tarea. Tarea no encontrada o datos inválidos."));
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteTarea(@PathVariable Long id) {
        // Obtenemos un Optional<Tarea>
        Optional<Tarea> tareaExistente = tareaServicio.getTareaById(id);

        // Verificamos si la Tarea existe
        if (!tareaExistente.isPresent()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "No existe la tarea con id: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        // Si existe, la eliminamos
        tareaServicio.deleteTarea(id);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Tarea eliminada con éxito");
        return ResponseEntity.ok(response);
    }

    private ValidationErrorResponse validateTarea(Tarea tarea) {
        ValidationErrorResponse errors = new ValidationErrorResponse();

        if (tarea.getName() == null || tarea.getName().isEmpty()) {
            errors.addError("name", "El nombre no puede estar vacío");
        }
        if (tarea.getDescription() == null || tarea.getDescription().isEmpty()) {
            errors.addError("description", "La descripción no puede estar vacía");
        }
        if (tarea.getEstatus() == null) {
            errors.addError("estatus", "El estado no puede ser nulo");
        }
        if (tarea.getDate() == null || tarea.getDate().isBefore(LocalDate.now())) {
            errors.addError("date", "La fecha debe ser igual o mayor al día de hoy");
        }
        return errors.getErrors().isEmpty() ? null : errors;
    }
}
