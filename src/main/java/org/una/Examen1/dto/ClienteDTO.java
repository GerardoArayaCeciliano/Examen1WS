/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Examen1.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String cedula;
    private Date fechaNacimiento;
   
   // @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    private List<MembresiaClienteDTO> membrebesiaCliente = new ArrayList<>();
}
