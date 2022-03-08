<%-- 
    Document   : insertarCliente
    Created on : 7 mar. 2022, 10:44:29
    Author     : Oskar
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<jsp:useBean id="persona" class="amb.comp.modelo.Cliente" scope="application"/>

<jsp:useBean id="personal" class="amb.comp.servicio.ClienteServicio" scope="application" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    //request.setAttribute("idC", request.getParameter("id"));
    int id = Integer.parseInt(request.getParameter("id").toString());
    persona = personal.buscarPorId(id);
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso Cliente</title>
    </head>
    <body>
        <% out.println("<h1> Datos del cliente " + persona.getNombre() + " " + persona.getApellido() + "</h1>");%>
        <form method="POST" >
            <table>
                <input type="hidden" name="id" value="<%= persona.getId()%>">
                <tr>
                    <th>Cédula</th>
                    <th><input type="text" name="cedula" value="<%= persona.getCedula()%>"></th>
                </tr>
                <tr>
                    <th>Nombres</th>
                    <th><input type="text" name="nombre" value="<%= persona.getNombre()%>"></th>
                </tr>
                <tr>
                    <th>Apellidos</th>
                    <th><input type="text" name="apellido" value="<%= persona.getApellido()%>"></th>
                </tr>
                <tr>
                    <th>Teléfono</th>
                    <th><input type="text" name="fono" value="<%= persona.getTelefono()%>"></th>
                </tr>
                <tr>
                    <th>Correo</th>
                    <th><input type="text" name="correo" value="<%= persona.getCorreo()%>"></th>
                </tr>
                <tr>
                    <th>Fecha nacimiento</th>
                    <th><input type="date" name="fecha" value="<%= persona.getFecha()%>"></th>
                </tr>
                <tr>
                    <th>Salario</th>
                    <th><input type="text" name="salario" value="<%= persona.getSalario()%>"></th>
                </tr>
                <tr>
                    <th>Dirección</th>
                    <th><input type="text" name="direccion" value="<%= persona.getDireccion()%>"></th>
                </tr>
                <tr>
                    <td><input type="submit" name="btnEnviar" value="Actualizar">
                        <br><br><a href="../index.jsp"> Regreso al menú</a>
                    </td>
                </tr>
            </table>
        </form>
        <%
            if (request.getParameter("btnEnviar") != null) {
                persona.setCedula(request.getParameter("cedula"));
                persona.setNombre(request.getParameter("nombre"));
                persona.setApellido(request.getParameter("apellido"));
                persona.setCorreo(request.getParameter("correo"));
                persona.setTelefono(request.getParameter("fono"));
                //Date fecha = formatoFecha.parse(request.getParameter("fecha"));
                Date fecha = formatoFecha.parse(request.getParameter("fecha"));
                persona.setFecha(fecha);
                double sala = Double.valueOf(request.getParameter("salario"));
                persona.setSalario(sala);
                persona.setDireccion(request.getParameter("direccion"));

                if (personal.actualizarCliente(persona)) {
                    out.print("Datos actualizados correctamente");
                } else {
                    out.print("No fue posible actualizar datos");
                    out.print(persona);
                }
            }
        %>

    </body>
</html>