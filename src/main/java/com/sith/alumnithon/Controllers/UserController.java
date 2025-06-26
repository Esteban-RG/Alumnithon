package com.sith.alumnithon.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sith.alumnithon.Mappers.UserMapper;
import com.sith.alumnithon.Models.User.DTO.PersonalInfoDTO;
import com.sith.alumnithon.Models.User.DTO.UserDTO;
import com.sith.alumnithon.Services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserMapper userMapper;

    private final  UserService userService;


    @Operation(summary = "Endpoint para listar todos los usuarios")
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAll();
    }
    
    @Operation(summary = "Endpoint para listar un usuario mediante el id")
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getProductById(@PathVariable Long id){
        return userService.getById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Endpoint para eliminar un usuario mediante el ")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return userService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Endpoint para actualizar informacion personal de un usuario")
    @PutMapping("/{id}/personal-info")
    public ResponseEntity<UserDTO> updatePersonalInfo(@PathVariable Long id, @RequestBody PersonalInfoDTO dto) {

        return userService.updatePersonalInfo(id, dto)
            .map(updated -> ResponseEntity.ok(userMapper.toDto(updated)))
            .orElse(ResponseEntity.notFound().build());
            
    }
    
    @Operation(summary = "Endpoint para seguir a otro usuario")
    @PutMapping("/follow/{targetId}")
    public ResponseEntity<Void> follow(@PathVariable Long targetId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        userService.followUser(username, targetId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Endpoint para dejar de seguir a otro usuario")
    @DeleteMapping("/follow/{targetId}")
    public ResponseEntity<Void> unfollow(@PathVariable Long targetId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        userService.unfollowUser(username, targetId);
        return ResponseEntity.noContent().build();
    }
    
}
