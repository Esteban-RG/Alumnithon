package com.sith.alumnithon.models.Mentoring;

import com.sith.alumnithon.models.Mentoring.dto.RegisterMentoringDTO;
import com.sith.alumnithon.models.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Mentoring")
@Table(name = "mentories")
public class Mentoring {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private TypeMentoring type;

    @CurrentTimestamp
    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    private StateMentoring state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_id")
    private User mentor;

    public Mentoring(RegisterMentoringDTO dto, User mentor) {
        this.title = dto.title();
        this.description = dto.description();
        this.type = dto.type();
        this.endDate = dto.endDate();
        this.state = StateMentoring.STARTED;
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

    public TypeMentoring getType() {
        return type;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public StateMentoring getState() {
        return state;
    }

    public User getMentor() {
        return mentor;
    }
}
