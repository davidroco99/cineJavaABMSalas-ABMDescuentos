
package com.programacion2.cine.persistencia;

import com.programacion2.cine.logica.Descuento;
import com.programacion2.cine.logica.Sala;
import com.programacion2.cine.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DavidRoco
 */
public class ControladoraPersistencia {
    private static ControladoraPersistencia instance = null;
     SalaJpaController salaJPA = new SalaJpaController();
     DescuentoJpaController descuentoJPA = new DescuentoJpaController();
    
    public ControladoraPersistencia() {
    }
    public static ControladoraPersistencia getInstance() {
        if (instance == null) {
            instance = new ControladoraPersistencia();
        }
        return instance;
    }

    public void guardarSala(Sala sala) {
        salaJPA.create(sala);
        
    }

    public List<Sala> buscarSalas() {
        List <Sala> listaSalas = salaJPA.findSalaEntities();
        return listaSalas;
    }

    public void borrarSala(int nroSala) {
        try {
            salaJPA.destroy(nroSala);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Sala buscar(int nroSala) {
        return salaJPA.findSala(nroSala);
    }

    public void editarSala(Sala sala) {
        try {
            salaJPA.edit(sala);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarDescuento(Descuento descuento) {
       descuentoJPA.create(descuento);
    }

    public List<Descuento> buscarDescuentos() {
       List <Descuento> listaDescuentos = descuentoJPA.findDescuentoEntities();
       return listaDescuentos;
    }

    public Descuento buscarDescuento(int nroDescuento) {
       return descuentoJPA.findDescuento(nroDescuento);
    }

    public void editarDescuento(Descuento descuento) throws Exception {
       try {
        descuentoJPA.edit(descuento);
         } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarDescuento(int nroDescuento) {
        try {
            descuentoJPA.destroy(nroDescuento);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}
