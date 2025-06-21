package com.sith.alumnithon.controllers;

import com.sith.alumnithon.models.Mentoring.Mentoring;
import com.sith.alumnithon.models.Mentoring.dto.ListMentoriesDTO;
import com.sith.alumnithon.models.Mentoring.dto.RegisterMentoringDTO;
import com.sith.alumnithon.models.Mentoring.dto.ResponseMentoringDTO;
import com.sith.alumnithon.services.MentoringService;
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
@RequestMapping("/api/v1/mentoring")
public class MentoringController {

    @Autowired
    private MentoringService mentoringService;

    @PostMapping
    @Transactional
    public ResponseEntity<ResponseMentoringDTO> register(@RequestBody @Valid RegisterMentoringDTO dto,
                                                         UriComponentsBuilder uriComponentsBuilder) {
        Mentoring mentoring = mentoringService.register(dto);
        ResponseMentoringDTO responseMentoringDTO = new ResponseMentoringDTO(mentoring);
        URI uri = uriComponentsBuilder.path("/api/v1/mentoring/{id}").buildAndExpand(mentoring.getId()).toUri();
        return ResponseEntity.created(uri).body(responseMentoringDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ListMentoriesDTO>> listAll(@PageableDefault(size = 5)Pageable pageable) {
        Page<ListMentoriesDTO> mentories = mentoringService.listAll(pageable);
        return ResponseEntity.ok(mentories);
    }
}
