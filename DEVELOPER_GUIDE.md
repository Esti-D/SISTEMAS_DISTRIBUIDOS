
# 🛠️ Developer Guide - Sistema Distribuido UBU 2025

Este proyecto forma parte de la asignatura Sistemas Distribuidos (UBU, curso 2024/2025). Está basado en el TFG de escritorio de la autora, adaptado a una arquitectura cliente-servidor con servicios desacoplados y comunicación entre componentes usando tecnologías modernas.

## 🐳 Despliegue Local con Docker

Este proyecto está configurado para ejecutarse en un entorno Docker completo, incluyendo dos bases de datos MySQL, una API REST en Flask y una aplicación web en Spring Boot.

### 🔧 Requisitos Previos

- Docker
- Docker Compose
- Git (opcional pero recomendado)
- `.env` con las siguientes variables definidas:

```env
# MySQL para Spring Boot
MYSQL_DB=sisdisusers
MYSQL_USER=root
MYSQL_PASSWORD=1234UBU
MYSQL_PORT=3307

# Spring Boot app
SPRING_PORT=8080

# MySQL para Flask
FLASK_DB=sisdisrequirements
FLASK_PORT=3308

# API Flask
FLASK_API_PORT=5000
```

---

### 📁 Estructura General

```
.
├── Dockerfile (Java - Spring Boot)
├── api-flask/
│   ├── Dockerfile (Python - Flask)
│   ├── app.py
│   ├── models.py
│   └── requirements.txt
├── docker-compose.yml
├── mysql-javainit/         (scripts de inicialización Java DB)
├── mysql-pythoninit/       (scripts de inicialización Flask DB)
└── .env
```

---

### 🚀 Comandos de Despliegue

#### 1. Clonar el repositorio (si aplica)

```bash
git clone <repositorio>
cd <repositorio>
```

#### 2. Construir y levantar los servicios

```bash
docker-compose up --build
```

Esto inicia:

- `mysql-container`: BBDD para usuarios (Spring Boot)
- `springboot-app`: aplicación principal en Java
- `mysql-flask-container`: BBDD para requisitos (Flask)
- `flask-api-container`: microservicio Flask

#### 3. Acceso a la aplicación

| Servicio         | URL                            |
|------------------|--------------------------------|
| Interfaz web     | http://localhost:8080          |
| API Flask        | http://localhost:5000          |
| MySQL Java       | localhost:3307 (usuario: root) |
| MySQL Flask      | localhost:3308 (usuario: root) |

---

### 💥 Reiniciar desde cero

```bash
docker-compose down -v
docker-compose up --build
```

Esto elimina los contenedores y volúmenes y vuelve a levantar todo desde 0, incluyendo recrear las bases de datos.

---

### ✅ Verificación

Puedes usar `docker ps` para verificar que los 4 contenedores estén activos. Si hay errores, revisa los logs con:

```bash
docker-compose logs -f
```
