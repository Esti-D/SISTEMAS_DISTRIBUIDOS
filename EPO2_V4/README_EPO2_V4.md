# Práctica 2 - Sistemas Distribuidos V4

Esta práctica tiene como objetivo construir una aplicación distribuida con un frontend desarrollado en Spring Boot, persistencia de datos con MySQL y gestión de requisitos de acceso mediante login de usuarios.

(Idea del proyecto basada en el TFG, enfocado en el preprocesado de documentos PDF y gestión de requisitos técnicos de proyectos de ingeniería).

---

## 🎯 Objetivos principales

- Frontend funcional con Spring Boot y Thymeleaf.
- Pantalla de login con validación de credenciales desde base de datos.
- Página de inicio personalizada tras autenticación.
- Dockerización completa de la aplicación (MySQL + Spring Boot).
- Gestión de usuarios desde base de datos y persistencia automática.

---

## 🧰 Tecnologías utilizadas

- Spring Boot 3.4.4
- Thymeleaf
- JPA + Hibernate
- MySQL 8 (en contenedor Docker)
- Docker + Docker Compose
- Maven
- Git

---

## ✅ Funcionalidades implementadas

- Página principal con enlace a login.
- Login funcional con comprobación de usuario/contraseña en la tabla `user`.
- Redirección a `home.html` tras login exitoso.
- Persistencia de usuarios precargada desde archivo SQL al iniciar el contenedor.
- Docker Compose configura automáticamente Spring Boot y MySQL con `.env`.

---

## 🐳 Arquitectura con Docker

- `springboot-app`: contiene la lógica del frontend, autenticación y controladores.
- `mysql-container`: contiene la base de datos `sisdisusers` con la tabla `user` precargada.
- Volumen persistente para los datos de MySQL.
- Variables configurables desde `.env`.

---

## ⚙️ Archivos importantes

- `Dockerfile`: compila y ejecuta el proyecto Java con Maven (multi-stage).
- `docker-compose.yml`: orquesta los servicios `springboot` y `mysql`.
- `.env`: variables de entorno externas para facilitar configuración.
- `init.sql`: inserta usuarios iniciales en la tabla `user` automáticamente.

---

## 🧪 Cómo ejecutar

1. Asegúrate de tener Docker Desktop corriendo.
2. En la raíz del proyecto, ejecuta:

```bash
docker-compose up --build
3. abre el navegador: http://localhost:8080
4. login usuarios 

---

## 📦 Estructura del proyecto

/EPO2_V4/
│
├── src/                         → Código fuente Spring Boot
├── mysql-init/init.sql         → Inserción automática de usuarios
├── Dockerfile                  → Imagen de la app Spring Boot
├── docker-compose.yml          → Orquestador de servicios
├── .env                        → Configuración de entorno
└── README.md                   → Este archivo

---

## 🧠 Autores

Práctica desarrollada por **Estíbalitz Díez y Ricardo Sevilla** como parte de la asignatura *Sistemas Distribuidos*. Este trabajo está basado en el TFG defendido en Enero de 2025 por Estíbalitz Díez.
