package com.sith.alumnithon.Models.Event.dto;

import com.sith.alumnithon.Models.Language.Language;
import com.sith.alumnithon.Models.Language.Level;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.sith.alumnithon.Models.Event.CountryEvent;
import com.sith.alumnithon.Models.Event.TypeEvent;

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

        @NotNull(message = "Please choose a language")
        Language language,

        @NotBlank(message = "Please choose your language level")
        Level languageLevel,

        @NotNull(message = "Please introduce a date to start the mentoring")
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        LocalDateTime startDate,

        @NotNull(message = "Please introduce a date to end the mentoring")
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        LocalDateTime endDate,

        @NotNull(message = "Please introduce an id of moderator")
        Long idModerator

) {
}
