package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the producto database table.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producto")
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String color;
    private BigDecimal descuento;
    private String nombre;
    private BigDecimal precio;
    private String talla;
    @Column(name = "codigo_barra")
    private String codigoBarra;
    @Column(name = "fec_cre")
    private Timestamp fecCre;
    @Column(name = "fec_mod")
    private Timestamp fecMod;
    @Column(name = "usu_cre")
    private String usuCre;
    @Column(name = "usu_mod")
    private String usuMod;
    @ManyToOne
    @JoinColumn(name = "coleccion")
    private ColeccionEntity coleccionBean;
    @ManyToOne
    @JoinColumn(name = "estado")
    private EstadoProductoEntity estadoProducto;
    @ManyToOne
    @JoinColumn(name = "tipo")
    private TipoProductoEntity tipoProducto;

    @Transient
    private BigDecimal precioFinal;


    @ManyToMany
    @JoinTable(
            name = "pedido_producto",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_pedido")
    )
    private List<PedidoEntity> pedidos;
}