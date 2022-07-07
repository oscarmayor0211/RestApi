package com.apiRestCliente.service;

import com.apiRestCliente.exception.InvalidDocumento;
import com.apiRestCliente.exception.InvalidTipoDocumento;
import com.apiRestCliente.model.Cliente;
import com.apiRestCliente.model.TipoDocumento;

public interface ClienteService {

    /**
     * Servicio que retorna la información del cliente según su tipo y número de documento
     *
     * @param type, TipoDocumento con el tipo de documento del cliente a buscar
     * @param id, String con el número de documento del cliente a buscar
     * @return Cliente
     * @throws IllegalArgumentException
     */
    public Cliente getCliente(TipoDocumento type, String id) throws IllegalArgumentException, InvalidTipoDocumento, InvalidDocumento;
}
