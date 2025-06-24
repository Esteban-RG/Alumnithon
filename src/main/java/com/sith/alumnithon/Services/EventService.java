package com.sith.alumnithon.Services;

import com.sith.alumnithon.Models.Event.Event;
import com.sith.alumnithon.Models.Event.dto.ListEventsDTO;
import com.sith.alumnithon.Models.Event.dto.RegisterEventDTO;
import com.sith.alumnithon.Models.Event.dto.ResponseEventDTO;
import com.sith.alumnithon.Models.Event.dto.UpdateEventDTO;
import com.sith.alumnithon.Models.User.Role;
import com.sith.alumnithon.Models.User.User;
import com.sith.alumnithon.Repositories.EventRepository;
import com.sith.alumnithon.Repositories.UserRepository;

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

    public Event register(RegisterEventDTO dto) {
        User mentor = userRepository.findByIdAndRole(dto.idModerator(), Role.USER); //Debe ser Role.MENTOR
        return eventRepository.save(new Event(dto, mentor));
    }

    public Page<ListEventsDTO> listAll(Pageable pageable) {
        return eventRepository.findAll(pageable).map(ListEventsDTO::new);
    }

    public ResponseEventDTO listOne(Long id) {
        Event event = eventRepository.getReferenceById(id);
        ResponseEventDTO responseEventDTO = new ResponseEventDTO(event);
        return responseEventDTO;
    }

    public ResponseEventDTO update(Long id, UpdateEventDTO dto) {
        Event event = eventRepository.getReferenceById(id);
        event.updateEvent(dto);
        return new ResponseEventDTO(event);
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }

}
