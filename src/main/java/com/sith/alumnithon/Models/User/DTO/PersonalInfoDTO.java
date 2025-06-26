package com.sith.alumnithon.Models.User.DTO;

import com.sith.alumnithon.Models.User.Country;

public record PersonalInfoDTO(
    String username, 
    String firstname, 
    String lastname, 
    String email, 
    Country country, 
    Integer age)
    
    {

}
