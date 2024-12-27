package org.educa.service;

import org.educa.dao.ClienteDAO;
import org.educa.dao.ClienteDAOImpl;
import org.educa.entity.ClienteEntity;

public class ClienteService {

    /**
     * Objeto de acceso a datos (DAO) para las operaciones de cliente.
     * Este campo se inicializa con una instancia de ClienteDAOImpl.
     */
    private final ClienteDAO clienteDAO = new ClienteDAOImpl();

    /**
     * Realiza el inicio de sesión de un cliente utilizando su DNI y contraseña.
     * El método consulta el DAO para verificar las credenciales del cliente en la base de datos.
     *
     * @param dni      El DNI del cliente que intenta iniciar sesión.
     * @param password La contraseña del cliente.
     * @return Un objeto de tipo {@link ClienteEntity} si las credenciales son correctas, o {@code null} si las credenciales son incorrectas.
     */
    public ClienteEntity login(String dni, String password) {

        return clienteDAO.loginClient(dni, password);
    }
}
