# CREATE A CRUD SYSTEM TO MANAGE PROPERTIES

## Resumen del Proyecto
Este sistema es una aplicación web destinada a la administración de propiedades, creada para simplificar el registro, la modificación, la consulta y la eliminación de bienes en una base de datos. Proporciona una interfaz amigable que permite a los usuarios llevar a cabo operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre las propiedades. Además, está concebido para ser implementado en la nube a través de AWS.

## Arquitectura 
El sistema utiliza una arquitectura **cliente-servidor** compuesta por tres capas principales:

El sistema está estructurado en una arquitectura **cliente-servidor** con tres capas fundamentales:

### 1. **Base de Datos**
   - Utiliza MariaDB, que es administrada a través de AWS RDS. Esta base de datos almacena la información relevante de las propiedades, como su dirección, precio y tipo.
   - Esquema de la tabla `properties`:
     - `propertyID`: Identificador único para cada propiedad.
     - `address`: Dirección de la propiedad.
     - `price`: Precio de la propiedad.
     - `size`: Tamaño de la propiedad.
     - `description`: Descripción detallada de la propiedad.

### 2. **Backend**
   - Desarrollado en Spring Boot (Java), el backend proporciona servicios REST que permiten interactuar con las propiedades. Se encarga de validar la entrada de datos y manejar la lógica de negocio.
   - Endpoints destacados:
     - `GET /propertie` - Obtener una lista de todas las propiedades.
     - `POST /propertie` - Añadir una nueva propiedad.
     - `PUT /propertie/{id}` - Modificar una propiedad existente.
     - `DELETE /propertie/{id}` - Eliminar una propiedad específica.

### 3. **Frontend**
   - La interfaz de usuario está diseñada con HTML, creando un entorno web interactivo donde los usuarios pueden gestionar propiedades de manera efectiva. Se comunica con el backend mediante solicitudes HTTP (REST).
   - Funciones disponibles:
     - Formulario para registrar nuevas propiedades.
     - Vista en lista para consultar propiedades registradas.
     - Botones que permiten editar o eliminar propiedades.





   



