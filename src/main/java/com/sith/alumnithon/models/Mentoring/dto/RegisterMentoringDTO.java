package com.sith.alumnithon.models.Mentoring.dto;

import com.sith.alumnithon.models.Mentoring.TypeMentoring;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record RegisterMentoringDTO(

        @NotBlank(message = "Please introduce a title")
        String title,

        @NotBlank(message = "Please introduce a descripcion")
        String description,

        @NotNull(message = "Please introduce a type of mentoring")
        TypeMentoring type,

        @NotNull(message = "Please introduce a date to start the mentoring")
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        LocalDateTime startDate,

        @NotNull(message = "Please introduce a date to end the mentoring")
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        @Future
        LocalDateTime endDate,

        @NotNull(message = "Please introduce an id of mentor")
        Long idMentor

) {
}
