package com.sith.alumnithon.Models.Event.dto;

import com.sith.alumnithon.Models.Event.CountryEvent;
import com.sith.alumnithon.Models.Event.StateEvent;
import com.sith.alumnithon.Models.Event.TypeEvent;
import com.sith.alumnithon.Models.Interest.Interest;
import com.sith.alumnithon.Models.Language.Language;
import com.sith.alumnithon.Models.Language.Level;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Set;

public record UpdateEventDTO(

        String title,
        String description,
        TypeEvent type,
        CountryEvent country,
        Language language,
        Level languageLevel,
        LocalDateTime startDate,
        LocalDateTime endDate,
        StateEvent state,
        @NotNull
        Long idMentor,
        Set<Interest> interests

) {
}
