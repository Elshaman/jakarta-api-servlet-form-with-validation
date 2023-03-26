<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@page import="java.util.List" %>
<%
  List<String> errores = (List<String>) request.getAttribute("errores");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario de usuarios</title>
</head>
<body>
  <h3>Formulario de usuarios</h3>
  <%
    if(errores!= null && errores.size() > 0){
  %>
    <ul>
      <% for(String error:errores){ %>
        <li><%=error %></li>
      <%}%>
    </ul>
  <%}%>
  <form action="/webapp-form/registro" method="post">
    <div>
      <label for="username">Username</label>
      <div><input type="text" name="username" id="username"></div>
    </div>
    <div>
      <label for="password">Password</label>
      <div><input type="password" name="password" id="password"></div>
    </div>
    <div>
      <label for="email">Email</label>
      <div><input type="text" name="email" id="email"></div>
    </div>
    <div>
      <label for="pais">Pais</label>
      <div>
        <select name="pais" id="pais">
          <option value="">Seleccionar</option>
          <option value="ES">Hispania</option>
          <option value="NG">Nueva Granada</option>
          <option value="FR">Frankia</option>
          <option value="WEX">Wessex</option>
          <option value="CORD">Califato de Cordoba</option>
        </select>
      </div>
    </div>
    <div>
      <label for="lenguajes">Lenguajes de Programacion </label>
      <div>
        <select name="lenguajes" id="lenguajes" multiple>
          <option value="java">Java</option>
          <option value="jakartaee">Jakarta EE 9</option>
          <option value="spring">Spring Boot</option>
          <option value="js">JavaScript</option>
          <option value="angular">Angular</option>
          <option value="react">React</option>
        </select>
      </div>
    </div>
    <div>
      <label>Roles</label>
      <div>
        <input type="checkbox" name="roles" value="ROLE_ADMIN">
        <label>Administrador</label>
      </div>
      <div>
        <input type="checkbox" name="roles" value="ROLE_USER">
        <label>Usuario</label>
      </div>
      <div>
        <input type="checkbox" name="roles" value="ROLE_MODERATOR">
        <label>Moderador</label>
      </div>
    </div>

    <div>
      <label>Idiomas</label>
      <div>
        <input type="radio" name="idioma" value="es">
        <label>Hispano</label>
      </div>
      <div>
        <input type="radio" name="idioma" value="en">
        <label>Ingles</label>
      </div>
      <div>
        <input type="radio" name="idioma" value="fr">
        <label>Frances</label>
      </div>
    </div>

    <div>
      <label for="habilitar">Habilitar</label>
      <div>
        <input type="checkbox" name="habilitar" id="habilitar" checked>
      </div>
    </div>

    <input type="hidden" name="secreto" value="12345">

    <div>
      <div>
        <input type="submit" value="Enviar">
      </div>
    </div>
  </form>
</body>
</html>