<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Insert Data</title>
</head>
<body>
<form action="./InsertData" method="post">
  <p>ID:</p>
  <input type="text" name="id"/>
  <br/>
  <p>Nombre:</p>
  <input type="text" name="nombre"/>
  <br/>
  <p>Edad:</p>
  <input type="text" name="edad"/>
  <br/>
  <p>Ciudad:</p>
  <input type="text" name="ciudad"/>
  <br/>
  <p>Cédula:</p>
  <input type="text" name="cedula"/>
  <br/><br/><br/>
  <input type="submit" value="Insertar"/>
</form>
</body>
</html>