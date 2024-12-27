package org.educa.service;

import org.educa.dao.ProductoDAO;
import org.educa.dao.ProductoDAOImpl;
import org.educa.entity.ProductoEntity;

import java.sql.SQLException;
import java.util.List;

public class ProductoService {

    /**
     * Objeto de acceso a datos (DAO) para las operaciones de productos.
     * Este campo se inicializa con una instancia de ProductoDAOImpl.
     */
    private final ProductoDAO productoDAO = new ProductoDAOImpl();

    /**
     * Obtiene todos los productos agrupados por nombre.
     * Este método delega la operación al DAO para obtener todos los productos desde la base de datos.
     *
     * @return Una lista de objetos {@link ProductoEntity} que representa todos los productos.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public List<ProductoEntity> findAllProducts() throws SQLException {
        return productoDAO.findAllProduct();
    }


    /**
     * Obtiene un producto específico dado su nombre, talla y color.
     * Este método delega la operación al DAO para encontrar un producto específico en la base de datos.
     *
     * @param nombre El nombre del producto a buscar.
     * @param talla  La talla del producto a buscar.
     * @param color  El color del producto a buscar.
     * @return Un objeto {@link ProductoEntity} que representa el producto encontrado, o null si no se encuentra.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public ProductoEntity getFirstProductoByNameTallaAndColor(String nombre, String talla, String color) throws SQLException {
        return productoDAO.findProductoByName(nombre, talla, color);
    }

    /**
     * Busca productos por nombre.
     * Este método delega la operación al DAO para obtener todos los productos con un nombre específico desde la base de datos.
     *
     * @param producto El objeto {@link ProductoEntity} que contiene el nombre del producto a buscar.
     * @return Una lista de objetos {@link ProductoEntity} que representan los productos encontrados.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public List<ProductoEntity> findByName(ProductoEntity producto) throws SQLException {
        return productoDAO.findOnlyName(producto.getNombre());
    }

}
