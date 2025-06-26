package com.sith.alumnithon.Models.User.DTO;

import java.sql.Date;
import java.util.List;

import com.sith.alumnithon.Models.Interest.TypeInterest;
import com.sith.alumnithon.Models.Language.Language;
import com.sith.alumnithon.Models.Language.DTO.LanguageSpokenDTO;
import com.sith.alumnithon.Models.User.Country;

public record UserDTO(
    Long id,
    String firstname,
    String lastname,
    String username,
    Country country,
    String email,
    Integer age,
    Date registrationDate,
    List<UserConnectionsDTO> followers,
    List<UserConnectionsDTO> following,
    List<Language> languagesInterests,
    List<LanguageSpokenDTO> languajeSpoken,
    List<TypeInterest> interests
) {

}
