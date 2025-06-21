package com.sith.alumnithon.models.Mentoring.dto;

import com.sith.alumnithon.models.Mentoring.Mentoring;
import com.sith.alumnithon.models.Mentoring.TypeMentoring;

import java.time.LocalDateTime;

public record ListMentoriesDTO(

        String title,
        String description,
        TypeMentoring type,
        LocalDateTime startDate,
        LocalDateTime endDate,
        Long idMentor

) {

    public ListMentoriesDTO(Mentoring mentoring) {
        this(mentoring.getTitle(), mentoring.getDescription(),
                mentoring.getType(), mentoring.getStartDate(), mentoring.getEndDate(),
                mentoring.getMentor().getId());
    }

}
