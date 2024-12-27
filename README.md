# 🛍️ Proyecto de Pedidos con Hibernate 🛒

Este proyecto implementa un sistema de pedidos en línea utilizando **Hibernate** para la persistencia de datos y permite a los clientes realizar pedidos de productos, elegir colores y tallas, aplicar descuentos y finalizar el pedido con una dirección de entrega. ¡Todo gestionado eficientemente con una base de datos relacional! 🌟

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
- Los productos se gestionan a través de la tabla `PRODUCTO`, donde se almacenan los detalles como **nombre**, **precio**, **descuento**, **color**, y **talla**.
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
- Cada combinación de **talla** y **color** es un registro en la tabla `PRODUCTO` y se asocia a un **producto específico** a través de las columnas `talla` y `color`. 🌈
- **Hibernate** se usa para consultar las opciones disponibles en la base de datos. 📊

### 1.3 🔹 **Apartado 3: Finalización del pedido** 🏁

Cuando el cliente ha terminado de seleccionar productos, se le da la opción de **finalizar el pedido** o **seguir comprando**.

#### Pasos:
1. **Opción de finalizar pedido**: Si el cliente desea finalizar, se le muestran las **direcciones** disponibles. 🏠
2. **Selección de dirección**: El cliente selecciona la dirección de envío. 📍
3. **Crear el pedido**: El sistema guarda el pedido en la tabla `PEDIDO` con la información elegida (cliente, estado, dirección, fecha). 📝
4. **Cambio de estado del producto**: El producto cambia de estado (¡ya fue comprado!). ✅
5. **Historial de pedidos**: El sistema guarda un registro histórico de todos los pedidos en la tabla `HISTORICO_PEDIDO`. 📚

#### Características adicionales:
- El sistema gestiona el estado de los productos a través de la tabla `ESTADO_PRODUCTO`, que refleja si los productos están disponibles o vendidos. 🔄
- Se crea un **historial de pedidos** en la tabla `HISTORICO_PEDIDO` para cada compra realizada, permitiendo realizar un seguimiento de los cambios de estado. 🕒
- Si el cliente decide seguir comprando, el sistema lo redirige al menú de productos. 🔄

## 🗂️ Relación con la Base de Datos

La base de datos está estructurada para gestionar eficientemente los datos de clientes, productos, pedidos y más. Aquí te dejamos las tablas clave que se utilizan:

- **CLIENTE**: Contiene información personal de los clientes (DNI, nombre, contraseña, etc.).
- **DIRECCION**: Contiene las direcciones de envío asociadas a cada cliente. 🏠
- **ESTADO_PEDIDO**: Define el estado de un pedido (por ejemplo, "pendiente", "enviado", etc.). 📦
- **PEDIDO**: Almacena los pedidos realizados por los clientes, vinculados a la dirección y el estado del pedido. 📝
- **HISTORICO_PEDIDO**: Guarda un registro histórico de los cambios en los pedidos. 🔄
- **PRODUCTO**: Almacena los productos disponibles para la venta, incluyendo detalles como nombre, precio, talla, color y estado. 🛍️
- **ESTADO_PRODUCTO**: Define el estado del producto (por ejemplo, "disponible", "agotado", etc.). 🚦

## 💾 Uso de Hibernate

**Hibernate** gestiona la persistencia de datos y permite realizar operaciones CRUD (crear, leer, actualizar y eliminar) de manera eficiente. Las entidades de **Hibernate** en este proyecto incluyen:

- **Cliente**: Representa los datos de un cliente, mapeado a la tabla `CLIENTE`. 👤
- **Producto**: Representa los detalles de un producto, mapeado a la tabla `PRODUCTO`. 🛍️
- **Pedido**: Representa un pedido realizado, mapeado a la tabla `PEDIDO`. 📝
- **Direccion**: Representa una dirección de entrega, mapeado a la tabla `DIRECCION`. 📍
- **EstadoPedido**: Representa el estado de un pedido, mapeado a la tabla `ESTADO_PEDIDO`. 📦
- **EstadoProducto**: Representa el estado de un producto, mapeado a la tabla `ESTADO_PRODUCTO`. 🚦

## 🎯 Conclusión

Este proyecto es una implementación sencilla y eficiente de un sistema de pedidos utilizando **Hibernate** para la persistencia de datos. Permite gestionar productos, tallas, colores, pedidos, descuentos y direcciones de manera organizada y fácil de usar. 🌟

### Mejoras posibles:
- **Implementar un sistema de pago en línea**. 💳
- **Agregar validaciones y excepciones** para garantizar la integridad de los datos. ⚠️
- **Ampliar el sistema de descuentos** para incluir promociones más complejas. 🎁
