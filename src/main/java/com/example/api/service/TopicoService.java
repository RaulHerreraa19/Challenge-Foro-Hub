package com.example.api.service;

import com.example.api.dto.TopicoDTO;
import com.example.api.models.Topico;
import com.example.api.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public TopicoDTO createTopico(TopicoDTO topicoDTO) {
        Topico topico = new Topico();
        topico.setTitulo(topicoDTO.getTitulo());
        topico.setMensaje(topicoDTO.getMensaje());
        topico.setAutor(topicoDTO.getAutor());
        topico.setCurso(topicoDTO.getCurso());
        topicoRepository.save(topico);
        topicoDTO.setId(topico.getId());
        topicoDTO.setCreatedAt(topico.getCreatedAt());
        return topicoDTO;
    }

    public Page<TopicoDTO> getAllTopicos(Pageable pageable) {
        return topicoRepository.findAll(pageable).map(topico -> new TopicoDTO(
                topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getAutor(), topico.getCurso(), topico.getCreatedAt()));
    }

    public Optional<TopicoDTO> getTopicoById(Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        return topico.map(value -> new TopicoDTO(value.getId(), value.getTitulo(), value.getMensaje(),
                value.getAutor(), value.getCurso(), value.getCreatedAt()));
    }

    public void deleteTopico(Long id) {
        topicoRepository.deleteById(id);
    }

    public TopicoDTO updateTopico(Long id, TopicoDTO topicoDTO) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()) {
            Topico topico = optionalTopico.get();
            topico.setTitulo(topicoDTO.getTitulo());
            topico.setMensaje(topicoDTO.getMensaje());
            topico.setAutor(topicoDTO.getAutor());
            topico.setCurso(topicoDTO.getCurso());
            topicoRepository.save(topico);
            return new TopicoDTO(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                    topico.getAutor(), topico.getCurso(), topico.getCreatedAt());
        }
        return null;
    }
}
