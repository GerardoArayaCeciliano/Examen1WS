/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Examen1.dto;

import java.util.ArrayList;
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
public class MembresiaClienteDTO {
    private Long id;
    private ClienteDTO clienteId;
    private MembresiaDTO membresiaId;
    private List<CobroPendienteDTO> cobroPendiente = new ArrayList<>();
}
