package com.sith.alumnithon.Mappers;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.sith.alumnithon.Models.Language.DTO.LanguageSpokenDTO;
import com.sith.alumnithon.Models.User.User;
import com.sith.alumnithon.Models.User.DTO.UserConnectionsDTO;
import com.sith.alumnithon.Models.User.DTO.UserDTO;

@Component
public class UserMapper {
    public UserDTO toDto(User user) {
        return new UserDTO(
            user.getId(),
            user.getFirstname(),
            user.getLastname(),
            user.getUsername(),
            user.getCountry(),
            user.getEmail(),
            user.getAge(),
            user.getRegistrationDate(),
            user.getFollowers().stream()
                .map(f -> new UserConnectionsDTO(f.getId(),f.getUsername()))
                .collect(Collectors.toList()),
            user.getFollowing().stream()
                .map(f -> new UserConnectionsDTO(f.getId(),f.getUsername()))
                .collect(Collectors.toList()),
            user.getLanguagesInterest().stream()
                .map(l -> l.getLanguage())
                .collect(Collectors.toList()),
            user.getLanguagesSpoken().stream()
                .map(l -> new LanguageSpokenDTO(l.getLanguage(), l.getLevel()))
                .collect(Collectors.toList()),
            user.getInterests().stream()
                .map(i -> i.getType())
                .collect(Collectors.toList())
        );
    }
}
