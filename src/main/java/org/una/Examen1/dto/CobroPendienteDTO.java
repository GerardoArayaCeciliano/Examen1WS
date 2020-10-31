/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Examen1.dto;

import java.util.Date;
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
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CobroPendienteDTO {

    private Long id;
    private String anno;
    private Date fechaVencimiento;
    private Integer monto;
    private boolean estado;
    private String periodo;
    @Setter(AccessLevel.NONE)
//    private MembresiaDTO membresiaClienteId;
    private MembresiaClienteDTO membresiaClienteId;
    private Integer cantidad;
     public void setMembre(MembresiaClienteDTO membrecias){
      membresiaClienteId=membrecias;
     }

}
