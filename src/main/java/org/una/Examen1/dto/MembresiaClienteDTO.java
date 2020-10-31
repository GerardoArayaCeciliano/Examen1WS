/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Examen1.dto;

import java.util.ArrayList;
import java.util.List;
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
public class MembresiaClienteDTO {

    private Long id;
    @Setter(AccessLevel.NONE)
    private ClienteDTO clienteId;
    private boolean estado;
    private MembresiaDTO membresiaId;
    private List<CobroPendienteDTO> cobroPendiente = new ArrayList<>();

    public void clieteAux(ClienteDTO cli) {
        clienteId = cli;
    }
;

}
