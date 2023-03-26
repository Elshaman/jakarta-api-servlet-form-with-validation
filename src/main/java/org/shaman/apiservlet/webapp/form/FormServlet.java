package org.shaman.apiservlet.webapp.form;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "FormServlet", value = "/registro")
public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String pais = request.getParameter("pais");
        String[] lenguajes = request.getParameterValues("lenguajes");
        String[] roles = request.getParameterValues("roles");


        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>Resultado form</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <h1>resultado form!</h1>");
            out.println("        <ul>");
            out.println("               <li>Username" + username + "</li>");
            out.println("               <li>Password" + password + "</li>");
            out.println("               <li>Email" + email + "</li>");
            out.println("               <li>Email" + pais + "</li>");
            out.println("               <li>Lenguajes:<ul>");
            Arrays.asList(lenguajes).forEach(lenguaje -> {
                out.println("           <li>" + lenguaje + "</li>");
            });
            out.println("               </ul></li>");
            out.println("               <li>Roles:<ul>");
            Arrays.asList(roles).forEach(role -> {
                out.println("           <li>" + role + "</li>");
            });
            out.println("        </ul>");
            out.println("    </body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String pais = request.getParameter("pais");
        String[] lenguajes = request.getParameterValues("lenguajes");
        String[] roles = request.getParameterValues("roles");
        String idioma = request.getParameter("idioma");
        boolean habilitar = request.getParameter("habilitar") != null && request.getParameter("habilitar").equals("on");
        String secreto = request.getParameter("secreto");


        /* validacion*/

        List<String> errores = new ArrayList<String>();
        if (username == null || username.isBlank()) {
            errores.add("el username es requerido");
        }
        if (password == null || password.isBlank()) {
            errores.add("el password es requerido");
        }
        if (email == null || !email.contains("@")) {
            errores.add("el email es requerido y tener formato de correo");
        }
        if (pais == null || pais.equals("")) {
            errores.add("el pais es requerido");
        }
        if (lenguajes == null || lenguajes.length == 0) {
            errores.add("debe seleccionar al menos un lenguaje de programacion");
        }
        if (roles == null || roles.length == 0) {
            errores.add("debe seleccionar al menos un rol");
        }
        if (idioma == null) {
            errores.add("debe seleccionar al menos un idioma");
        }

        if (errores.isEmpty()) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title>Resultado form</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>resultado form!</h1>");
                out.println("        <ul>");
                out.println("               <li>Username" + username + "</li>");
                out.println("               <li>Password" + password + "</li>");
                out.println("               <li>Email" + email + "</li>");
                out.println("               <li>Pais    " + pais + "</li>");
                out.println("               <li>Lenguajes:<ul>");
                Arrays.asList(lenguajes).forEach(lenguaje -> {
                    out.println("           <li>" + lenguaje + "</li>");
                });
                out.println("               </ul></li>");
                out.println("               <li>Roles:<ul>");
                Arrays.asList(roles).forEach(role -> {
                    out.println("           <li>" + role + "</li>");
                });
                out.println("        </ul></li>");
                out.println("               <li>Idioma " + idioma + "</li>");
                out.println("               <li>secreto " + secreto + "</li>");
                out.println("               <li>Idioma " + habilitar + "</li>");
                out.println("       </ul>");
                out.println("    </body>");
                out.println("</html>");
            }
        } else {
                /*
                errores.forEach(error->{
                    out.println("<li>" + error + "</li>");
                });
                out.println("<p><a href=\"/webapp-form\">volver</a></p>" );*/
            request.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
