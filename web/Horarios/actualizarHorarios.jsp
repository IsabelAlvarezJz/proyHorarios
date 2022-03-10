<%-- 
    Document   : actualizarHorarios
    Created on : 09/03/2022, 18:42:52
    Author     : Familia
--%>
<jsp:useBean id="horario" class="amb.comp.modelo.Horarios" scope="application"/>
<jsp:useBean id="horarios" class="amb.comp.servicio.HorariosServicio" scope="application" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //request.setAttribute("idC", request.getParameter("id"));
    int id = Integer.parseInt(request.getParameter("id").toString());
    horario = horarios.consultarHorariosId(id);

%>
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
                <input type="hidden" name="id" value="<%= horario.getIdHora()%>">
                <tr>
                    <th>Entrada</th>
                    <th><input type="text" name="entrada" value="<%= horario.getEntrada()%>"></th>
                </tr>
                <tr>
                    <th>Salida</th>
                    <th><input type="text" name="salida" value="<%= horario.getSalida()%>"></th>
                </tr>
                <tr>
                    <th>Dia</th>
                    <th><input type="text" name="dia" value="<%= horario.getDia()%>"></th>
                </tr>
                <tr>
                    <th>id_persona</th>
                    <th><select name="idper" value="<%= horario.getIdPersona()%>"><option> -- Seleccione Personal --</option>
                            <%= personal.id()%>
                        </select></th>
                </tr>
                <tr>
                    <th>cod_local</th>
                    <th><select name="idL" value="<%= horario.getCodigoLocal()%>"><option> -- Seleccione Local --</option>
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
            if (request.getParameter("btnEnviar") != null) {
                horario.setEntrada(Integer.parseInt(request.getParameter("entrada")));
                horario.setSalida(Integer.parseInt(request.getParameter("salida")));
                horario.setDia(request.getParameter("dia"));
                horario.setIdPersona(Integer.parseInt(request.getParameter("idper")));
                horario.setCodigoLocal(request.getParameter("idL"));
                
                if (horarios.actualizarHorario(horario)) {
                    out.print("Datos actualizados correctamente");
                } else {
                    out.print("No fue posible actualizar datos");
                    out.print(horario);
                }
            }
        %>
    </body>
</html>
