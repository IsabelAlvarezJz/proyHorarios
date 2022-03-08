<%-- 
    Document   : eliminarCliente
    Created on : 08/03/2022, 10:57:06
    Author     : Familia
--%>
<jsp:useBean id="personal" class="amb.comp.servicio.ClienteServicio" scope="application"/>
<%
    request.setAttribute("id", request.getParameter("idCliente"));
    int id = Integer.parseInt((String) request.getAttribute("id"));
    personal.eliminarCliente(id);

%>
<jsp:forward page="consultarCliente.jsp" />
