/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Examen1.services;

import java.util.List;
import java.util.Optional;
import org.una.Examen1.dto.CobroPendienteDTO;

/**
 *
 * @author LordLalo
 */
public interface ICobroPendienteService {
    public Optional<List<CobroPendienteDTO>> findAll();

    public Optional<CobroPendienteDTO> findById(Long id);

    public CobroPendienteDTO create(CobroPendienteDTO cobroPendienteDTO);
}
