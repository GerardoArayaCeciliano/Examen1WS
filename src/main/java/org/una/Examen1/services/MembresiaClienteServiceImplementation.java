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
import org.una.Examen1.dto.MembresiaClienteDTO;
import org.una.Examen1.entities.Cliente;
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
    @Transactional
    public MembresiaClienteDTO create(MembresiaClienteDTO membresiaClienteDTO) {
        MembresiaCliente membresiaCliente = MapperUtils.EntityFromDto(membresiaClienteDTO, MembresiaCliente.class);
        membresiaCliente = membresiaClienteRepository.save(membresiaCliente);
        return MapperUtils.DtoFromEntity(membresiaCliente, MembresiaClienteDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<MembresiaClienteDTO>> findByEstado(Boolean estado) {
        int pos = 0;
        List<MembresiaCliente> entityList = membresiaClienteRepository.findByEstado(estado);
        List<MembresiaClienteDTO> dtoList = MapperUtils.DtoListFromEntityList(entityList, MembresiaClienteDTO.class);
        for (MembresiaCliente m : entityList) {
            ClienteDTO cli = MapperUtils.DtoFromEntity(m.getClienteId(), ClienteDTO.class);
            dtoList.get(pos).clieteAux(cli);
            pos++;
        }
        return Optional.of(dtoList);
    }

    @Override
    @Transactional
    public MembresiaClienteDTO upDate(MembresiaClienteDTO membresiaClienteDTO) {
        Optional<MembresiaCliente> result = membresiaClienteRepository.findById(membresiaClienteDTO.getId());
        if (result.isPresent()) {
            MembresiaCliente entity = MapperUtils.EntityFromDto(membresiaClienteDTO, MembresiaCliente.class);
            entity = membresiaClienteRepository.save(entity);
            return MapperUtils.DtoFromEntity(entity, MembresiaClienteDTO.class);
        }
        return null;
    }

}
