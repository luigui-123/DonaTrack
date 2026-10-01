package com.donatrack.donaciones.application.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.donatrack.donaciones.application.dto.in.CSVrequest;
import com.donatrack.donaciones.domain.model.Contacto;
import com.donatrack.donaciones.domain.model.DocumentoIdentidad;
import com.donatrack.donaciones.domain.model.Donante;
import com.donatrack.donaciones.domain.model.TipoDocumento;
import com.donatrack.donaciones.domain.service.DonanteFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Service
public class csvService {
    private DonanteService donanteService;
    public csvService(DonanteService donanteService){
        this.donanteService=donanteService;
    } 

    public void procesarCsv(MultipartFile file) {
        DonanteFactory donanteFactory = new DonanteFactory();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            
            String linea;
            boolean esPrimeraLinea = true; // Para saltar el encabezado si lo tiene
            CSVrequest cVrequest = new CSVrequest();

            while ((linea = reader.readLine()) != null) {
                if (esPrimeraLinea) {
                    esPrimeraLinea = false;
                    continue; // Salta la cabecera (nombre de las columnas)
                }

                // Separar los valores por coma
                String[] datos = linea.split(",");
                
                cVrequest.setTipoPersona(datos[0]);
                cVrequest.setTipoDocumento(datos[1]);
                cVrequest.setDocumento(datos[2]);
                cVrequest.setNombre(datos[3]);
                cVrequest.setEmail(datos[4]);
                cVrequest.setTelefono(datos[5]);

                // Aquí guardas los datos en tu base de datos o realizas la lógica necesaria
                Donante donante = donanteService.buscarPorDocumento(new DocumentoIdentidad (TipoDocumento.valueOf(datos[1]),datos[2]));
                if(donante != null){
                    donante.actulizarInformacion(datos[3], datos[4], datos[5]);
                    donanteService.update(donante.getIdPersona(), null,new Contacto(datos[4],datos[5],null,null));
                    
                }else{
                    donanteService.create(donanteFactory.crearDonante(cVrequest));
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Fallo al leer el archivo CSV: " + e.getMessage());
        }
    }
}

