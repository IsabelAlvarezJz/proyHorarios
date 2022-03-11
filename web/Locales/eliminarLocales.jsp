<%-- 
    Document   : eliminarLocales
    Created on : 09/03/2022, 18:24:58
    Author     : Familia
--%>

<jsp:useBean id="locales" class="amb.comp.servicio.LocalesServicio" scope="application"/>
<%
    //request.setAttribute("idC", request.getParameter("id"));
    request.setAttribute("id", request.getParameter("codLocal"));
    String id = String.valueOf( request.getAttribute("id"));
    locales.eliminarLocales(id);
    
%>
<jsp:forward page="consultarLocales.jsp" />