/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Examen1.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.Examen1.dto.ClienteDTO;
import org.una.Examen1.entities.Cliente;
import org.una.Examen1.repositories.IClienteRepository;
import org.una.Examen1.utils.MapperUtils;

/**
 *
 * @author LordLalo
 */
@Service
public class ClienteServiceImplementation implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    private Optional<List<ClienteDTO>> findList(List<Cliente> list) {
        if (list != null) {
            List<ClienteDTO> clienteDTO = MapperUtils.DtoListFromEntityList(list, ClienteDTO.class);
            return Optional.ofNullable(clienteDTO);
        } else {
            return null;
        }
    }

    private Optional<List<ClienteDTO>> findList(Optional<List<Cliente>> list) {
        if (list.isPresent()) {
            return findList(list.get());
        } else {
            return null;
        }
    }

    private Optional<ClienteDTO> oneToDto(Optional<Cliente> one) {
        if (one.isPresent()) {
            ClienteDTO clienteDTO = MapperUtils.DtoFromEntity(one.get(), ClienteDTO.class);
            return Optional.ofNullable(clienteDTO);
        } else {
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ClienteDTO>> findAll() {
        return findList(clienteRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClienteDTO> findById(Long id) {
        return oneToDto(clienteRepository.findById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteDTO create(ClienteDTO clienteDTO) {
        Cliente cliente = MapperUtils.EntityFromDto(clienteDTO, Cliente.class);
        cliente = clienteRepository.save(cliente);
        return MapperUtils.DtoFromEntity(cliente, ClienteDTO.class);
    }

}
