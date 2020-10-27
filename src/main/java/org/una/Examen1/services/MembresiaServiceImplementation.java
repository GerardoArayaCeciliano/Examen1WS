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
import org.una.Examen1.dto.MembresiaDTO;
import org.una.Examen1.entities.Membresia;
import org.una.Examen1.repositories.IMembresiaRepository;
import org.una.Examen1.utils.MapperUtils;

/**
 *
 * @author LordLalo
 */
@Service
public class MembresiaServiceImplementation implements IMembresiaService{
       @Autowired
    private IMembresiaRepository membresiaRepository;

    private Optional<List<MembresiaDTO>> findList(List<Membresia> list) {
        if (list != null) {
            List<MembresiaDTO> clienteDTO = MapperUtils.DtoListFromEntityList(list, MembresiaDTO.class);
            return Optional.ofNullable(clienteDTO);
        } else {
            return null;
        }
    }

    private Optional<List<MembresiaDTO>> findList(Optional<List<Membresia>> list) {
        if (list.isPresent()) {
            return findList(list.get());
        } else {
            return null;
        }
    }

    private Optional<MembresiaDTO> oneToDto(Optional<Membresia> one) {
        if (one.isPresent()) {
            MembresiaDTO membresiaClienteDTO = MapperUtils.DtoFromEntity(one.get(), MembresiaDTO.class);
            return Optional.ofNullable(membresiaClienteDTO);
        } else {
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<MembresiaDTO>> findAll() {
        return findList(membresiaRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MembresiaDTO> findById(Long id) {
        return oneToDto(membresiaRepository.findById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public MembresiaDTO create(MembresiaDTO membresiaClienteDTO) {
       Membresia membresiaCliente = MapperUtils.EntityFromDto(membresiaClienteDTO, Membresia.class);
        membresiaCliente = membresiaRepository.save(membresiaCliente);
        return MapperUtils.DtoFromEntity(membresiaCliente,MembresiaDTO.class);
    }

}
