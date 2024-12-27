package org.educa.service;

import org.educa.dao.PedidoDAO;
import org.educa.dao.PedidoDAOImpl;
import org.educa.entity.PedidoEntity;

public class PedidoService {
    /**
     * Objeto de acceso a datos (DAO) para las operaciones de pedido.
     * Este campo se inicializa con una instancia de PedidoDAOImpl.
     */
    private final PedidoDAO pedidoDAO = new PedidoDAOImpl();

    /**
     * Inserta un nuevo pedido en el sistema.
     * El método delega la operación al DAO para insertar el pedido en la base de datos.
     *
     * @param pedido El objeto {@link PedidoEntity} que representa el pedido a insertar.
     */
    public void insertarPedido(PedidoEntity pedido) {
        pedidoDAO.insertPedido(pedido);

    }
}
