<!DOCTYPE html>
<html lang="es">
<head>
  <title>Inicio mi web</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>


<div class="container mt-3">  
<h1 class="text-primary">Bienvenido  ${sessionScope.username}</h1>

<%
HttpSession misesion = request.getSession();
//colocar variables en la sesión

//obtener variables de la sesión
//guarda todo como Object, el casteo es obligatorio
String nombreusuario = (String) misesion.getAttribute	("username"); 
out.println("Tu nombre de usuario es:"+nombreusuario);

%>

  
 </div>
 
   
 

</body>
</html>
