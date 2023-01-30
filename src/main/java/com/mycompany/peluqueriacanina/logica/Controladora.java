
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

    public void borrarMascota(int num_cliente) {
       controlPersis.borrarMascota(num_cliente);
    }

    public Mascota traerMascota(int num_cliente) {
      return controlPersis.traerMascota(num_cliente); 
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, String observaciones, String nombreDuenio, String celDuenio, String alergico, String atEsp) {
       masco.setNombre(nombreMasco);
       masco.setRaza(raza);
       masco.setColor(color);
       masco.setObservaciones(observaciones);
       masco.setAtencion_especial(atEsp);
       masco.setAlergico(alergico);
       //modifico valores de mascota
       controlPersis.modificarMascota(masco);
       //seteo nuevo valores para el duenio
       Duenio duenio = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
       duenio.setCelDuenio(celDuenio);
       duenio.setNombre(nombreDuenio);
       
       //llamar al modificar dueño
       
       this.modificarDuenio(duenio);
    }

    private Duenio buscarDuenio(int id_duenio) {
       return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
       controlPersis.modificarDuenio(duenio)
;    }

   
}
