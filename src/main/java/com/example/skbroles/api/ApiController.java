package com.example.skbroles.api;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
public class ApiController {

    @RolesAllowed("ROLE_ADMIN")
    @GetMapping("/admin")
    public String adminApi(Authentication authentication) {
        var role = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList()).get(0);
        return authentication.getName() + " " + role;
    }

    @RolesAllowed("ROLE_SUPPORT")
    @GetMapping("/support")
    public String supportApi(Authentication authentication) {
        var role = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList()).get(0);
        return authentication.getName() + " " + role;
    }

    @GetMapping("/public")
    public String publicApi(Authentication authentication){
        var test = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return "Public";
    }
}
