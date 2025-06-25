package com.sith.alumnithon.Models.Event.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.sith.alumnithon.Models.CommunicationChannel.CommunicationChannel;
import com.sith.alumnithon.Models.Event.CountryEvent;
import com.sith.alumnithon.Models.Event.Event;
import com.sith.alumnithon.Models.Event.TypeEvent;
import com.sith.alumnithon.Models.Interest.Interest;
import com.sith.alumnithon.Models.Language.Language;
import com.sith.alumnithon.Models.Language.Level;
import com.sith.alumnithon.Models.User.User;

public record ListEventsDTO(

        String title,
        String description,
        TypeEvent type,
        CountryEvent country,
        Language language,
        Level languageLevel,
        LocalDateTime startDate,
        LocalDateTime endDate,
        Long idMentor,
        List<CommunicationChannel> communicationChannel,
        Set<Interest> interests,
        Set<User> participants

) {

    public ListEventsDTO(Event event) {
        this(event.getTitle(), event.getDescription(),
                event.getType(), event.getCountry(), event.getLanguage(),
                event.getLanguageLevel(), event.getStartDate(),
                event.getEndDate(), event.getMentor().getId(), event.getCommunicationChannels(),
                event.getInterests(), event.getParticipants());
    }

}
