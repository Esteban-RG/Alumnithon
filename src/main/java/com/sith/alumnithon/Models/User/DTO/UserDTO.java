package com.sith.alumnithon.Models.User.DTO;

import com.sith.alumnithon.Models.User.Country;
import com.sith.alumnithon.Models.User.Role;

public record UserDTO(
    String firstname,
    String lastname,
    String username,
    Role role,
    Country country,
    String email,
    Integer age
) {

}
