/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Examen1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.Examen1.entities.Servicio;

/**
 *
 * @author LordLalo
 */
public interface IServicioRepository extends JpaRepository<Servicio,Long> {
    
}
