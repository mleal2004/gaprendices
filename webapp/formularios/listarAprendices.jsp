<!DOCTYPE html>
<html>
<head>
    <title>Lista de Aprendices</title>
</head>
<body>
<h1>Lista de Aprendices</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Documento</th>
        <th>Correo</th>
        <th>Teléfono</th>
    </tr>
    <c:forEach var="aprendiz" items="${aprendices}">
        <tr>
            <td>${aprendiz.id}</td>
            <td>${aprendiz.nombre}</td>
            <td>${aprendiz.apellido}</td>
            <td>${aprendiz.documentoIdentidad}</td>
            <td>${aprendiz.correo}</td>
            <td>${aprendiz.telefono}</td>
        </tr>
    </c:forEach>
</table>
<a href="formularios/agregarAprendiz.jsp">Agregar Nuevo Aprendiz</a>
</body>
</html>
