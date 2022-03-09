/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amb.comp.modelo;

/**
 *
 * @author Familia
 */
public class Horarios {
    
    private int idHora;    
    private int entrada, salida;
    private String dia;
    private int idPersona;
    private String codigoLocal;
    
    //datos de tabla local
    private String nombreLocal, telefono, direccion;
    
    //datos de personal
    private String cedula, nombre, apellido;

    public Horarios() {
    }

    public int getIdHora() {
        return idHora;
    }

    public void setIdHora(int idHora) {
        this.idHora = idHora;
    }

    public int getEntrada() {
        return entrada;
    }

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public int getSalida() {
        return salida;
    }

    public void setSalida(int salida) {
        this.salida = salida;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getCodigoLocal() {
        return codigoLocal;
    }

    public void setCodigoLocal(String codigoLocal) {
        this.codigoLocal = codigoLocal;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    //para consultar todos 

    public Horarios(int idHora, int entrada, int salida, String dia, String nombreLocal, String telefono, String cedula, String nombre, String apellido) {
        this.idHora = idHora;
        this.entrada = entrada;
        this.salida = salida;
        this.dia = dia;
        this.nombreLocal = nombreLocal;
        this.telefono = telefono;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //consultar por id
    public Horarios(int entrada, int salida, String dia, int idPersona, String codigoLocal, String nombreLocal, String nombre, String apellido) {
        this.entrada = entrada;
        this.salida = salida;
        this.dia = dia;
        this.idPersona = idPersona;
        this.codigoLocal = codigoLocal;
        this.nombreLocal = nombreLocal;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    

    //para insertar datos a la tabla horarios
    public Horarios(int idHora, int entrada, int salida, String dia, int idPersona, String codigoLocal) {
        this.idHora = idHora;
        this.entrada = entrada;
        this.salida = salida;
        this.dia = dia;
        this.idPersona = idPersona;
        this.codigoLocal = codigoLocal;
    }

    @Override
    public String toString() {
        return "Horarios{" + "idHora=" + idHora + ", entrada=" + entrada + ", salida=" + salida + ", dia=" + dia + ", idPersona=" + idPersona + ", codigoLocal=" + codigoLocal + '}';
    }
    
    
    
}
