<%-- 
    Document   : actualizarLocales
    Created on : 09/03/2022, 18:14:47
    Author     : Familia
--%>
<jsp:useBean id="locales" class="amb.comp.modelo.Locales" scope="application"/>

<jsp:useBean id="local" class="amb.comp.servicio.LocalesServicio" scope="application" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //request.setAttribute("idC", request.getParameter("id"));
    String id = request.getParameter("id").toString();
    locales = local.buscarPorId(id);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% out.println("<h1> Datos del Local " + locales.getNombreLocal() + "</h1>");%>

        <form method="POST">
            <table>
                <tr>
                    <th></th>
                    <th><input type="text" name="codL" value="<%= locales.getCodlocal()%>" hidden></th>
                </tr>
                <tr>
                    <th>nombre local</th>
                    <th><input type="text" name="nomL" value="<%= locales.getNombreLocal()%>"></th>
                </tr>
                <tr>
                    <th>Dirección local</th>
                    <th><input type="text" name="dirL" value="<%= locales.getDireccionLocal()%>"></th>
                </tr>
                <tr>
                    <th>Teléfono local</th>
                    <th><input type="text" name="telfL" value="<%= locales.getTelflocal()%>"></th>
                </tr>
                <tr>
                    <td><input type="submit" name="btnEnviar" value="Ingreso">
                        <br><br><a href="../index.jsp"> Regreso al menú</a>
                    </td>
                </tr>                
            </table>
        </form>
        <%
            if (request.getParameter("btnEnviar") != null) {
                locales.setCodlocal(request.getParameter("codL"));
                locales.setNombreLocal(request.getParameter("nomL"));
                locales.setDireccionLocal(request.getParameter("dirL"));
                locales.setTelflocal(request.getParameter("telfL"));
                
                if (local.actualizarLocales(locales)) {
                    out.print("Datos actualizados correctamente");
                    out.print(locales);
                } else {
                    out.print("No fue posible actualizar datos");
                    out.print(locales);
                }
            }
        %>
    </body>
</html>