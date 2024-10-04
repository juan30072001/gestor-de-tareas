# Gestor de Tareas

Este proyecto es un gestor de tareas desarrollado con un enfoque en el frontend y backend utilizando tecnologías modernas. La aplicación permite a los usuarios registrarse, ingresar sus tareas y gestionar sus actividades de manera efectiva.

## Tecnologías Utilizadas

- **Frontend:**
  - HTML
  - Bootstrap
  - CSS
  - CSS Grid

- **Backend:**
  - Java Spring Boot
  - MySQL como motor de base de datos

## Dependencias

El proyecto utiliza las siguientes dependencias de Spring Boot:

- Thymeleaf
- JPA (Java Persistence API)
- MySQL Driver
- Spring DevTools
- Spring Web

## Estructura del Proyecto

### Clases Principales

1. **Tarea**: Esta clase maneja toda la información relacionada con las tareas, incluyendo atributos como título, descripción, fecha de vencimiento y estado.

2. **Persona**: Esta clase gestiona la información de los usuarios que se registran en la aplicación. Los datos de los usuarios se almacenan en la base de datos para facilitar su acceso y gestión de tareas.

### Funcionalidades

La aplicación implementa todas las operaciones CRUD para gestionar las tareas:

- **Crear**: Los usuarios pueden crear nuevas tareas.
- **Leer**: Los usuarios pueden visualizar sus tareas existentes.
- **Actualizar**: Los usuarios pueden editar las tareas que han creado.
- **Eliminar**: Los usuarios pueden eliminar tareas que ya no necesitan.

### Mapeo de Spring Boot

- **@GetMapping**: Utilizado para manejar las solicitudes GET y recuperar datos de las vistas.
- **@PostMapping**: Utilizado para manejar las solicitudes POST y enviar datos desde los formularios.
- **@PathVariable**: Facilita la obtención de datos de la URL.

## Instalación

Para instalar y ejecutar el proyecto en tu máquina local, sigue estos pasos:

1. Clona el repositorio:
   ```bash
   git clone https://github.com/juan30072001/gestor-de-tareas.git
2. navega al proyecto
   cd gestor-de-tareas
3 ejecuta la aplicacion:
   ./mvnw spring-boot:run
4. Accede a la aplicación en tu navegador en http://localhost:9090/login

