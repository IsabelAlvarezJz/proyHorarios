<%-- 
    Document   : ConsultarCliente
    Created on : 03-mar-2022, 11:14:21
    Author     : Isabel
--%>
<jsp:useBean id="personal" class="amb.comp.servicio.ClienteServicio" scope="application"/>

<%@page import="amb.comp.modelo.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Cédula</th> 
                    <th>Nombres</th> 
                    <th>Dirección</th> 
                    <th>Teléfono</th> 
                    <th>Correo</th> 
                    <th>Fecha Nacimiento</th> 
                    <th>Edad</th> 
                    <th>Salario</th> 
                </tr>
            </thead>
            <%
                List<Cliente> listaClientes = personal.buscarClientes();
                for (Cliente temp : listaClientes) {
                    out.println("<tr>");
                    out.println("<td>" + temp.getCedula() + "</td>");
                    out.println("<td>" + temp.getApellido() + " " + temp.getNombre() + "</td>");
                    out.println("<td>" + temp.getDireccion() + "</td>");
                    out.println("<td>" + temp.getTelefono() + "</td>");
                    out.println("<td>" + temp.getCorreo() + "</td>");
                    out.println("<td>" + temp.getFecha() + "</td>"); // VER SI HAY Q DAR FORMATO
                    out.println("<td> EDAD </td>"); // fecha sistema - fecha nacimiento
                    out.println("<td>" + temp.getSalario() + "</td>");
                    out.println("</tr>");
                }
            %>
        </table>
    </body>
</html>
