<%-- 
    Document   : eliminarLocales
    Created on : 09/03/2022, 18:24:58
    Author     : Familia
--%>

<jsp:useBean id="loca" class="amb.comp.servicio.LocalesServicio" scope="application"/>
<%
    request.setAttribute("id", request.getParameter("codlocal"));
    String id = ((String) request.getAttribute("id"));
    loca.eliminarLocales(id);
    
%>
<jsp:forward page="consultarLocales.jsp" />