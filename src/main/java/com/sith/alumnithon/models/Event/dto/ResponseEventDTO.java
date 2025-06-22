package com.sith.alumnithon.models.Event.dto;

import com.sith.alumnithon.models.Event.CountryEvent;
import com.sith.alumnithon.models.Event.Event;
import com.sith.alumnithon.models.Event.TypeEvent;

import java.time.LocalDateTime;

public record ResponseEventDTO(

        Long id,
        String title,
        String description,
        TypeEvent type,
        CountryEvent country,
        String language,
        String languageLevel,
        LocalDateTime startDate,
        LocalDateTime endDate,
        Long idMentor

) {

    public ResponseEventDTO(Event event) {
        this(event.getId(), event.getTitle(), event.getDescription(),
                event.getType(), event.getCountry(), event.getLanguage(),
                event.getLanguageLevel(), event.getStartDate(),
                event.getEndDate(), event.getMentor().getId());
    }

}
