# ExpenseTracker

![Status](https://img.shields.io/badge/Status-En%20Desarrollo-blue)
![License](https://img.shields.io/badge/Licencia-MIT-green)

**ExpenseTracker** es una aplicación web desarrollada con Spring Boot que permite gestionar los gastos personales de forma intuitiva y eficiente. Proporciona una interfaz amigable con Thymeleaf para que los usuarios puedan agregar, visualizar, actualizar y eliminar sus gastos.

---

## 🚀 Características

- **Gestión de Gastos**:
  - Agregar nuevos gastos con descripción, monto y fecha.
  - Ver una lista detallada de todos los gastos registrados.
  - Editar o eliminar gastos existentes.
- **Interfaz Dinámica**: Renderizado de vistas responsivas y dinámicas utilizando Thymeleaf.
- **Persistencia de Datos**: Almacenamiento de datos en una base de datos MySQL mediante JPA/Hibernate.
- **Validación de Entradas**: Validación en el lado del servidor para garantizar la calidad y consistencia de los datos.
- **Manejo de Errores**: Gestión de errores comunes como entradas inválidas o problemas de conexión con la base de datos.

---

## 🛠 Tecnologías Utilizadas

### Backend
- **Java 17**: Lenguaje principal para la lógica de negocio.
- **Spring Boot**: Framework para el desarrollo de aplicaciones web:
  - **Spring MVC**: Gestión de controladores y enrutamiento.
  - **Spring Data JPA**: Para la interacción con la base de datos.
  - **Spring Boot DevTools**: Para recarga en caliente durante el desarrollo.

### Frontend
- **Thymeleaf**: Motor de plantillas para renderizar vistas dinámicas.
- **Bootstrap**: Framework CSS para diseño responsivo y moderno.
- **HTML5 y CSS3**: Construcción y estilización de las vistas.

### Base de Datos
- **MySQL**: Base de datos relacional para el almacenamiento de los gastos.

### Herramientas
- **Maven**: Gestión de dependencias y construcción del proyecto.
- **IntelliJ IDEA**: Entorno de desarrollo integrado.
- **Postman**: Pruebas de las rutas REST del backend.

---

## 📦 Instalación y Configuración

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/JesuGuerraP/ExpenseTracker.git
2. Configura la base de datos:

- Crea una base de datos en MySQL:
sql
Copiar código
CREATE DATABASE ExpenseTrackerDB;

-Configura el archivo application.properties con tus credenciales:
properties
Copiar código
spring.datasource.url=jdbc:mysql://localhost:3306/ExpenseTrackerDB
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3. Construye y ejecuta el proyecto:

bash
Copiar código
mvn spring-boot:run

5. Abre el navegador:

Accede a la aplicación en http://localhost:8080.
🌟 Funcionalidades Futuras
 Gráficos interactivos para analizar los gastos por categoría.
 Soporte para múltiples usuarios con inicio de sesión.
 Exportación de datos a formatos CSV o Excel.
 Internacionalización (i18n) para varios idiomas.
📝 Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más información.

👤 Autor
Desarrollado por Jesús Guerra.

📧 Correo: jesuguerra@gmail.com
🌐 GitHub: JesuGuerraP
¡Gracias por usar ExpenseTracker! Si te gusta este proyecto, no olvides darle una estrella ⭐ en GitHub.

