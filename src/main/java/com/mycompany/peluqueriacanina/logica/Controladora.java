
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones, String nombreDuenio, 
                                    String celDuenio, String alergico, String atEsp) {
        
        Duenio duenio = new Duenio();
        
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        
        Mascota masco = new Mascota();
        
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atEsp);    
       masco.setUnDuenio(duenio);
       masco.setObservaciones(observaciones);
       
       controlPersis.guardar(duenio, masco);
    }

    public List<Mascota> traerMascotas() {
       return controlPersis.traerDatos();
    }
}
