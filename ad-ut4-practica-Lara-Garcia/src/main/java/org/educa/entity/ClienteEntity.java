package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


/**
 * Representa una entidad cliente en la base de datos.
 * Esta clase está mapeada a la tabla "cliente" y contiene los atributos y relaciones de un cliente.
 * La información de cada cliente incluye datos personales, direcciones asociadas y pedidos realizados.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class ClienteEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String dni;
    private String email;
    private String nombre;
    private String pass;
    private String telefono;
    @Column(name = "fec_cre")
    private Timestamp fecCre;
    @Column(name = "fec_mod")
    private Timestamp fecMod;
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Column(name = "usu_cre")
    private String usuCre;
    @Column(name = "usu_mod")
    private String usuMod;
    @OneToMany(mappedBy = "clienteEntity", fetch = FetchType.EAGER)
    private List<DireccionEntity> direcciones;
    @OneToMany(mappedBy = "cliente")
    private List<PedidoEntity> pedidos;

}