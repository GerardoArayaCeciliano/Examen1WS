/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Examen1.dto;

import java.time.Year;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private Year anno;
    private Date fechaVencimiento;
    private Integer monto;
    private boolean estado;
    private String periodo;
    private MembresiaDTO membresiaClienteId;
    
}
