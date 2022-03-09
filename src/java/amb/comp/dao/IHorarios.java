/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amb.comp.dao;

import amb.comp.modelo.Horarios;
import java.util.List;

/**
 *
 * @author Familia
 */
public interface IHorarios {
    
    public List<Horarios> consultarHorarios();
    public Horarios consultarHorariosId(int idHora);
    public boolean insertarHorario(Horarios horarios);
    public boolean actualizarHorario(Horarios horarios);
    public boolean eliminarHorarios(int idHora);
    
}
