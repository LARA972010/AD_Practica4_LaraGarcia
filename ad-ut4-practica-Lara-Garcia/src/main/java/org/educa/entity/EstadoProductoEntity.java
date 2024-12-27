package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Representa el estado de un producto en el sistema.
 * Esta clase está mapeada a la tabla "estado_producto" y contiene la información sobre el estado
 * de un producto, como su nombre, fecha de creación, fecha de modificación y los usuarios que lo gestionan.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estado_producto")
public class EstadoProductoEntity implements Serializable {
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
