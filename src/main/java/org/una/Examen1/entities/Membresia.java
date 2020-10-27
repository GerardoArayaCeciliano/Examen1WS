/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Examen1.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author LordLalo
 */
@Entity
@Table(name = "exa_ger_membresias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Membresia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "periodicidad", length = 50)
    private String periodicidad;
    @Column(name = "monto")
    private Integer monto;
    @Column(name = "descripcion", length = 50)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicioId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "membresiaId", fetch = FetchType.LAZY)
    private List<MembresiaCliente> membresiaCliente = new ArrayList<>();

}
