package com.sith.alumnithon.Models.Language.DTO;


import com.sith.alumnithon.Models.Language.Language;
import com.sith.alumnithon.Models.Language.Level;

public record LanguageSpokenDTO(
    Language language,
    Level level
) {

}
