package com.example.api.dto;

import com.example.api.models.Curso;
import com.example.api.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicoDTO {

    private Long id;
    private String titulo;
    private String mensaje;
    private Usuario autor;
    private Curso curso;
    private LocalDateTime createdAt;
}

//incluir localtime con java.time