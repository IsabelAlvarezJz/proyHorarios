/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amb.comp.dao;

import amb.comp.modelo.Locales;
import java.util.List;

/**
 *
 * @author Familia
 */
public interface ILocales {
    //TODOS LOS METODOS NECESARIOS PARA EL CRUD
    public List<Locales> buscarLocales();
    public Locales buscarPorId(String codLocal);
    public boolean insertarLocales(Locales local);
    public boolean actualizarLocales(Locales local);
    public boolean eliminarLocales(String identificador);
}
