<h1>Ejerrcicio en Limpio Java SpringBoot</h1>
<h3>El desafio arranca con 2 laptops que se crean automaticamente en la DB</h3>

<h2>Rutas</h2>
<ul><li>localhost8080/  = Saludo al usuario</li>
<li>localhost8080/api/Laptops = Retorna lista de laptops con metodo GET</li>
<li>localhost8080/api/Laptops/(numero de id) = Retorna una Laptop en paticular con metodo GET</li>
<li>localhost8080/api/Laptops/ = A traves de Postman con el metodo POST se puede crear una nueva Laptop</li>
<li>localhost:8080/api/Laptops/ = A traves de Postman con metodo DELETE vacia la base de datos</li>
<li>localhost:8080/api/Laptops/(numero de id) = Borra una laptop en paticular a traves de Postman con metodo DELETE</li>
<li>localhost:8080/api/Laptops/ = Actualiza una laptop en paticular a traves de Postman con metodo PUT</li>
<li>localhost:8080/swagger-ui/ = Documentacion swagger</li>
</ul>

<h2>Utilidades</h2>
<ul>
<li>Testing de rutas con JUnit</li>
<li>Documentacion con Swagger</li>
<li>Actualmente base de datos con h2(proximamente base de datos relacionales o no relacionales)</li>
<li>Seguridad en rutas por tipo de usuario</li>
<ul>Datos:
<li>Rol USER : name: user, password: Rutito2010</li>
<li>Rol ADMIN : name: admin, password: Julieta2010</li>
<li>Para la ruta inicial se requiere cualquiera de los 2 usuarios, para la rutas "/api/Laptops/ se requerira usuario admin</li>
<li>localhost:8080/logout ruta para cambiar cerrar sesion con cada usuario</li>
</ul>

</ul>