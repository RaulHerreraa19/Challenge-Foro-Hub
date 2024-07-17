package com.example.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioDTO {
    @NotBlank
    private String nombre;

    @NotBlank
    @Email
    private String email;

    @NotNull
    private Boolean esAdministrador;
}

