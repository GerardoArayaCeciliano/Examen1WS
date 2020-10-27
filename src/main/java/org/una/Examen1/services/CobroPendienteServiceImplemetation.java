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
import org.una.Examen1.dto.CobroPendienteDTO;
import org.una.Examen1.entities.CobroPendiente;
import org.una.Examen1.repositories.ICobroPendienteRepository;
import org.una.Examen1.utils.MapperUtils;

/**
 *
 * @author LordLalo
 */
@Service
public class CobroPendienteServiceImplemetation implements ICobroPendienteService {

    @Autowired
    private ICobroPendienteRepository cobroPendienteRepository;

    private Optional<List<CobroPendienteDTO>> findList(List<CobroPendiente> list) {
        if (list != null) {
            List<CobroPendienteDTO> cobroPendienteDTO = MapperUtils.DtoListFromEntityList(list, CobroPendienteDTO.class);
            return Optional.ofNullable(cobroPendienteDTO);
        } else {
            return null;
        }
    }

    private Optional<List<CobroPendienteDTO>> findList(Optional<List<CobroPendiente>> list) {
        if (list.isPresent()) {
            return findList(list.get());
        } else {
            return null;
        }
    }

    private Optional<CobroPendienteDTO> oneToDto(Optional<CobroPendiente> one) {
        if (one.isPresent()) {
            CobroPendienteDTO cobroPendienteDTO = MapperUtils.DtoFromEntity(one.get(), CobroPendienteDTO.class);
            return Optional.ofNullable(cobroPendienteDTO);
        } else {
            return null;
        }
    }

    public Optional<List<CobroPendienteDTO>> findAll() {
        return findList(cobroPendienteRepository.findAll());
    }

    @Override
    public Optional<CobroPendienteDTO> findById(Long id) {
        return oneToDto(cobroPendienteRepository.findById(id));
    }

    @Override
    public CobroPendienteDTO create(CobroPendienteDTO cobroPendienteDTO) {
        CobroPendiente cobroPendiente = MapperUtils.EntityFromDto(cobroPendienteDTO, CobroPendiente.class);
        cobroPendiente = cobroPendienteRepository.save(cobroPendiente);
        return MapperUtils.DtoFromEntity(cobroPendiente, CobroPendienteDTO.class);
    }

}
