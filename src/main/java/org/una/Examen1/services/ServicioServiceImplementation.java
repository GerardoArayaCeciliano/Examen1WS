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
import org.una.Examen1.dto.ServicioDTO;
import org.una.Examen1.entities.Servicio;
import org.una.Examen1.repositories.IServicioRepository;
import org.una.Examen1.utils.MapperUtils;

/**
 *
 * @author LordLalo
 */
@Service
public class ServicioServiceImplementation implements IServicioService {

    @Autowired
    private IServicioRepository servicioRepository;

    private Optional<List<ServicioDTO>> findList(List<Servicio> list) {
        if (list != null) {
            List<ServicioDTO> servicioDTOs = MapperUtils.DtoListFromEntityList(list, ServicioDTO.class);
            return Optional.ofNullable(servicioDTOs);
        } else {
            return null;
        }
    }

    private Optional<List<ServicioDTO>> findList(Optional<List<Servicio>> list) {
        if (list.isPresent()) {
            return findList(list.get());
        } else {
            return null;
        }
    }

    private Optional<ServicioDTO> oneToDto(Optional<Servicio> one) {
        if (one.isPresent()) {
            ServicioDTO servicioDTO = MapperUtils.DtoFromEntity(one.get(), ServicioDTO.class);
            return Optional.ofNullable(servicioDTO);
        } else {
            return null;
        }
    }

    @Override
    public Optional<List<ServicioDTO>> findAll() {
        return findList(servicioRepository.findAll());
    }

    @Override
    public Optional<ServicioDTO> findById(Long id) {
        return oneToDto(servicioRepository.findById(id));
    }

    @Override
    public ServicioDTO create(ServicioDTO servicioDTO) {
        Servicio servicio = MapperUtils.EntityFromDto(servicioDTO, Servicio.class);
        servicio = servicioRepository.save(servicio);
        return MapperUtils.DtoFromEntity(servicio, ServicioDTO.class);
    }

}
