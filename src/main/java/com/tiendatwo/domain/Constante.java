package com.tiendatwo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "constante")
@AllArgsConstructor
@NoArgsConstructor
public class Constante implements Serializable {

    private static final long serialVersionUID = 1l;
    
    // semana #13 
    // la constante son campos que tenemos en la base de datos 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_constante")
    private Integer idConstante;
    @Column(name="atributo", unique = true, nullable = false, length = 25)
    private String atributo;
    @Column(name="valor", nullable = false, length = 150)
    private String valor;
     
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;
}

