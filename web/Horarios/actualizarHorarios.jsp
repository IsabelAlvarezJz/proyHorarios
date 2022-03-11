<%-- 
    Document   : actualizarHorarios
    Created on : 09/03/2022, 18:42:52
    Author     : Familia
--%>
<%@page import="amb.comp.modelo.Locales"%>
<%@page import="amb.comp.modelo.Cliente"%>
<%@page import="java.util.List"%>
<jsp:useBean id="horario" class="amb.comp.modelo.Horarios" scope="application"/>
<jsp:useBean id="horarios" class="amb.comp.servicio.HorariosServicio" scope="application" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //request.setAttribute("idC", request.getParameter("id"));
    int id = Integer.parseInt(request.getParameter("id").toString());
    horario = horarios.consultarHorariosId(id);
    out.println(horario);

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Horarios</title>
    </head>
    <body>
        <jsp:useBean id="personal" class="amb.comp.servicio.ClienteServicio" scope="application" />
        <jsp:useBean id="local" class="amb.comp.servicio.LocalesServicio" scope="application" />
        <% List<Cliente> listaCliente = personal.buscarClientes();
            List<Locales> listaLocales = local.buscarLocales();
            String dias[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
        %>
        <h1>Actualizar Horarios</h1>        
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
                    <th>
                        <select name="dia">
                            <% for (int dia = 0; dia < dias.length; dia++) {%>                            
                            <option value="<%= dias[dia]%>"
                                    <%
                                        if (dias[dia].equals(horario.getDia())) {
                                            out.println("selected='selected'");
                                        }
                                    %>                                    
                                    ><%= dias[dia]%></option>
                            <% } %>
                        </select>
                    </th>
                </tr>
                <tr>
                    <th>id_persona</th>
                    <th><select name="idper" >
                            <% for (Cliente cliente : listaCliente) {%>
                            <option value="<%= cliente.getId()%>"
                                    <%
                                        if (cliente.getId() == horario.getIdPersona()) {
                                            out.println("selected='selected'");
                                        }
                                    %>
                                    ><%= cliente.getNombre() + " " + cliente.getApellido()%></option>
                            <% } %>
                        </select>
                    </th>
                </tr>
                <tr>
                    <th>cod_local</th>
                    <th><select name="idL">
                            <% for (Locales locales : listaLocales) {%>
                            <option value="<%= locales.getCodlocal()%>"
                                <%
                                    if (locales.getCodlocal().equals(horario.getCodigoLocal())) {
                                        out.println("selected='selected'");
                                    }
                                %>
                            ><%= locales.getNombreLocal()%></option>
                            <% } %>
                        </select>
                    </th>
                </tr>
                <tr>
                    <td><input type="submit" name="btnEnviar" value="Actualizar">
                        <br><br><a href="consultarHorarios.jsp"> Regreso al menú</a>
                    </td>
                </tr>
            </table>
        </form>
        <%
            if (request.getParameter("btnEnviar") != null) {
                horario.setIdHora(Integer.parseInt(request.getParameter("id")));
                horario.setEntrada(Integer.parseInt(request.getParameter("entrada")));
                horario.setSalida(Integer.parseInt(request.getParameter("salida")));
                horario.setDia(request.getParameter("dia"));
                horario.setIdPersona(Integer.parseInt(request.getParameter("idper")));
                horario.setCodigoLocal(request.getParameter("idL"));

                if (horarios.actualizarHorario(horario)) {
                    out.print("Datos actualizados correctamente");
                    out.print(horario);
                } else {
                    out.print("No fue posible actualizar datos");
                    out.print(horario);
                }
            }
        %>
    </body>
</html>
