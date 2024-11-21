<!DOCTYPE html>
<html>
<head>
    <title>Agregar Aprendiz</title>
</head>
<body>
<h1>Agregar Aprendiz</h1>
<form action="AprendizServlet" method="POST">
    <label>Nombre:</label>
    <input type="text" name="nombre" required><br>
    <label>Apellido:</label>
    <input type="text" name="apellido" required><br>
    <label>Documento de Identidad:</label>
    <input type="text" name="documento" required><br>
    <label>Correo:</label>
    <input type="email" name="correo" required><br>
    <label>Teléfono:</label>
    <input type="text" name="telefono" required><br>
    <button type="submit">Guardar</button>
</form>
</body>
</html>
