/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Examen1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.Examen1.entities.CobroPendiente;

/**
 *
 * @author LordLalo
 */
public interface ICobroPendienteRepository extends JpaRepository<CobroPendiente,Long> {
    
}
