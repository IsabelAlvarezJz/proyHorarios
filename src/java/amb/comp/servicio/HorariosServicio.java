/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amb.comp.servicio;

import amb.comp.dao.HorariosMetodos;
import amb.comp.modelo.Horarios;
import java.util.List;

/**
 *
 * @author Familia
 */
public class HorariosServicio {
    
    
    public List<Horarios> consultarHorarios() {
        return new HorariosMetodos().consultarHorarios();
    }

    
    public Horarios consultarHorariosId(int idHora) {
        return new HorariosMetodos().consultarHorariosId(idHora);
    }

    
    public boolean insertarHorario(Horarios horarios) {
        return new HorariosMetodos().insertarHorario(horarios);
    }

    
    public boolean actualizarHorario(Horarios horarios) {
        return new HorariosMetodos().actualizarHorario(horarios);
    }

    
    public boolean eliminarHorarios(int idHora) {
        return new HorariosMetodos().eliminarHorarios(idHora);
    }
    
}
