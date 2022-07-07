package com.apiRestCliente.service;

import com.apiRestCliente.exception.InvalidDocumento;
import com.apiRestCliente.exception.InvalidTipoDocumento;
import com.apiRestCliente.model.Cliente;
import com.apiRestCliente.model.TipoDocumento;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClienteSeviceImpl implements ClienteService {
    @Override
    public Cliente getCliente(TipoDocumento type, String id) throws IllegalArgumentException, InvalidTipoDocumento, InvalidDocumento {
        final String ID_CLIENT = "23445322";
        final String ID_CLIENT_P = "0120P";

        Cliente cliente = new Cliente();

        switch (id) {
            case ID_CLIENT:
                cliente.setTipoDocumento(type);
                cliente.setId(id);

                if (TipoDocumento.C.equals(type)) {
                    cliente.setPrimerNombre("OSCAR");
                    cliente.setSegundoNombre("EDUARDO");
                    cliente.setPrimerApellido("MAYOR");
                    cliente.setSegundoApellido("JARAMILLO");
                    cliente.setTelefono(3182747);
                    cliente.setDireccion("CALLE 26B # 5 - 60");
                    cliente.setCiudadResidencia("TULUA");
                }else{
                    log.error("El tipo de documento: no es correcto.");
                    throw new InvalidTipoDocumento();
                }
                log.info("El cliente se ha consultado correctamente");
                break;
            case ID_CLIENT_P:
                cliente.setTipoDocumento(type);
                cliente.setId(id);
                if (TipoDocumento.P.equals(type)){
                    cliente.setPrimerNombre("GILDARDO");
                    cliente.setSegundoNombre("ANDRES");
                    cliente.setPrimerApellido("MAYOR");
                    cliente.setSegundoApellido("MARIN");
                    cliente.setTelefono(2232322);
                    cliente.setDireccion("CALLE 26B # 5 - 60");
                    cliente.setCiudadResidencia("TULUA");
                }else{
                    log.error("El tipo de documento: no es correcto.");
                    throw new InvalidTipoDocumento();
                }
                log.info("El cliente se ha consultado correctamente");
                break;
            default:
                log.warn("El número de documento: " +  id + " no es correcto.");
                throw new InvalidDocumento();

        }
        return cliente;
    }
}
