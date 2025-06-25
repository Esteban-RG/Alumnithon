package com.sith.alumnithon.Config.Auth;

import com.sith.alumnithon.Models.User.Country;

public record RegisterRequest(String username, String password, String firstname, String lastname, Country country, String email, Integer age) {

}
