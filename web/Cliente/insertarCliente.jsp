<%-- 
    Document   : insertarCliente
    Created on : 7 mar. 2022, 10:44:29
    Author     : Oskar
--%>
<%@page import="java.util.Date"%>
<%@page import="amb.comp.modelo.Cliente"%>
<%@page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="personal" class="amb.comp.servicio.ClienteServicio" scope="application" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso Cliente</title>
    </head>
    <body>
        <h1>Ingreso Cliente</h1>
        <form method="POST" >
            <table>
                <tr>
                    <th>Cédula</th>
                    <th><input type="text" name="cedula"></th>
                </tr>
                <tr>
                    <th>Nombres</th>
                    <th><input type="text" name="nombre"></th>
                </tr>
                <tr>
                    <th>Apellidos</th>
                    <th><input type="text" name="apellido"></th>
                </tr>
                <tr>
                    <th>Teléfono</th>
                    <th><input type="text" name="fono"></th>
                </tr>
                <tr>
                   <th>Correo</th>
                    <th><input type="text" name="correo"></th>
                </tr>
                <tr>
                    <th>Fecha nacimiento</th>
                    <th><input type="date" name="fecha"></th>
                </tr>
                <tr>
                    <th>Salario</th>
                    <th><input type="text" name="salario"></th>
                </tr>
                <tr>
                    <th>Dirección</th>
                    <th><textarea name="direccion"></textarea></th>
                </tr>
                <tr>
                    <td><input type="submit" name="btnEnviar" value="Ingreso">
                <br><br><a href="../index.jsp"> Regreso al menú</a>
                </td>
                </tr>
            </table>
        </form>
        <%
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Cliente cliente = new Cliente();
            
            if(request.getParameter("btnEnviar") != null){
                cliente.setCedula(request.getParameter("cedula"));
                cliente.setNombre(request.getParameter("nombre"));
                cliente.setApellido(request.getParameter("apellido"));
                cliente.setCorreo(request.getParameter("correo"));
                cliente.setTelefono(request.getParameter("fono"));
                Date fecha = sdf.parse(request.getParameter("fecha"));
                cliente.setFecha(fecha);
                cliente.setSalario(Double.parseDouble(request.getParameter("salario")));
                cliente.setDireccion(request.getParameter("direccion"));
                //out.print(cliente)
                if(personal.insertarCliente(cliente)){
                out.print("Datos insertados correctamente");
                out.print(cliente);
            }else{
                out.print("No fue posible insertar datos");
                out.print(cliente);
            }
            }
        %>
        
    </body>
</html>
