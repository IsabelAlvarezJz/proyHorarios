<%-- 
    Document   : consultarHorarios
    Created on : 09/03/2022, 14:49:06
    Author     : Familia
--%>

<%@page import="java.util.List"%>
<jsp:useBean id="horarios" class="amb.comp.servicio.HorariosServicio" scope="application"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="amb.comp.modelo.Horarios"%>
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
                    <th>#</th>
                    <th>Entrada</th> 
                    <th>Salida</th> 
                    <th>Día</th> 
                    <th>Nombre del Local</th> 
                    <th>Telefono del Local</th> 
                    <th>Cedula</th> 
                    <th>Nombre</th> 
                    <th>Apellido</th> 
                    <th>Editar</th>
                    <td>Eliminar</td>
                </tr>
            </thead>

            <%

                List<Horarios> listaHorarios = horarios.consultarHorarios();
                for (Horarios temp : listaHorarios) {
                    //request.setAttribute("id", temp.getId());
                    int id = temp.getIdHora();

                    out.println("<tr>");
                    out.println("<td>" + temp.getIdHora() + "</td>");
                    out.println("<td>" + temp.getEntrada() + "</td>");
                    out.println("<td>" + temp.getSalida() +"</td>");
                    out.println("<td>" + temp.getDia() + "</td>");
                    out.println("<td>" + temp.getNombreLocal() + "</td>");
                    out.println("<td>" + temp.getTelefono() + "</td>");
                    out.println("<td>" + temp.getCedula() + "</td>"); // VER SI HAY Q DAR FORMATO
                    out.println("<td>" + temp.getNombre() + "</td>");
                    out.println("<td>" + temp.getApellido() + "</td>");

            %>
            <td>
                <a href="actualizarHorarios.jsp?id=<%= temp.getIdHora() %>">Editar</a>
            </td>
            <td>
                <a href="eliminarHorarios.jsp?idHora=<%= temp.getIdHora() %>"
                   onclick="return confirm('Seguro que desea eliminar el registro?')">Eliminar</a>
            </td>
            
            <%
                    out.println("</tr>");
                }
            %>

        </table>
    </body>
</html>
