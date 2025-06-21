package com.sith.alumnithon.models.Event.dto;

import com.sith.alumnithon.models.Event.CountryEvent;
import com.sith.alumnithon.models.Event.TypeEvent;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record RegisterEventDTO(

        @NotBlank(message = "Please introduce a title")
        String title,

        @NotBlank(message = "Please introduce a descripcion")
        String description,

        @NotNull(message = "Please choose a type of mentoring")
        TypeEvent type,

        @NotNull(message = "Please choose a country for mentoring")
        CountryEvent country,

        @NotBlank(message = "Please choose a language")
        String language,

        @NotBlank(message = "Please choose your language level")
        String languageLevel,

        @NotNull(message = "Please introduce a date to start the mentoring")
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        LocalDateTime startDate,

        @NotNull(message = "Please introduce a date to end the mentoring")
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        LocalDateTime endDate,

        @NotNull(message = "Please introduce an id of mentor")
        Long idMentor

) {
}
