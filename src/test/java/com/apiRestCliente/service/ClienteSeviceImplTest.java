package com.apiRestCliente.service;


import com.apiRestCliente.model.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class ClienteSeviceImplTest {
    private final String URL = "/api/";

    @Autowired
    MockMvc mvc;

    @Test
    public void getClienteCedula() throws Exception {
        Cliente cliente = new Cliente();

        cliente.setPrimerNombre("OSCAR");
        cliente.setSegundoNombre("EDUARDO");
        cliente.setPrimerApellido("MAYOR");
        cliente.setSegundoApellido("JARAMILLO");
        cliente.setTelefono(3182747);
        cliente.setDireccion("CALLE 26B # 5 - 60");
        cliente.setCiudadResidencia("TULUA");

        mvc.perform(get(URL + "client?typeDocument=C&id=23445322")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(cliente))).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void getClientePasaporte() throws Exception {
        Cliente cliente = new Cliente();

        cliente.setPrimerNombre("GILDARDO");
        cliente.setSegundoNombre("ANDRES");
        cliente.setPrimerApellido("MAYOR");
        cliente.setSegundoApellido("MARIN");
        cliente.setTelefono(2232322);
        cliente.setDireccion("CALLE 26B # 5 - 60");
        cliente.setCiudadResidencia("TULUA");

        mvc.perform(get(URL + "client?typeDocument=P&id=0120P")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(cliente))).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void getClienteTipoDocumentInvalidBadRequest() throws Exception {
        Cliente cliente = new Cliente();

        cliente.setPrimerNombre("OSCAR");
        cliente.setSegundoNombre("EDUARDO");
        cliente.setPrimerApellido("MAYOR");
        cliente.setSegundoApellido("JARAMILLO");
        cliente.setTelefono(3182747);
        cliente.setDireccion("CALLE 26B # 5 - 60");
        cliente.setCiudadResidencia("TULUA");

        mvc.perform(get(URL + "client?typeDocument=P&id=23445322")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(cliente))).andExpect(status().isBadRequest()).andDo(print());
    }

    @Test
    public void getClienteTypeDocumentInvalid() throws Exception {
        Cliente cliente = new Cliente();

        cliente.setPrimerNombre("OSCAR");
        cliente.setSegundoNombre("EDUARDO");
        cliente.setPrimerApellido("MAYOR");
        cliente.setSegundoApellido("JARAMILLO");
        cliente.setTelefono(3182747);
        cliente.setDireccion("CALLE 26B # 5 - 60");
        cliente.setCiudadResidencia("TULUA");

        mvc.perform(get(URL + "client?typeDocument=P&id=23445322")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensaje").value("El tipo de documento no es correcto"))
                .andDo(print());
    }


    @Test
    public void getClienteNumeroDocumentInvalid() throws Exception {
        Cliente cliente = new Cliente();

        cliente.setPrimerNombre("OSCAR");
        cliente.setSegundoNombre("EDUARDO");
        cliente.setPrimerApellido("MAYOR");
        cliente.setSegundoApellido("JARAMILLO");
        cliente.setTelefono(3182747);
        cliente.setDireccion("CALLE 26B # 5 - 60");
        cliente.setCiudadResidencia("TULUA");

        mvc.perform(get(URL + "client?typeDocument=P&id=121323")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensaje").value("El numero de documento no es correcto, "))
                .andDo(print());
    }

    public static String toJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}