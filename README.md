# API de Gestión de Tareas

Esta es una API RESTful desarrollada en Java utilizando el framework Spring Boot. Permite gestionar tareas mediante operaciones CRUD: crear, obtener, actualizar y eliminar. La API incluye validaciones de datos y un sistema de manejo de errores para garantizar respuestas claras en cada operación.

## 🚀 Características principales

- Crear, obtener, actualizar y eliminar tareas
- Validaciones automáticas de los datos de entrada
- Manejo de errores detallado con mensajes descriptivos
- Documentación generada automáticamente con OpenAPI 3.0 (Swagger)

## ⚙️ Tecnologías utilizadas

- Java 21+
- Spring Boot
- Maven
- IntelliJ IDEA
- OpenAPI 3.0 (Swagger)

## 🛠️ Guía paso a paso para poner en marcha el proyecto

### 1️⃣ Requisitos previos

Asegúrate de tener instalados los siguientes programas en tu máquina:

- Java JDK 21+
- Maven
- IntelliJ IDEA (versión Community o Ultimate)

### 2️⃣ Clonar el proyecto desde GitHub

1. Abre la terminal o consola de comandos.
2. Ejecuta el siguiente comando para clonar el repositorio:
    ```sh
    git clone https://github.com/tu-usuario/api-tareas-spring.git
    ```
3. Accede a la carpeta del proyecto:
    ```sh
    cd api-tareas-spring
    ```

### 3️⃣ Abrir el proyecto en IntelliJ IDEA

1. Abre IntelliJ IDEA.
2. Haz clic en `File > Open`.
3. Busca la carpeta donde clonaste el proyecto (`api-tareas-spring`) y haz clic en `OK`.
4. IntelliJ detectará automáticamente el proyecto como un proyecto Maven y descargará todas las dependencias necesarias. Si no lo hace automáticamente:
    - Ve a `View > Tool Windows > Maven`.
    - Haz clic en el botón de recarga: `Reload All Maven Projects` (ícono de dos flechas en círculo).

### 4️⃣ Configurar el JDK en IntelliJ IDEA

1. Dirígete a `File > Project Structure > Project`.
2. En la opción `Project SDK`, selecciona `Java 17` (o la versión que hayas instalado).
3. Haz clic en `Apply` y luego en `OK` para guardar la configuración.

### 5️⃣ Compilar y construir el proyecto

1. Abre la terminal integrada de IntelliJ IDEA (en la parte inferior).
2. Ejecuta el siguiente comando para limpiar y construir el proyecto:
    ```sh
    mvn clean install
    ```
3. Esto descargará todas las dependencias y compilará el proyecto.

### 6️⃣ Ejecutar la aplicación

Tienes dos formas de ejecutar la aplicación:

- **Opción A: Ejecutar desde IntelliJ IDEA**
    1. Ve a la clase principal que tenga la anotación `@SpringBootApplication` (normalmente llamada `ApiTareasApplication` o similar).
    2. Haz clic derecho en el archivo y selecciona `Run 'NombreDeLaClase'`.

- **Opción B: Ejecutar desde la terminal**
    1. Ejecuta el siguiente comando en la terminal:
        ```sh
        mvn spring-boot:run
        ```
    2. Una vez iniciado, la API estará disponible en: `http://localhost:8080/tareas`.

### 7️⃣ Probar la API

#### 🔗 Acceder a la documentación con Swagger

Para ver la documentación generada automáticamente, abre un navegador y accede a: `http://localhost:8080/swagger-ui.html`

#### 📬 Probar los endpoints con Postman o cURL

| Método | Ruta          | Descripción                   |
|--------|---------------|-------------------------------|
| GET    | /tareas       | Obtiene todas las tareas      |
| GET    | /tareas/{id}  | Obtiene una tarea por su ID   |
| POST   | /tareas       | Crea una nueva tarea          |
| PUT    | /tareas/{id}  | Actualiza una tarea existente |
| DELETE | /tareas/{id}  | Elimina una tarea por su ID   |

### ✅ Validaciones de datos

Cada tarea debe cumplir con las siguientes reglas:

- Nombre: No puede estar vacío.
- Descripción: No puede estar vacía.
- Estatus: No puede ser nulo.
- Fecha: Debe ser igual o mayor a la fecha actual.

Si alguno de estos requisitos no se cumple, la API devolverá un error `400 Bad Request` con un mensaje detallado.

### 🐛 Manejo de errores

- `400 Bad Request`: Se devuelve cuando los datos de entrada no son válidos.
- `404 Not Found`: Cuando no se encuentra la tarea solicitada.
- `500 Internal Server Error`: Cuando ocurre un error inesperado en el servidor.

## 📋 Autores
- Daniel Moreno Ruiz
- Pablo Garcia Borja
