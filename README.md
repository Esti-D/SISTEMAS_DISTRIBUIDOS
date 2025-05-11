# 📦 Proyecto EPO2 - Sistemas Distribuidos 2024/2025 (UBU)

## 🧑‍💻 Autora
Estíbalitz Díez

## 📝 Descripción general

Esta versión final (V6) del proyecto implementa una plataforma web interactiva y segura para la gestión de proyectos, subsistemas y usuarios.

El sistema distribuido ha sido **desarrollado a partir de la idea base de mi Trabajo de Fin de Grado (TFG)** —un software completo de escritorio presentado en enero de 2025 que utilizaba una base de datos embebida. Para esta entrega, se ha reimplementado el planteamiento en una arquitectura distribuida, **adaptando e incorporando los requisitos específicos** exigidos en la asignatura de Sistemas Distribuidos.

## 🚀 Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3**
- **JPA + Hibernate**
- **Thymeleaf**
- **MySQL (con Docker Compose)**
- **Bootstrap** para el diseño web
- **WebSockets** (chat entre usuarios)
- **Integración con API externa (PokeAPI)** 🐱‍👤
- **API Flask** para gestión de datos vía REST
- **Mapa interactivo** con OpenStreetMap (Leaflet.js)
- **Seguridad**: Login securizado, logout, y control de sesiones

## 🧩 Estructura principal del proyecto

- Página principal con login y acceso al sistema
- CRUD de usuarios
- CRUD de proyectos
- CRUD de subsistemas
- Visualización de documentos por proyecto
- Búsqueda de Pokémon (API externa)
- Chat individual entre usuarios con WebSockets
- Mapa interactivo asociado a ubicación del proyecto

## ✅ Requisitos cumplidos

- ✔️ Spring Boot + JPA + Hibernate + Thymeleaf
- ✔️ Login securizado y logout
- ✔️ 2 CRUD completos (proyectos y subsistemas)
- ✔️ Integración API REST (Flask)
- ✔️ Excepciones gestionadas en backend (inserciones duplicadas, errores técnicos simplificados)
- ✔️ Bootstrap para mejorar UI
- ✔️ WebSockets individuales entre usuarios
- ✔️ Mapa interactivo con Leaflet.js (no Google Maps)
- ✔️ Separación clara entre backend y frontend
- ✔️ Docker para entorno de ejecución y base de datos

## 🔁 Feedback de versiones anteriores tenido en cuenta

- ✅ **Gestión de excepciones** en accesos a BBDD (importante para inserts duplicados)
- ✅ **Mensajes de error amigables** para el usuario final
- ✅ **Menús Thymeleaf limpios** usando estilos externos (ya no embebidos en HTML)
- ✅ **Javadoc añadido** para documentar correctamente métodos y clases

## 📦 Versionado del desarrollo

Versiones anteriores EPO2:
* EPO2 - V. Inicial solo estructura
* EPO2 - V2 Configuración de BBDD h2 y Configuración Web
* EPO2 - V3 Configuración BBDD MySQL con Properties y WEB
* EPO2 - V4 Configuración BBDD MySQL con Docker-compose y WEB
* EPO2 - V5 Configuración BBDD MySQL - API Web Requisitos - API REST Pokémon con gestión excepción con Docker-compose excepciones incluidas)
- **V6 (Actual)**: Sistema completo con login, WebSockets, mapas, y todos los requisitos 

## 📅 Última actualización
Mayo 2025

> Este proyecto ha sido desarrollado como parte de la asignatura **Sistemas Distribuidos** (Grado en Ingeniería Informática, Universidad de Burgos).

