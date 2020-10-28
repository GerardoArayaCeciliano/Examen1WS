/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Examen1.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.Examen1.entities.Cliente;

/**
 *
 * @author LordLalo
 */
public interface IClienteRepository extends JpaRepository<Cliente, Long> {

//    public List<Cliente> finByNombreId(Long clienteId);
    @Query("select c from Cliente c where UPPER(c.nombre) like CONCAT('%',UPPER(:nombre),'%') "
    + "and UPPER(c.apellido1) like CONCAT('%',UPPER(:primerApellido),'%')and"
    + " UPPER(c.apellido2) like CONCAT('%',UPPER(:segundoApellido),'%')"
    + " and UPPER(c.cedula) like CONCAT('%',UPPER(:cedula),'%')")
    public Optional<List<Cliente>> busquedaP(@Param("nombre") String nombre, @Param("primerApellido") String primerApellido,@Param("segundoApellido") String segundoApellido, @Param("cedula") String cedula);

}
