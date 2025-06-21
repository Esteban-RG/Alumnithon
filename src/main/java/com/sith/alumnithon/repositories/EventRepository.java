package com.sith.alumnithon.repositories;

import com.sith.alumnithon.models.Event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
