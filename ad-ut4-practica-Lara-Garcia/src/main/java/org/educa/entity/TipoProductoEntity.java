package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * Representa el tipo de un producto en el sistema.
 * Esta entidad está mapeada a la tabla "tipo_producto", que almacena los diferentes tipos
 * de productos que pueden existir en el sistema.
 * <p>
 * Un tipo de producto podría ser utilizado para clasificar o categorizar productos,
 * permitiendo al sistema gestionar mejor las diferentes variantes o categorías de productos.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipo_producto")
public class TipoProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @Column(name = "fec_cre")
    private Timestamp fecCre;
    @Column(name = "fec_mod")
    private Timestamp fecMod;
    @Column(name = "usu_cre")
    private String usuCre;
    @Column(name = "usu_mod")
    private String usuMod;
}

