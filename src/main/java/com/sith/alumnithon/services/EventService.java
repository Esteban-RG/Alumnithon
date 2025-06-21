package com.sith.alumnithon.services;

import com.sith.alumnithon.models.Event.Event;
import com.sith.alumnithon.models.Event.dto.ListEventsDTO;
import com.sith.alumnithon.models.Event.dto.RegisterEventDTO;
import com.sith.alumnithon.models.User.Role;
import com.sith.alumnithon.models.User.User;
import com.sith.alumnithon.repositories.EventRepository;
import com.sith.alumnithon.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    public Event register(@Valid RegisterEventDTO dto) {
        User mentor = userRepository.findByIdAndRole(dto.idMentor(), Role.USER); //Debe ser Role.MENTOR
        return eventRepository.save(new Event(dto, mentor));
    }

    public Page<ListEventsDTO> listAll(Pageable pageable) {
        return eventRepository.findAll(pageable).map(ListEventsDTO::new);
    }

}
