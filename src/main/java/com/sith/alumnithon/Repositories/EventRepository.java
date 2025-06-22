package com.sith.alumnithon.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sith.alumnithon.Models.Event.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
