/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amb.comp.servicio;

import amb.comp.dao.LocalesMetodos;
import amb.comp.modelo.Locales;
import java.util.List;

/**
 *
 * @author Familia
 */
public class LocalesServicio {
    
    public List<Locales> buscarLocales() {
        return new LocalesMetodos().buscarLocales();
    }
    
    public String id() {
        return new LocalesMetodos().id();
    }
    
    public Locales buscarPorId(String codlocal) {
        return new LocalesMetodos().buscarPorId(codlocal);
    }
  
    public boolean insertarLocales(Locales local) {
        return new LocalesMetodos().insertarLocales(local);
    }  
    
    public boolean actualizarLocales(Locales local) {
         return new LocalesMetodos().actualizarLocales(local);
    }
   
    public boolean eliminarLocales(String identificador) {
         return new LocalesMetodos().eliminarLocales(identificador);
    }
}
