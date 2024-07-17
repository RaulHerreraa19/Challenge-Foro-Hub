package com.example.api.controller;

import com.example.api.dto.TopicoDTO;
import com.example.api.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public TopicoDTO createTopico(@Valid @RequestBody TopicoDTO topicoDTO) {
        return topicoService.createTopico(topicoDTO);
    }

    @GetMapping
    public Page<TopicoDTO> getAllTopicos(@PageableDefault(size = 10) Pageable pageable) {
        return topicoService.getAllTopicos(pageable);
    }

    @GetMapping("/{id}")
    public Optional<TopicoDTO> getTopicoById(@PathVariable Long id) {
        return topicoService.getTopicoById(id);
    }

    @PutMapping("/{id}")
    public TopicoDTO updateTopico(@PathVariable Long id, @Valid @RequestBody TopicoDTO topicoDTO) {
        return topicoService.updateTopico(id, topicoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTopico(@PathVariable Long id) {
        topicoService.deleteTopico(id);
    }
}
