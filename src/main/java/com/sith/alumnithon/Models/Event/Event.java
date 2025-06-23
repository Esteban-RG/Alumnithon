package com.sith.alumnithon.Models.Event;

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
    @JoinColumn(name = "mentor_id")
    private User mentor;

    @ManyToMany(mappedBy = "events")
    private Set<User> participants = new HashSet<>();

    public Event(RegisterEventDTO dto, User mentor) {
        this.title = dto.title();
        this.description = dto.description();
        this.type = dto.type();
        this.country = dto.country();
        this.endDate = dto.endDate();
        this.state = StateEvent.STARTED;
        this.mentor = mentor;
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

    public User getMentor() {
        return mentor;
    }
}
