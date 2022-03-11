<%-- 
    Document   : consultarHorarios
    Created on : 09/03/2022, 17:03:58
    Author     : Familia
--%>
<%@page import="amb.comp.modelo.Locales"%>
<%@page import="java.util.List"%>
<jsp:useBean id="local" class="amb.comp.servicio.LocalesServicio" scope="application"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Insertar Locales</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>codlocal</th>
                    <th>nombrelocal</th>
                    <th>Dirección Local</th> 
                    <th>Teléfono Local</th>                     
                    <th>Editar</th>
                    <td>Eliminar</td>
                </tr>
            </thead>
            <%

                List<Locales> listaLocales = local.buscarLocales();
                for (Locales temp : listaLocales) {
                    //request.setAttribute("id", temp.getId());
                    String id = temp.getCodlocal();

                    out.println("<tr>");
                    out.println("<td>" + temp.getCodlocal() + "</td>");
                    out.println("<td>" + temp.getNombreLocal() + "</td>");
                    out.println("<td>" + temp.getDireccionLocal() + "</td>");
                    out.println("<td>" + temp.getTelflocal() + "</td>");
            %>
            <td>
                <a href="actualizarLocales.jsp?id=<%= temp.getCodlocal() %>">Editar</a>
            </td>
            <td>
                <a href="eliminarLocales.jsp?codLocal=<%= temp.getCodlocal() %>"
                   onclick="return confirm('Seguro que desea eliminar el registro?')">Eliminar</a>
            </td>
            
            <%
                    out.println("</tr>");
                }
            %>
        </table>
    </body>
</html>
