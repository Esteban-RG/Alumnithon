package com.sith.alumnithon.Models.Event;

import com.sith.alumnithon.Models.Event.dto.UpdateEventDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.sith.alumnithon.Models.Event.dto.RegisterEventDTO;
import com.sith.alumnithon.Models.Language.Language;
import com.sith.alumnithon.Models.User.User;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Event")
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private TypeEvent type;

    @Enumerated(EnumType.STRING)
    private CountryEvent country;

    @Enumerated(EnumType.STRING)
    private Language language;

    private String languageLevel;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    private StateEvent state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moderator_id")
    private User moderator;

    @ManyToMany(mappedBy = "events", fetch = FetchType.LAZY)
    private Set<User> participants = new HashSet<>();

    public Event(RegisterEventDTO dto, User moderator) {
        this.title = dto.title();
        this.description = dto.description();
        this.type = dto.type();
        this.country = dto.country();
        this.language = dto.language();
        this.languageLevel = dto.languageLevel();
        this.startDate = dto.startDate();
        this.endDate = dto.endDate();
        this.state = StateEvent.STARTED;
        this.moderator = moderator;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TypeEvent getType() {
        return type;
    }

    public CountryEvent getCountry() {
        return country;
    }

    public Language getLanguage() {
        return language;
    }

    public String getLanguageLevel() {
        return languageLevel;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public StateEvent getState() {
        return state;
    }

    public User getModerator() {
        return moderator;
    }

    public void updateEvent(UpdateEventDTO dto) {
        if (dto.title() != null) {
            this.title = dto.title();
        }
        if (dto.description() != null) {
            this.description = dto.description();
        }
        if (dto.type() != null) {
            this.type = dto.type();
        }
        if (dto.country() != null) {
            this.country = dto.country();
        }
        if (dto.language() != null) {
            this.language = dto.language();
        }
        if (dto.languageLevel() != null) {
            this.languageLevel = dto.languageLevel();
        }
        if (dto.startDate() != null) {
            this.startDate = dto.startDate();
        }
        if (dto.endDate() != null) {
            this.endDate = dto.endDate();
        }
        if (dto.state() != null) {
            this.state = dto.state();
        }
    }
}
