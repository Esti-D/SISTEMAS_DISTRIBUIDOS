# Práctica 2 - Sistemas Distribuidos

Esta práctica tiene como objetivo construir una aplicación distribuida con un frontend en Spring Boot y una API externa en Flask. 

(Idea del proyecto basada en el TFG, enfocado en el preprocesado de documentos PDF y gestión de requisitos técnicos de proyectos de ingeniería).

---

## 🎯 Objetivos principales

- Frontend funcional con Spring Boot y Thymeleaf.
- Pantalla de login básica.
- Pantalla de simulación de llamadas a API externa.
- API Flask que procesa documentos PDF y lanza excepciones simuladas.
- Gestión correcta de errores y presentación en el frontend.

---

## 🧰 Tecnologías utilizadas

- Spring Boot + Thymeleaf
- Flask (Python)
- JPA + Hibernate
- PostgreSQL o MySQL (opcional)
- Google Maps API (visual, manual)
- WebSockets (chat opcional)
- Docker
- GitHub Actions (CI/CD)
- Testing (JUnit, Pytest)

---

## ✅ Funcionalidades implementadas

- Página principal con control de acceso.
- Login y gestión de sesión.
- Comunicación con API externa Flask.
- Manejo de errores desde backend Python.
- Reutilización de lógica del TFG para preprocesado real de PDF.

---

## 🌟 Extras 

- CI/CD con GitHub Actions (compilación, tests, despliegue).
- Tests automatizados (Spring Boot y Flask).
- Dockerización del backend y API.
- Mapa interactivo con Google Maps para asociar ubicación manual a requisitos.
- Chat simple con WebSockets (para colaboración entre usuarios).

---

## 📦 Estructura interna

```
/EPO2/
│
├── frontend-spring/       → Proyecto Spring Boot
├── api-flask/             → API en Flask
├── docker/                → Archivos Docker
├── tests/                 → Tests automatizados
└── README.md              → Este archivo
```

---

## 🧠 Autores

Práctica desarrollada por **Estíbalitz Díez y Ricardo Sevilla** como parte de la asignatura *Sistemas Distribuidos*. Este trabajo está basado en el TFG defendido en Enero de 2025 por Estíbalitz Díez.

---
