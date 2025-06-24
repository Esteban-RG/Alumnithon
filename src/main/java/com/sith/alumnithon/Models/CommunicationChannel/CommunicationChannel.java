package com.sith.alumnithon.Models.CommunicationChannel;

import com.sith.alumnithon.Models.Event.Event;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "communication_channel")
public class CommunicationChannel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeChannel channel;

    private String communicationLink;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeChannel getChannel() {
        return channel;
    }

    public void setChannel(TypeChannel channel) {
        this.channel = channel;
    }

    public String getCommunicationLink() {
        return communicationLink;
    }

    public void setCommunicationLink(String communicationLink) {
        this.communicationLink = communicationLink;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
