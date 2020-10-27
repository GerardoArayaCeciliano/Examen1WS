/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Examen1.services;

import java.util.List;
import java.util.Optional;
import org.una.Examen1.dto.MembresiaDTO;

/**
 *
 * @author LordLalo
 */
public interface IMembresiaService {

    public Optional<List<MembresiaDTO>> findAll();

    public Optional<MembresiaDTO> findById(Long id);

    public MembresiaDTO create(MembresiaDTO membresiaDTO);
}
