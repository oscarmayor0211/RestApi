package com.apiRestCliente.controller;

import com.apiRestCliente.exception.InvalidDocumento;
import com.apiRestCliente.exception.InvalidParamaters;
import com.apiRestCliente.exception.InvalidTipoDocumento;
import com.apiRestCliente.model.Cliente;
import com.apiRestCliente.model.TipoDocumento;
import com.apiRestCliente.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@Slf4j
public class ClienteController {

    @Autowired
    private ClienteService service;

    /**
     * Servicio que retorna la información del cliente según su tipo y número de documento
     *
     * @param typeDocument, String con el tipo de documento del cliente a buscar
     * @param id,           String con el número de documento del cliente a buscar
     * @return Client
     */
    @RequestMapping(method = RequestMethod.GET, value = "/client", params = {"typeDocument", "id"})
    public ResponseEntity<Cliente> getCliente(@RequestParam("typeDocument") String typeDocument, @RequestParam("id") String id) throws InvalidDocumento, InvalidTipoDocumento {

            TipoDocumento type = TipoDocumento.valueOf(typeDocument);
            Cliente cliente = service.getCliente(type, id);
            return ResponseEntity.ok(cliente);


    }
}
