# 🧩 Sopa de Letras con Java, Swing, MariaDB y MVC

Aplicación desarrollada en **Java** capaz de generar sopas de letras dinámicas utilizando palabras almacenadas en una base de datos **MariaDB**, implementando el patrón **MVC (Modelo - Vista - Controlador)** y operaciones **CRUD**.

---

## 📌 Características

La aplicación permite:

✅ Añadir palabras a una base de datos  
✅ Eliminar palabras almacenadas  
✅ Consultar palabras guardadas  
✅ Generar automáticamente una sopa de letras  
✅ Mostrar la sopa dentro de una interfaz gráfica  
✅ Crear automáticamente la base de datos y tabla necesarias  
✅ Validar longitud máxima de palabras  
✅ Evitar palabras vacías o con espacios  

---

# 🛠 Tecnologías utilizadas

- Java
- Swing
- MariaDB
- JDBC
- NetBeans IDE
- MVC (Modelo - Vista - Controlador)

---

# 📂 Estructura del proyecto

```text
SopaDeLetras
│
├── Modelo
│      └── ModeloSopa.java
│
├── Vista
│      └── GUISopa.java
│
├── Controlador
│      ├── ControladorSopa.java
│      └── GeneradorSopaLetras.java
│
└── SopaDeLetras.java
```

---

# ⚙ Funcionamiento

La aplicación sigue el siguiente flujo:

```text
Usuario introduce palabra
        ↓
Se almacena en MariaDB
        ↓
Consulta palabras guardadas
        ↓
Generador obtiene palabras
        ↓
Inserta palabras en matriz
        ↓
Genera sopa automáticamente
        ↓
Muestra resultado en interfaz
```

---

# 🗄 Base de datos

La aplicación crea automáticamente:

Base de datos:

```text
sopa_letras
```

Tabla:

```sql
CREATE TABLE palabras(
    id INT AUTO_INCREMENT PRIMARY KEY,
    palabra VARCHAR(50) UNIQUE
);
```

---

# ▶ Instalación

## 1. Clonar repositorio

```bash
git clone https://github.com/Ixf2/SopaDeLetras---Java
```

---

## 2. Abrir en NetBeans

Abrir:

```text
Archivo
↓
Abrir proyecto
↓
Seleccionar carpeta
```

---

## 3. Añadir driver MariaDB

Agregar:

```text
mariadb-java-client-x.x.x.jar
```

en:

```text
Proyecto
↓
Properties
↓
Libraries
↓
Add JAR
```

---

## 4. Iniciar MariaDB/MySQL

Activar:

```text
XAMPP
↓
Start MySQL
```

---

## 5. Ejecutar

Ejecutar:

```text
SopaDeLetras.java
```

---

# 🖥 Interfaz

La interfaz permite:

- Introducir palabras
- Añadir palabras
- Eliminar palabras
- Consultar palabras
- Generar sopa de letras
- Visualizar resultados

---

# ⚠ Problemas solucionados

Durante el desarrollo se resolvieron:

- Error JDBC
- Driver no encontrado
- NullPointerException
- Problemas de conexión
- Validación de palabras
- Tamaño máximo de palabras
- Compatibilidad MariaDB/MySQL

---

# 🚀 Posibles mejoras futuras

- Implementar UPDATE (CRUD completo)
- Más orientaciones de palabras
- Exportar sopas
- Niveles de dificultad
- Temporizador
- Puntuación

---

# 👨‍💻 Autor

Proyecto desarrollado por:

**Joana del Pino Ramírez García**

---

# 📄 Licencia

Proyecto desarrollado con fines educativos.
