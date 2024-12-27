package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Representa la relación entre un pedido y los productos asociados a él.
 * Esta clase está mapeada a la tabla "pedido_producto", que almacena las relaciones
 * entre los pedidos y los productos que contienen.
 * <p>
 * Un pedido puede contener varios productos, y cada producto puede estar asociado
 * a varios pedidos. Esta entidad se utiliza para gestionar dicha relación en el sistema.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido_producto")
public class PedidoProductoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private PedidoEntity pedido;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private ProductoEntity producto;
}
