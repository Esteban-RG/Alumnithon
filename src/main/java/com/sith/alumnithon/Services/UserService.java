package com.sith.alumnithon.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sith.alumnithon.Mappers.UserMapper;
import com.sith.alumnithon.Models.Interest.Interest;
import com.sith.alumnithon.Models.User.User;
import com.sith.alumnithon.Models.User.DTO.PersonalInfoDTO;
import com.sith.alumnithon.Models.User.DTO.UserDTO;
import com.sith.alumnithon.Repositories.InterestRepository;
import com.sith.alumnithon.Repositories.UserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private InterestRepository interestRepository;
    private UserMapper userMapper;

    @Transactional
    public List<UserDTO> getAll(){
        return userRepository.findAll()
        .stream()
        .map(user -> userMapper.toDto(user)).collect(Collectors.toList());
    }

    @Transactional
    public Optional<UserDTO> getById(Long id){
        return userRepository.findById(id)
        .map(user -> userMapper.toDto(user));
    }

    @Transactional
    public Optional<User> updatePersonalInfo(Long id, PersonalInfoDTO newData){

        return userRepository.findById(id)
            .map(existing -> {
                existing.setUsername(newData.username());
                existing.setFirstname(newData.firstname());
                existing.setLastname(newData.lastname());
                existing.setEmail(newData.email());
                existing.setCountry(newData.country());
                existing.setAge(newData.age());

                return userRepository.save(existing);
            }
        );
    }

    @Transactional
    public void followUser(String username, Long followedId){
        User follower = userRepository.findByUsername(username).orElseThrow( () -> new RuntimeException("User not found"));
        User followed = userRepository.findById(followedId).orElseThrow( () -> new RuntimeException("User not found"));

        if (follower.follow(followed)) {
            userRepository.save(follower);
        }
    }

    @Transactional
    public void unfollowUser(String username, Long followedId){
        User follower = userRepository.findByUsername(username).orElseThrow( () -> new RuntimeException("User not found"));
        User followed = userRepository.findById(followedId).orElseThrow( () -> new RuntimeException("User not found"));

        if (follower.unfollow(followed)) {
            userRepository.save(follower);
        }
    }

    @Transactional
    public void addInterest(String username , Long interestId){
        User user = userRepository.findByUsername(username).orElseThrow( () -> new RuntimeException("User not found"));
        Interest interest = interestRepository.findById(interestId).orElseThrow( () -> new RuntimeException("Interest not found"));

        if (user.addInterest(interest)){
            userRepository.save(user);
        }
    }

    @Transactional
    public void romoveInterest(String username , Long interestId){
        User user = userRepository.findByUsername(username).orElseThrow( () -> new RuntimeException("User not found"));
        Interest interest = interestRepository.findById(interestId).orElseThrow( () -> new RuntimeException("Interest not found"));

        if (user.removeInterest(interest)){
            userRepository.save(user);
        }
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
