/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Examen1.services;

import java.util.List;
import java.util.Optional;
import org.una.Examen1.dto.ServicioDTO;
import org.una.Examen1.entities.Membresia;

/**
 *
 * @author LordLalo
 */
public interface IServicioService {

    public Optional<List<ServicioDTO>> findAll();

    public Optional<ServicioDTO> findById(Long id);

    public ServicioDTO create(ServicioDTO servicioDTO);

}
