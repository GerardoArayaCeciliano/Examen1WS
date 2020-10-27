/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Examen1.entities;
//

import java.io.Serializable;
import java.time.Year;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author LordLalo
 */
@Entity
@Table(name = "exa_ger_cobros_pendientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CobroPendiente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "anno")
//    @Setter(AccessLevel.NONE)
//    @Temporal(TemporalType.DATE)
    private Year anno;
    @Column(name = "fecha_vencimiento")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Column(name = "monto")
    private Integer monto;
    @Column
    private boolean estado;
    @Column(name = "periodo", length = 50)
    private String periodo;
    @ManyToOne
    @JoinColumn(name = "membrecia_cliente_id")
    private Membresia membresiaClienteId;
    

}
