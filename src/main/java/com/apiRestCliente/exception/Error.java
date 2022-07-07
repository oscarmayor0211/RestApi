package com.apiRestCliente.exception;

import lombok.Getter;

enum Error {
    BAD_PARAMS("parametros incorrectos, "),
    BAD_NOEXISTEDOCUMENTO("El numero de documento no es correcto, "),
    BAD_NOEXISTETIPODOCUMENTO("El tipo de documento no es correcto");
    @Getter
    private final String message;

    Error(String message) {
        this.message = message;
    }
}