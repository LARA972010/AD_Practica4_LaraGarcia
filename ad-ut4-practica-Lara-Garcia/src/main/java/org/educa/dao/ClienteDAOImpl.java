package org.educa.dao;

import org.educa.dao.hibernate.DAOSession;
import org.educa.entity.ClienteEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * Implementación del DAO para la gestión de clientes.
 * Esta clase proporciona métodos para interactuar con la base de datos
 * con respecto a los clientes, como la autenticación de clientes a través
 * de su DNI y contraseña.
 */
public class ClienteDAOImpl implements ClienteDAO {

    /**
     * Realiza la autenticación de un cliente utilizando su DNI y contraseña.
     * Este método consulta la base de datos para verificar si existe un cliente
     * que coincida con el DNI y la contraseña proporcionados.
     *
     * @param dni      El DNI del cliente que desea iniciar sesión.
     * @param password La contraseña del cliente que desea iniciar sesión.
     * @return Un objeto {@link ClienteEntity} si el cliente existe y la contraseña es correcta,
     * o {@code null} si no se encuentra un cliente que coincida.
     */
    @Override
    public ClienteEntity loginClient(String dni, String password) {
        try (Session session = DAOSession.getSession()) {
            String hql = "FROM ClienteEntity WHERE dni = :dni AND pass = :password";
            Query<ClienteEntity> query = session.createQuery(hql, ClienteEntity.class);
            query.setParameter("dni", dni);
            query.setParameter("password", password);
            return query.uniqueResult();
        }
    }
}
