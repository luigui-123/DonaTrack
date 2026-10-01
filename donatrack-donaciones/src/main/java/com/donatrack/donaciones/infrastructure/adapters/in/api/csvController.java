package com.donatrack.donaciones.infrastructure.adapters.in.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.donatrack.donaciones.application.service.csvService;

@RestController
@RequestMapping("/api/csv")
public class csvController {

    private  csvService csvService;

    public csvController(csvService csvService) {
        this.csvService = csvService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> subirArchivoCsv(@RequestParam("file") MultipartFile file) {
        // Validar si el archivo está vacío
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Por favor, sube un archivo CSV válido.");
        }

        try {
            // Llamar al servicio para procesar el archivo
            csvService.procesarCsv(file);
            return ResponseEntity.status(HttpStatus.OK).body("¡Archivo procesado correctamente!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al procesar el archivo: " + e.getMessage());
        }
    }
}

