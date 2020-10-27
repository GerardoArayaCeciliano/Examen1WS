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
import org.una.Examen1.dto.MembresiaClienteDTO;
import org.una.Examen1.entities.MembresiaCliente;
import org.una.Examen1.repositories.IMembresiaClienteRepository;
import org.una.Examen1.utils.MapperUtils;

/**
 *
 * @author LordLalo
 */
@Service
public class MembresiaClienteServiceImplementation implements IMembresiaClienteService {

    @Autowired
    private IMembresiaClienteRepository membresiaClienteRepository;

    private Optional<List<MembresiaClienteDTO>> findList(List<MembresiaCliente> list) {
        if (list != null) {
            List<MembresiaClienteDTO> clienteDTO = MapperUtils.DtoListFromEntityList(list, MembresiaClienteDTO.class);
            return Optional.ofNullable(clienteDTO);
        } else {
            return null;
        }
    }

    private Optional<List<MembresiaClienteDTO>> findList(Optional<List<MembresiaCliente>> list) {
        if (list.isPresent()) {
            return findList(list.get());
        } else {
            return null;
        }
    }

    private Optional<MembresiaClienteDTO> oneToDto(Optional<MembresiaCliente> one) {
        if (one.isPresent()) {
            MembresiaClienteDTO membresiaClienteDTO = MapperUtils.DtoFromEntity(one.get(), MembresiaClienteDTO.class);
            return Optional.ofNullable(membresiaClienteDTO);
        } else {
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<MembresiaClienteDTO>> findAll() {
        return findList(membresiaClienteRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MembresiaClienteDTO> findById(Long id) {
        return oneToDto(membresiaClienteRepository.findById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public MembresiaClienteDTO create(MembresiaClienteDTO membresiaClienteDTO) {
        MembresiaCliente membresiaCliente = MapperUtils.EntityFromDto(membresiaClienteDTO, MembresiaCliente.class);
        membresiaCliente = membresiaClienteRepository.save(membresiaCliente);
        return MapperUtils.DtoFromEntity(membresiaCliente, MembresiaClienteDTO.class);
    }

}
