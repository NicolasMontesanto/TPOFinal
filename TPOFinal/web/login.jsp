<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="assets/css/login.css">
        <title>Agencia Turismo</title>
    </head>
<div class="login-page">
  <div class="form">
    <form class="login-form" action="SvUsuario" method="post">
      <input type="text" placeholder="Nombre de Usuario" name="nombreUsuario"/>
      <input type="password" placeholder="contraseña" name="contrasenia"/>
      <button type="submit">login</button>
    </form>
  </div>
</div>
</html>
