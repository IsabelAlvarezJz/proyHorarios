<%-- 
    Document   : consultarHorarios
    Created on : 09/03/2022, 17:03:58
    Author     : Familia
--%>
<%@page import="amb.comp.modelo.Locales"%>
<%@page import="java.util.List"%>
<jsp:useBean id="local" class="amb.comp.servicio.LocalesServicio" scope="application"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </head>
    <body>
        <h1>Insertar Locales</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>codlocal</th>
                    <th>nombrelocal</th>
                    <th>Dirección Local</th> 
                    <th>Teléfono Local</th>                     
                    <th>Editar</th>
                    <td>Eliminar</td>
                </tr>
            </thead>
            <%

                List<Locales> listaLocales = local.buscarLocales();
                for (Locales temp : listaLocales) {
                    //request.setAttribute("id", temp.getId());
                    String id = temp.getCodlocal();

                    out.println("<tr>");
                    out.println("<td>" + temp.getCodlocal() + "</td>");
                    out.println("<td>" + temp.getNombreLocal() + "</td>");
                    out.println("<td>" + temp.getDireccionLocal() + "</td>");
                    out.println("<td>" + temp.getTelflocal() + "</td>");

                    //IMPLEMENTAR ENLACES PARA EDITAR Y ELIMINAR
                    String url = "<td><a href='./actualizarLocales.jsp?id=" + temp.getCodlocal() + "'>Editar</a></td>";
                    out.print(url);

                    String urlEliminar = "<td><button onclick='myFunction(" + temp.getCodlocal() + ")'>Eliminar</button></td>";
                    out.println(urlEliminar);

                    out.println("</tr>");
                }

            %>
        </table>
        <script>
            function myFunction(id) {
                swal({
                    title: "Seguro que desea eliminar el Local?",
                    text: "Una vez que se elimine el Local, no podras recuperar la información!",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true,
                })
                        .then((willDelete) => {
                            if (willDelete) {
                                parent.location.href = "./eliminarLocales.jsp?codLocal=" + id;
                                swal("Local eliminado!", {
                                    icon: "success",
                                });
                            } else {
                                swal("Local no eliminado!", {
                                    icon: "error",
                                });
                            }
                        });
            }
        </script>
    </body>
</html>
