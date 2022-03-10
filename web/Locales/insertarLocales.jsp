<%-- 
    Document   : insertarLocales
    Created on : 09/03/2022, 18:04:43
    Author     : Familia
--%>
<%@page import="amb.comp.modelo.Locales"%>
<jsp:useBean id="locale" class="amb.comp.servicio.LocalesServicio" scope="application" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form>
            <table>
                <tr>
                    <th>Codigo Local</th>
                    <th><input type="text" name="codL"></th>
                </tr>
                <tr>
                    <th>nombre local</th>
                    <th><input type="text" name="nomL"></th>
                </tr>
                <tr>
                    <th>Dirección local</th>
                    <th><input type="text" name="dirL"></th>
                </tr>
                <tr>
                    <th>Teléfono local</th>
                    <th><input type="text" name="telfL"></th>
                </tr>
                <tr>
                    <td><input type="submit" name="btnEnviar" value="Ingreso">
                        <br><br><a href="../index.jsp"> Regreso al menú</a>
                    </td>
                </tr>                
            </table>
        </form>
        <%
            Locales local = new Locales();

            if (request.getParameter("btnEnviar") != null) {
                local.setCodlocal(request.getParameter("codL"));
                local.setNombreLocal(request.getParameter("nomL"));
                local.setDireccionLocal(request.getParameter("dirL"));
                local.setTelflocal(request.getParameter("telfL"));

                //out.print(local)
                if (locale.insertarLocales(local)) {
                    out.print("Datos insertados correctamente");
                    out.print(local);
                } else {
                    out.print("No fue posible insertar datos");
                    out.print(local);
                }
            }
        %>

    </body>
</html>
