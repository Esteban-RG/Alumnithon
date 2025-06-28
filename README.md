# 📦 Alumnithon - Sith

<div align="center">
    <img src="https://img.shields.io/badge/Estado-En desarrollo-green">
    <img src="https://img.shields.io/badge/React-v19.1.0-blue?logo=react">
    <img src="https://img.shields.io/badge/TailwindCSS-v4.1.10-blue?logo=tailwindcss">
    <img src="https://img.shields.io/badge/React Router-v7.6.2-blue?logo=react">
    <img src="https://img.shields.io/badge/Java-v17-brown?logo=java">
    <img src="https://img.shields.io/badge/Spring Boot 3-v3.4.3-darkgreen?logo=spring">
    <img src="https://img.shields.io/badge/Maven-v4.0.0-brown?logo=apachemaven">
    <img src="https://img.shields.io/badge/PostgreSQL-v5.7.2-blue?logo=postgresql">
    <img src="https://img.shields.io/badge/ORM-Hibernate-darkgreen?logo=orm">
    <img src="https://img.shields.io/badge/Seguridad-Spring Security-darkgreen">
    <img src="https://img.shields.io/badge/Autenticación-JWT-blue">
    <img src="https://img.shields.io/badge/Versión-v1.0.0-darkgreen">
</div>

Aplicación web progresiva que facilita el intercambio lingüístico y cultural entre personas de distintos países, mediante un sistema accesible, intuitivo y centrado en la interacción humana significativa, superando las limitaciones geográficas y promoviendo el aprendizaje colaborativo.

---

## 🚀 Stack Tecnológico

| Tecnología       | Descripción                                                                        |
| ---------------- | ---------------------------------------------------------------------------------- |
| 🧠 Backend       | Java 17, Spring Boot 3, Maven, Spring Data JPA, Spring Security con JWT, SpringDoc |
| 🎨 Frontend      | React, Vite, React Router, TailwindCSS                                             |
| 🗄️ Base de datos | H2, PostgreSQL                                                                     |
| 🛠️ Build Tool    | Git, GitHub, Postman, Figma, Docker                                                |

## 🎨 Diseño UI

Disponible en [Figma](https://www.figma.com/design/dTYdHjJXO4AHbo5XepkHap/BabeLink-Responsive?node-id=1-3&t=LcYYgOXK6toucMYq-1).
Realizado por Diego O. Mateus

---

# Funcionalidades del proyecto

## Usuario

- Registrar e iniciar sesión
- Se usan los siguientes roles: `ADMIN` y `USER`
- Un usuario puede seguir o no seguir a otro usuario

## Evento

- Crea, lista todos, lista uno y elimina un evento
- Muestra los intereses para que los usuarios se quieran unir
- Se puede crear con tres tipos de eventos: `CURSO`, `MENTORIA` y `DESAFIO`
- Muestra el estado del evento: `EMPEZADO` y `FINALIZADO`
- Al momento de crear un evento se agrega el enlace del canal de comunicación como WhatsApp, Telegram y Zoom

---

## 🗂️ Estructura del Proyecto

```Tree
alumnithon/
│
│ ── src/
│ ── pom.xml
│
├── frontend/
│ ├── src/
│ └── index.html
│
├── README.md
└── .gitignore
```

---

### 🧪 Ejecución local completa

- Clona el repositorio:

```bash
git clone https://github.com/Esteban-RG/alumnithon.git
cd alumnithon
```

- Ejecuta el proyecto:

```bash
./mvnw spring-boot:run
```

---

### 🧪 Ejecución local solo frontend

- Clona el repositorio:

```bash
git clone https://github.com/Esteban-RG/alumnithon.git
cd alumnithon
```

- Genera los recursos necesarios:

```bash
 ./mvnw generate-resources
```

- Entra en la carpeta frontend:

```bash
cd frontend
```

- Instala las dependencias:

```bash
npm install
```

- Ejecuta el proyecto:

```bash
npm start
```

---

<h1>Desarrolladores del Proyecto 💻</h1>

<h3>Equipo Frontend</h3>

<table>
  <tr>
    <th><img src="https://avatars.githubusercontent.com/u/170216498?v=4" width=115></th>
    <th><img src="https://avatars.githubusercontent.com/u/133529542?v=4" width=115></th>
  </tr>
  <tr>
    <td>Diego O. Mateus</td>
    <td>Julio Paz Sosa</td>
  </tr>
  <tr>
    <td><a href="https://github.com/RyoKymera" target="blank"><img src="https://img.shields.io/badge/GitHub-black?style=for-the-badge&logo=github" alt="GitHub"/></a></td>
    <td><a href="https://github.com/juliopzsosa" target="blank"><img src="https://img.shields.io/badge/GitHub-black?style=for-the-badge&logo=github" alt="GitHub"/></a></td>
  </tr>
</table>

<h3>Equipo Backend</h3>

<table>
  <tr>
    <th><img src="https://avatars.githubusercontent.com/u/119370346?v=4" width=115></th>
    <th><img src="https://avatars.githubusercontent.com/u/166961958?v=4" width=115></th>
    <th><img src="https://avatars.githubusercontent.com/u/107082359?v=4" width=115></th>
  </tr>
  <tr>
    <td>Ricardo Esteban Reyes Gutiérrez</td>
    <td>Roberto Figueroa Paz</td>
    <td>Sergio Zuñiga Fraga</td>
  </tr>
  <tr>
    <td><a href="https://github.com/Esteban-RG" target="blank"><img src="https://img.shields.io/badge/GitHub-black?style=for-the-badge&logo=github" alt="GitHub"/></td>
    <td><a href="https://github.com/robcodego" target="blank"><img src="https://img.shields.io/badge/GitHub-black?style=for-the-badge&logo=github" alt="GitHub"/></a></td>
    <td><a href="https://github.com/SergioZF09" target="blank"><img src="https://img.shields.io/badge/GitHub-black?style=for-the-badge&logo=github" alt="GitHub"/></a></td>
  </tr>
</table>
