<%-- 
    Document   : eliminarHorarios
    Created on : 09/03/2022, 19:05:56
    Author     : Familia
--%>
<jsp:useBean id="horarios" class="amb.comp.servicio.HorariosServicio" scope="application"/>
<%
    request.setAttribute("id", request.getParameter("idHora"));
    int id = Integer.parseInt((String) request.getAttribute("id"));
    horarios.eliminarHorarios(id);
    
%>
<jsp:forward page="consultarHorarios.jsp" />
