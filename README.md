# 🛍️ Proyecto de Pedidos con Hibernate 🛒

¡Bienvenido al proyecto de pedidos en línea! Este sistema está implementado con **Hibernate** para la persistencia de datos y permite a los clientes realizar pedidos de productos, elegir colores y tallas, aplicar descuentos y finalizar el pedido con una dirección de entrega. ¡Vamos a hacerlo todo más fácil y organizado! 😎

## 🚀 Requisitos

- **Java 8 o superior** ☕
- **Hibernate 5.x** 📦
- **Base de datos relacional** (por ejemplo, MySQL) 🗄️
- **Maven o Gradle** como herramienta de construcción 🛠️
- **JDBC** para conectarse a la base de datos 💻

## 📝 Descripción de los Apartados

### 1.1 🔹 **Apartado 1: Inserción de pedidos** 🛍️

El cliente ingresa su **DNI** y **contraseña** para acceder a su cuenta. Una vez autenticado, verá un menú con los productos disponibles, agrupados por nombre y precio.

#### Pasos:
1. **Autenticación**: El cliente ingresa su **DNI** y **contraseña**. 🔑
2. **Menú de productos**: Se muestra una lista de productos con su nombre y precio (¡descuentos incluidos!). 💸
3. **Selección del producto**: El cliente selecciona el producto que desea comprar. 🛒

#### Características adicionales:
- Se gestionan productos con precios y descuentos calculados dinámicamente. 🎯
- Los productos se cargan desde la base de datos usando **Hibernate**. 🗃️

### 1.2 🔹 **Apartado 2: Selección de colores y tallas** 👕

¡El cliente seleccionó su producto! Ahora tiene que elegir entre las distintas **tallas** y **colores** disponibles.

#### Pasos:
1. **Mostrar opciones**: El sistema muestra todas las combinaciones de **tallas** y **colores**. Ejemplo:
   - Talla L Blanco 🤍
   - Talla L Negro 🖤
   - Talla M Blanco 🤍
   - Talla M Negro 🖤
2. **Selección**: El cliente elige la combinación que más le guste. 😍

#### Características adicionales:
- Cada combinación de **talla** y **color** es un registro en la base de datos asociado a un producto. 🔄
- **Hibernate** se usa para consultar las opciones disponibles en la base de datos. 📊

### 1.3 🔹 **Apartado 3: Finalización del pedido** 🏁

Cuando el cliente ha terminado de seleccionar productos, se le da la opción de **finalizar el pedido** o **seguir comprando**.

#### Pasos:
1. **Opción de finalizar pedido**: Si el cliente desea finalizar, se le muestran las **direcciones** disponibles. 🏠
2. **Selección de dirección**: El cliente selecciona la dirección de envío. 📍
3. **Crear el pedido**: El sistema guarda el pedido en la base de datos con la información elegida. 📝
4. **Cambio de estado del producto**: El producto cambia de estado (¡ya fue comprado!). ✅
5. **Historial de pedidos**: El sistema guarda un registro histórico de todos los pedidos. 📚

#### Características adicionales:
- El sistema gestiona el estado de los productos para reflejar si están **disponibles** o **vendidos**. 🔄
- Se crea un **historial de pedidos** para que los clientes puedan consultar sus compras anteriores. 📅
- Si el cliente decide seguir comprando, el sistema lo redirige al menú de productos. 🔄

## 🗂️ Base de Datos

El sistema usa una **base de datos relacional** (por ejemplo, **MySQL**) para almacenar la información de productos, opciones (colores y tallas), direcciones de clientes, y pedidos. La estructura básica de las tablas incluye:

- **Clientes**: Información de los clientes (DNI, nombre, contraseña). 👤
- **Productos**: Datos de los productos, precios y descuentos. 💰
- **Opciones de producto**: Combinaciones de tallas y colores. 🌈
- **Pedidos**: Información de los pedidos realizados (productos, cantidades y dirección). 📝
- **Historial de pedidos**: Registro histórico de todos los pedidos. 🕒

## 💾 Uso de Hibernate

**Hibernate** gestiona la persistencia de datos, lo que significa que las operaciones CRUD (crear, leer, actualizar y eliminar) se hacen de manera eficiente. 

Las principales entidades de **Hibernate** en este proyecto incluyen:

- **Cliente**: Datos del cliente. 👤
- **Producto**: Información sobre los productos disponibles. 🛍️
- **OpcionProducto**: Combinaciones de tallas y colores. 🎨
- **Pedido**: Información de cada pedido realizado. 📝
- **Direccion**: Dirección de entrega asociada al cliente. 📍

## 🎯 Conclusión

Este proyecto es una implementación sencilla y eficiente de un sistema de pedidos utilizando **Hibernate** para la persistencia de datos. Permite gestionar productos, tallas, colores, pedidos, descuentos y direcciones de manera organizada y fácil de usar. 🌟

### Mejoras posibles:
- **Implementar un sistema de pago en línea**. 💳
- **Agregar validaciones y excepciones** para garantizar la integridad de los datos. ⚠️
- **Ampliar el sistema de descuentos** para incluir promociones más complejas. 🎁
