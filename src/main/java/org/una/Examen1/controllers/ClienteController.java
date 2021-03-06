/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Examen1.controllers;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.una.Examen1.dto.ClienteDTO;
import org.una.Examen1.services.IClienteService;

/**
 *
 * @author LordLalo
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getById(@PathVariable(value = "id") long id) {
        try {
            return new ResponseEntity(clienteService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("buscarTodo")
    @ResponseBody
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity(clienteService.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/busquedaCompletaCliente/{nombre}/{apellido1}/{apellido2}/{cedula}")
    @ResponseBody
    public ResponseEntity<?> busquedaCompletaCliente(@PathVariable(value = "nombre") String nombre,
            @PathVariable(value = "apellido1") String apellido1,@PathVariable(value = "apellido2") String apellido2, @PathVariable(value = "cedula") String cedula) {
        String pName = "%";
        String pApellido1 = "%";
        String pApellido2 = "%";
        String pCedula = "%";
        try {

            if (!nombre.equals("none")) {
                pName = nombre;
            }
            if (!apellido1.equals("none")) {
                pApellido1 = apellido1;
            }
             if (!apellido1.equals("none")) {
                pApellido1 = apellido1;
            }
            if (!cedula.equals("none")) {
                pCedula = cedula;
            }
            Optional<List<ClienteDTO>> result =clienteService.buscarCliente(pName,pApellido1, pApellido2,pCedula);

            if (!result.isEmpty()) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            return new ResponseEntity<>("Sin resultados", HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<?> create(@Valid @RequestBody ClienteDTO clienteDTO, BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            try {
                return new ResponseEntity(clienteService.create(clienteDTO), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity("MENSAJE_VERIFICAR_INFORMACION", HttpStatus.BAD_REQUEST);
        }
    }
}
