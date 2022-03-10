<%-- 
    Document   : insertarHorarios
    Created on : 09/03/2022, 15:54:44
    Author     : Familia
--%>
<%@page import="amb.comp.modelo.Horarios"%>
<%@page import="amb.comp.modelo.Locales"%>
<jsp:useBean id="horarios" class="amb.comp.servicio.HorariosServicio" scope="application" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>


    </head>
    <body>
        <jsp:useBean id="personal" class="amb.comp.servicio.ClienteServicio" scope="application" />
        <jsp:useBean id="local" class="amb.comp.servicio.LocalesServicio" scope="application" />

        <h1>Insertar Horarios</h1>        
        <form method="POST" >
            <table>
                <tr>
                    <th>Entrada</th>
                    <th><input type="text" name="entrada"></th>
                </tr>
                <tr>
                    <th>Salida</th>
                    <th><input type="text" name="salida"></th>
                </tr>
                <tr>
                    <th>Dia</th>
                    <th><input type="text" name="dia"></th>
                </tr>
                <tr>
                    <th>id_persona</th>
                    <th><select name="idper" ><option> -- Seleccione Personal --</option>
                            <%= personal.id()%>
                        </select></th>
                </tr>
                <tr>
                    <th>cod_local</th>
                    <th><select name="idL"><option> -- Seleccione Local --</option>
                            <%= local.id()%>
                        </select></th>
                </tr>
                <tr>
                    <td><input type="submit" name="btnEnviar" value="Ingreso">
                        <br><br><a href="../index.jsp"> Regreso al menú</a>
                    </td>
                </tr>
            </table>
        </form>
        <%
            Horarios horar = new Horarios();

            if (request.getParameter("btnEnviar") != null) {
                horar.setEntrada(Integer.parseInt(request.getParameter("entrada")));
                horar.setSalida(Integer.parseInt(request.getParameter("salida")));
                horar.setDia(request.getParameter("dia"));
                //horar.setIdPersona(Integer.parseInt(request.getParameter("idper")));
                //horar.setCodigoLocal(request.getParameter("idL"));
                
                if (horarios.insertarHorario(horar)) {
                    out.print("Datos insertados correctamente");
                    out.print(horar);
                } else {
                    out.print("No fue posible insertar datos");
                    out.print(horar);
                }
            }
        %>
    </body>
</html>
