package org.educa.dao;

import org.educa.dao.hibernate.DAOSession;
import org.educa.entity.ProductoEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Implementación del DAO para la gestión de productos.
 * Esta clase proporciona métodos para interactuar con la base de datos
 * con respecto a los productos, como la búsqueda de productos por nombre,
 * talla y color, así como la obtención de productos con el precio y descuento máximo.
 */
public class ProductoDAOImpl implements ProductoDAO {

    /**
     * Obtiene todos los productos con su nombre, precio máximo y descuento máximo.
     * Para cada producto, calcula el precio final restando el descuento al precio máximo.
     *
     * @return Una lista de {@link ProductoEntity} con los productos obtenidos, incluyendo
     * el nombre, precio máximo, descuento máximo y precio final.
     */
    @Override
    public List<ProductoEntity> findAllProduct() {
        try (Session session = DAOSession.getSession()) {

            String hql = "SELECT p.nombre, MAX(p.precio), MAX(p.descuento) " +
                    "FROM ProductoEntity p " +
                    "GROUP BY p.nombre";

            Query<Object[]> query = session.createQuery(hql, Object[].class);
            List<Object[]> result = query.getResultList();

            List<ProductoEntity> productos = new ArrayList<>();

            for (Object[] row : result) {
                String nombre = (String) row[0];
                BigDecimal maxPrecio = (BigDecimal) row[1];
                BigDecimal maxDescuento = (BigDecimal) row[2];

                if (maxPrecio == null) {
                    maxPrecio = BigDecimal.ZERO;
                }
                if (maxDescuento == null) {
                    maxDescuento = BigDecimal.ZERO;
                }

                ProductoEntity producto = new ProductoEntity();
                producto.setNombre(nombre);
                producto.setPrecio(maxPrecio);
                producto.setDescuento(maxDescuento);

                BigDecimal descuentoValor = maxPrecio.multiply(maxDescuento).divide(new BigDecimal("100"));
                BigDecimal precioFinal = maxPrecio.subtract(descuentoValor);
                precioFinal = precioFinal.setScale(2, BigDecimal.ROUND_HALF_UP);
                producto.setPrecioFinal(precioFinal);

                productos.add(producto);
            }

            return productos;
        }
    }

    /**
     * Busca un producto específico por nombre, talla y color.
     * Si se encuentran varios productos con la misma combinación, retorna uno solo.
     *
     * @param nombre El nombre del producto que se desea buscar.
     * @param talla  La talla del producto que se desea buscar.
     * @param color  El color del producto que se desea buscar.
     * @return Un objeto {@link ProductoEntity} que corresponde a la combinación
     * de nombre, talla y color, o {@code null} si no se encuentra el producto.
     */
    @Override
    public ProductoEntity findProductoByName(String nombre, String talla, String color) {
        try (Session session = DAOSession.getSession()) {
            System.out.println("Buscando producto con nombre: " + nombre + ", talla: " + talla + ", color: " + color);

            String hql = "FROM ProductoEntity p WHERE p.nombre = :nombre AND p.talla = :talla AND p.color = :color";

            Query<ProductoEntity> query = session.createQuery(hql, ProductoEntity.class);
            query.setParameter("nombre", nombre);
            query.setParameter("talla", talla);
            query.setParameter("color", color);

            List<ProductoEntity> resultList = query.getResultList();

            Set<ProductoEntity> uniqueProductos = new HashSet<>(resultList);

            if (!uniqueProductos.isEmpty()) {
                return uniqueProductos.iterator().next(); // Retornar uno de los productos únicos
            }

            return null;
        }
    }

    /**
     * Busca los productos por su nombre y obtiene las combinaciones únicas de talla y color.
     * Devuelve una lista de productos que tienen el nombre especificado y sus combinaciones
     * únicas de talla y color.
     *
     * @param nombre El nombre del producto que se desea buscar.
     * @return Una lista de {@link ProductoEntity} que contienen el nombre especificado,
     * junto con sus combinaciones únicas de talla y color.
     */
    @Override
    public List<ProductoEntity> findOnlyName(String nombre) {
        try (Session session = DAOSession.getSession()) {

            String hql = "SELECT DISTINCT p.talla, p.color " +
                    "FROM ProductoEntity p WHERE p.nombre = :nombre";

            Query<Object[]> query = session.createQuery(hql, Object[].class);
            query.setParameter("nombre", nombre);

            List<Object[]> result = query.getResultList();
            List<ProductoEntity> productosDTO = new ArrayList<>();


            for (Object[] row : result) {
                String talla = (String) row[0];
                String color = (String) row[1];


                ProductoEntity producto = new ProductoEntity();
                producto.setNombre(nombre);
                producto.setTalla(talla);
                producto.setColor(color);

                productosDTO.add(producto);
            }

            return productosDTO;
        }
    }
}
