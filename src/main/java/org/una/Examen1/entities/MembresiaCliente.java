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
@Table(name = "exa_ger_membresias_clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MembresiaCliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private boolean estado;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente clienteId;
    @ManyToOne
    @JoinColumn(name = "membresia_id")
    private Membresia membresiaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "membresiaClienteId", fetch = FetchType.LAZY)
    private List<CobroPendiente> cobroPendiente = new ArrayList<>();
}
