package com.sith.alumnithon.Models.Event.dto;

import java.time.LocalDateTime;

import com.sith.alumnithon.Models.Event.CountryEvent;
import com.sith.alumnithon.Models.Event.Event;
import com.sith.alumnithon.Models.Event.TypeEvent;
import com.sith.alumnithon.Models.Language.Language;

public record ResponseEventDTO(

        Long id,
        String title,
        String description,
        TypeEvent type,
        CountryEvent country,
        Language language,
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
