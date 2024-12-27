package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the pedido database table.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class PedidoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp fecha;
    @ManyToOne
    @JoinColumn(name = "direccion")
    private DireccionEntity direccion;
    @ManyToOne
    @JoinColumn(name = "estado")
    private EstadoPedidoEntity estadoPedido;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;
    @ManyToMany(mappedBy = "pedidos")
    private List<ProductoEntity> productos = new ArrayList<>();
}