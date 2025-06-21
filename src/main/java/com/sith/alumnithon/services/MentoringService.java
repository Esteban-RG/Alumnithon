package com.sith.alumnithon.services;

import com.sith.alumnithon.models.Mentoring.Mentoring;
import com.sith.alumnithon.models.Mentoring.dto.ListMentoriesDTO;
import com.sith.alumnithon.models.Mentoring.dto.RegisterMentoringDTO;
import com.sith.alumnithon.models.User.Role;
import com.sith.alumnithon.models.User.User;
import com.sith.alumnithon.repositories.MentoringRepository;
import com.sith.alumnithon.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MentoringService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MentoringRepository mentoringRepository;

    public Mentoring register(@Valid RegisterMentoringDTO dto) {
        User mentor = userRepository.findByIdAndRole(dto.idMentor(), Role.MENTOR);
        return mentoringRepository.save(new Mentoring(dto, mentor));
    }

    public Page<ListMentoriesDTO> listAll(Pageable pageable) {
        return mentoringRepository.findAll(pageable).map(ListMentoriesDTO::new);
    }

}
