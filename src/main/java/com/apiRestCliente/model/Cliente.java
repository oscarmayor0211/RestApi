package com.apiRestCliente.model;
import lombok.Data;

@Data
public class Cliente {

    private String id;

    private TipoDocumento tipoDocumento;

    private String primerNombre;

    private String segundoNombre;

    private String primerApellido;

    private String segundoApellido;

    private int telefono;

    private String direccion;

    private String ciudadResidencia;
}
