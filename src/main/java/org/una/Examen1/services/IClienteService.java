/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Examen1.services;

import java.util.List;
import java.util.Optional;
import org.una.Examen1.dto.ClienteDTO;

/**
 *
 * @author LordLalo
 */
public interface IClienteService {

    public Optional<List<ClienteDTO>> findAll();

    public Optional<ClienteDTO> findById(Long id);

    public ClienteDTO create(ClienteDTO clienteDTO);

}
