/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Examen1.controllers;

import java.time.Instant;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import org.una.Examen1.dto.CobroPendienteDTO;
import org.una.Examen1.dto.MembresiaClienteDTO;
import org.una.Examen1.services.IClienteService;
import org.una.Examen1.services.ICobroPendienteService;
import org.una.Examen1.services.IMembresiaClienteService;
import org.una.Examen1.utils.FechasUtils;

/**
 *
 * @author LordLalo
 */
@RestController
@RequestMapping("/cobroPendiente")
public class CobroPendienteController {

    @Autowired
    private IClienteService clienteService;
    @Autowired
    private ICobroPendienteService cobroPendienteService;
    @Autowired
    private IMembresiaClienteService membresiaClienteService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<?> create(@Valid @RequestBody CobroPendienteDTO cobroPendienteDTO, BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            try {
                int cant = cobroPendienteDTO.getCantidad();
                cobroPendienteDTO.setMonto(cobroPendienteDTO.getMonto() / cant);
                System.out.println("CANTIDAD" + cant);
                for (int x = 0; x < cant; x++) {

                    //cobroPendienteDTO.setFechaVencimiento(cobroPendienteDTO.sumarDiasAFecha(cobroPendienteDTO.getFechaVencimiento(), 30));
                    new ResponseEntity(cobroPendienteService.create(cobroPendienteDTO), HttpStatus.CREATED);
                }
                return new ResponseEntity(HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity("MENSAJE_VERIFICAR_INFORMACION", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/generarCobro/{estado}")
    @ResponseBody
    public ResponseEntity<?> generarCobros(@PathVariable(value = "estado") Boolean estado) {
        List<MembresiaClienteDTO> membreClien = new ArrayList<>();
//        if (!membreClien.isEmpty()) {
            membreClien = (List<MembresiaClienteDTO>) membresiaClienteService.findByEstado(estado).get();
            for (MembresiaClienteDTO membre : membreClien) {
                Date fecha = new Date();
                fecha.from(Instant.now());
                int cantidadPagos = new FechasUtils().calcularCantidadCobros(membre.getMembresiaId().getPeriodicidad());
                for (int x = 0; x < cantidadPagos; x++) {
                    CobroPendienteDTO cobroPendienteDTO = new CobroPendienteDTO();
                    cobroPendienteDTO.setMembre(membre);
                    cobroPendienteDTO.setAnno(Year.now().toString());
                    cobroPendienteDTO.setCantidad(0);
                    cobroPendienteDTO.setPeriodo(membre.getMembresiaId().getPeriodicidad());
                    cobroPendienteDTO.setMonto(membre.getMembresiaId().getMonto() / cantidadPagos);
                    fecha = FechasUtils.sumarDiasAFecha(fecha, new FechasUtils().CantidadDias(cantidadPagos));
                    cobroPendienteDTO.setFechaVencimiento(fecha);
                    cobroPendienteService.create(cobroPendienteDTO);
                }
                membre.setEstado(false);
                System.out.print(membre.getClienteId().getNombre() + "NOMBRE   " + membre.getId().toString());
                System.out.println();
                System.out.println();
                membresiaClienteService.upDate(membre);
            }
            return new ResponseEntity("Se generaron los cobros de forma correcta", HttpStatus.OK);
        //}
//        else {
//            return new ResponseEntity("No se pueden generrar cobros", HttpStatus.NO_CONTENT);
//        }

    }
}
