package com.tarea;

import com.tarea.controllers.TareaControlador;
import com.tarea.entities.Tarea;
import com.tarea.services.TareaServicio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class Application {
	private static final String ARCHIVO_JSON = "tareas.json";
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);



	}

}
