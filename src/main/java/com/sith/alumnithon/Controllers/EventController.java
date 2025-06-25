package com.sith.alumnithon.Controllers;

import com.sith.alumnithon.Models.Event.Event;
import com.sith.alumnithon.Models.Event.dto.ListEventsDTO;
import com.sith.alumnithon.Models.Event.dto.RegisterEventDTO;
import com.sith.alumnithon.Models.Event.dto.ResponseEventDTO;
import com.sith.alumnithon.Models.Event.dto.UpdateEventDTO;
import com.sith.alumnithon.Services.EventService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @Operation(summary = "Endpoint para registrar evento")
    @PostMapping
    @Transactional
    public ResponseEntity<ResponseEventDTO> register(@RequestBody @Valid RegisterEventDTO dto,
                                                     UriComponentsBuilder uriComponentsBuilder) {
        Event event = eventService.register(dto);
        ResponseEventDTO responseEventDTO = new ResponseEventDTO(event);
        URI uri = uriComponentsBuilder.path("/api/v1/event/{id}").buildAndExpand(event.getId()).toUri();
        return ResponseEntity.created(uri).body(responseEventDTO);
    }

    @Operation(summary = "Endpoint para listar todos los eventos")
    @GetMapping
    public ResponseEntity<Page<ListEventsDTO>> listAll(@PageableDefault(size = 5)Pageable pageable) {
        Page<ListEventsDTO> mentories = eventService.listAll(pageable);
        return ResponseEntity.ok(mentories);
    }

    @Operation(summary = "Endpoint para listar un evento por el id")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseEventDTO> listOne(@PathVariable Long id) {
        ResponseEventDTO responseEventDTO = eventService.listOne(id);
        return ResponseEntity.ok(responseEventDTO);
    }

    @Operation(summary = "Endpoint para actualizar un evento")
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ResponseEventDTO> update(@PathVariable Long id, @RequestBody @Valid UpdateEventDTO dto) {
        ResponseEventDTO responseEventDTO = eventService.update(id, dto);
        return ResponseEntity.ok(responseEventDTO);
    }

    @Operation(summary = "Endpoint para eliminar un evento")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        eventService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
