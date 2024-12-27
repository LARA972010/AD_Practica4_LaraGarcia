package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Representa un registro histórico de un pedido en el sistema.
 * Esta clase está mapeada a la tabla "historico_pedido" y contiene información relacionada
 * con las modificaciones realizadas en un pedido, como los cambios realizados, el usuario que los hizo
 * y la fecha de la modificación.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "historico_pedido")
public class HistoricoPedidoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private PedidoEntity pedido;

    private String cambios;

    @Column(name = "usu_mod")
    private String usuMod;

    @Column(name = "fec_mod")
    private Timestamp fecMod;
}
