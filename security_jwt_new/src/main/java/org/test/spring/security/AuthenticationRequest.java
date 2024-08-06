package org.test.spring.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.Size;

@AllArgsConstructor
@Data
public class AuthenticationRequest {
    @NotNull
    @Size(max = 255)
    private String login = null;

    @NotNull
    @Size(max = 255)
    private String password = null;
}