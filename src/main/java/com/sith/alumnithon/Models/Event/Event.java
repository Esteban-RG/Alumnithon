package com.sith.alumnithon.Models.Event;

import com.sith.alumnithon.Models.CommunicationChannel.CommunicationChannel;
import com.sith.alumnithon.Models.Event.dto.RegisterEventDTO;
import com.sith.alumnithon.Models.Event.dto.UpdateEventDTO;
import com.sith.alumnithon.Models.Interest.Interest;
import com.sith.alumnithon.Models.Language.Language;
import com.sith.alumnithon.Models.User.User;
import com.sith.alumnithon.Models.Language.Level;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Event")
@Table(name = "event")
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

    @Enumerated(EnumType.STRING)
    private Level languageLevel;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    private StateEvent state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_id")
    private User mentor;

    @ManyToMany(mappedBy = "events", fetch = FetchType.LAZY)
    private Set<User> participants = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "event_interest",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "interest_id")
    )
    private Set<Interest> interests = new HashSet<>();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<CommunicationChannel> communicationChannels;

    public Event(RegisterEventDTO dto, User mentor) {
        this.title = dto.title();
        this.description = dto.description();
        this.type = dto.type();
        this.country = dto.country();
        this.language = dto.language();
        this.languageLevel = dto.languageLevel();
        this.startDate = dto.startDate();
        this.endDate = dto.endDate();
        this.state = StateEvent.STARTED;
        this.mentor = mentor;
        this.interests = dto.interests();

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

    public Level getLanguageLevel() {
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

    public List<CommunicationChannel> getCommunicationChannels() {
        return communicationChannels;
    }

    public void setCommunicationChannels(List<CommunicationChannel> communicationChannels) {
        this.communicationChannels = communicationChannels;
    }

    public Set<Interest> getInterests() {
        return interests;
    }

    public void setInterests(Set<Interest> interests) {
        this.interests = interests;
    }

    public Set<User> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<User> participants) {
        this.participants = participants;
    }
}
