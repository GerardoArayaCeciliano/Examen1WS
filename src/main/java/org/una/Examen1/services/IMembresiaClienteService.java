/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Examen1.services;

import java.util.List;
import java.util.Optional;
import org.una.Examen1.dto.MembresiaClienteDTO;

/**
 *
 * @author LordLalo
 */
public interface IMembresiaClienteService {

    public Optional<List<MembresiaClienteDTO>> findAll();

    public Optional<MembresiaClienteDTO> findById(Long id);

    public Optional<List<MembresiaClienteDTO>> findByEstado(Boolean estado);

    public MembresiaClienteDTO create(MembresiaClienteDTO membresiaClienteDTO);

    public MembresiaClienteDTO upDate(MembresiaClienteDTO membresiaClienteDTO);
}
