package org.educa.dao;

import org.educa.dao.hibernate.DAOSession;
import org.educa.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;

/**
 * Implementación del DAO para la gestión de pedidos.
 * Esta clase maneja la inserción de un pedido y sus productos asociados
 * en la base de datos, además de actualizar el estado de los productos
 * y registrar un histórico de cambios.
 */
public class PedidoDAOImpl implements PedidoDAO {

    /**
     * Inserta un nuevo pedido en la base de datos.
     * Asigna un estado de "Enviado" al pedido, un estado de "Vendido" a los productos
     * y crea los registros correspondientes en la tabla intermedia de pedidos y productos.
     * También guarda un histórico del pedido con los cambios realizados.
     *
     * @param pedido El pedido que se desea insertar en la base de datos.
     * @throws RuntimeException Si ocurre un error durante la inserción o si no se encuentran los estados necesarios.
     */
    @Override
    public void insertPedido(PedidoEntity pedido) {
        Session session = DAOSession.getSession();
        Transaction transaction = null;

        try {

            if (session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }

            transaction = session.beginTransaction();

            EstadoPedidoEntity estadoPedido = obtenerEstadoPedido(session, "Enviado");
            if (estadoPedido == null) {
                throw new RuntimeException("El estado de pedido 'Enviado' no se encuentra en la base de datos.");
            }
            pedido.setEstadoPedido(estadoPedido);

            if (pedido.getFecha() == null) {
                pedido.setFecha(new Timestamp(System.currentTimeMillis()));
            }

            EstadoProductoEntity estadoProductoVendido = obtenerEstadoProducto(session, 2);
            if (estadoProductoVendido == null) {
                throw new RuntimeException("El estado de producto 'Vendido' no se encuentra en la base de datos.");
            }

            for (ProductoEntity producto : pedido.getProductos()) {
                producto.setEstadoProducto(estadoProductoVendido);
                session.update(producto);
            }

            session.save(pedido);

            for (ProductoEntity producto : pedido.getProductos()) {
                PedidoProductoEntity pedidoProducto = new PedidoProductoEntity();
                pedidoProducto.setPedido(pedido);
                pedidoProducto.setProducto(producto);
                session.save(pedidoProducto);
            }

            createPedidoHistorico(session, pedido, "Pedido creado", "admin");

            transaction.commit();
            System.out.println("Pedido creado con éxito.");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Error al crear el pedido: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    /**
     * Obtiene el estado de un producto desde la base de datos, dado su ID.
     *
     * @param session  La sesión de Hibernate.
     * @param estadoId El ID del estado del producto.
     * @return El objeto {@link EstadoProductoEntity} correspondiente al ID proporcionado.
     */
    private EstadoProductoEntity obtenerEstadoProducto(Session session, int estadoId) {
        return session.get(EstadoProductoEntity.class, estadoId);
    }

    /**
     * Obtiene el estado de un pedido desde la base de datos, dado su nombre.
     *
     * @param session La sesión de Hibernate.
     * @param estado  El nombre del estado del pedido.
     * @return El objeto {@link EstadoPedidoEntity} correspondiente al nombre proporcionado.
     */
    private EstadoPedidoEntity obtenerEstadoPedido(Session session, String estado) {
        return session.createQuery("FROM EstadoPedidoEntity WHERE nombre = :estado", EstadoPedidoEntity.class)
                .setParameter("estado", estado)
                .uniqueResult();
    }

    /**
     * Crea un registro histórico del pedido en la base de datos.
     *
     * @param session La sesión de Hibernate.
     * @param pedido  El pedido al cual se le registrarán los cambios.
     * @param cambios La descripción de los cambios realizados en el pedido.
     * @param usuario El usuario que realizó los cambios.
     */
    private void createPedidoHistorico(Session session, PedidoEntity pedido, String cambios, String usuario) {
        HistoricoPedidoEntity historico = new HistoricoPedidoEntity();
        historico.setPedido(pedido);
        historico.setCambios(cambios);
        historico.setUsuMod(usuario);
        historico.setFecMod(new Timestamp(System.currentTimeMillis()));
        session.save(historico);
    }
}
