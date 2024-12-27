package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Representa una dirección asociada a un cliente en el sistema.
 * Esta clase está mapeada a la tabla "direccion" y contiene los atributos y metadatos asociados a una dirección.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "direccion")
public class DireccionEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String calle;
    private String ciudad;
    private String cp;
    private String pais;
    @Column(name = "fec_cre")
    private Timestamp fecCre;
    @Column(name = "fec_mod")
    private Timestamp fecMod;
    @Column(name = "usu_cre")
    private String usuCre;
    @Column(name = "usu_mod")
    private String usuMod;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClienteEntity clienteEntity;
}