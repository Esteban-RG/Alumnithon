package com.sith.alumnithon.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sith.alumnithon.Models.Language.DTO.LanguageSpokenDTO;
import com.sith.alumnithon.Models.User.User;
import com.sith.alumnithon.Models.User.DTO.UserConnectionsDTO;
import com.sith.alumnithon.Models.User.DTO.UserDTO;
import com.sith.alumnithon.Repositories.UserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    @Transactional
    public List<UserDTO> getAll(){
        return userRepository.findAll()
        .stream()
        .map(user -> new UserDTO(
            user.getFirstname(),
            user.getLastname(),
            user.getUsername(),
            user.getCountry(),
            user.getEmail(),
            user.getAge(),
            user.getRegistrationDate(),
            user.getFollowers().stream().map(follower -> new UserConnectionsDTO( follower.getUsername())).collect(Collectors.toList()),
            user.getFollowing().stream().map(followed -> new UserConnectionsDTO( followed.getUsername())).collect(Collectors.toList()),
            user.getLanguagesInterest().stream().map( interest ->  interest.getLanguage()).collect(Collectors.toList()),
            user.getLanguagesSpoken().stream().map(language -> new LanguageSpokenDTO(language.getLanguage(),language.getLevel())).collect(Collectors.toList()),
            user.getInterests().stream().map(interest -> interest.getKind()).collect(Collectors.toList())
        )).collect(Collectors.toList());
    }

    @Transactional
    public Optional<UserDTO> getById(Long id){
        return userRepository.findById(id)
        .map(user -> new UserDTO(
            user.getFirstname(),
            user.getLastname(),
            user.getUsername(),
            user.getCountry(),
            user.getEmail(),
            user.getAge(),
            user.getRegistrationDate(),
            user.getFollowers().stream().map(follower -> new UserConnectionsDTO( follower.getUsername())).collect(Collectors.toList()),
            user.getFollowing().stream().map(followed -> new UserConnectionsDTO( followed.getUsername())).collect(Collectors.toList()),
            user.getLanguagesInterest().stream().map( interest ->  interest.getLanguage()).collect(Collectors.toList()),
            user.getLanguagesSpoken().stream().map(language -> new LanguageSpokenDTO(language.getLanguage(),language.getLevel())).collect(Collectors.toList()),
            user.getInterests().stream().map(interest -> interest.getKind()).collect(Collectors.toList())
        ));
    }


    @Transactional
    public boolean delete(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            return false;
        }

        User user = optionalUser.get();

        userRepository.delete(user);
        return true;
    }

}
