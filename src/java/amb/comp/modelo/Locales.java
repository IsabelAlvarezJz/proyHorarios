/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amb.comp.modelo;

import java.util.List;

/**
 *
 * @author Familia
 */
public class Locales {
    
    private String codlocal;
    private String nombreLocal;
    private String direccionLocal;
    private String telflocal;
    private List<Locales> local;

    public Locales() {
    }

    public String getCodlocal() {
        return codlocal;
    }

    public void setCodlocal(String codlocal) {
        this.codlocal = codlocal;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public String getDireccionLocal() {
        return direccionLocal;
    }

    public void setDireccionLocal(String direccionLocal) {
        this.direccionLocal = direccionLocal;
    }

    public String getTelflocal() {
        return telflocal;
    }

    public void setTelflocal(String telflocal) {
        this.telflocal = telflocal;
    }

    public List<Locales> getLocal() {
        return local;
    }

    public void setLocal(List<Locales> local) {
        this.local = local;
    }

    public Locales(String codlocal, String nombreLocal, String direccionLocal, String telflocal) {
        this.codlocal = codlocal;
        this.nombreLocal = nombreLocal;
        this.direccionLocal = direccionLocal;
        this.telflocal = telflocal;
    }

    @Override
    public String toString() {
        return "Locales{" + "codlocal=" + codlocal + ", nombreLocal=" + nombreLocal + ", direccionLocal=" + direccionLocal + ", telflocal=" + telflocal + ", local=" + local + '}';
    }

   

    
}

  
