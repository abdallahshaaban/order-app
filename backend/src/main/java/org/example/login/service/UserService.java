package org.example.login.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.login.dto.UserDTO;
import org.example.common.enums.ResponseCode;
import org.example.common.exception.LoginException;
import org.example.login.model.User;
import org.example.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserDTO login(String username, String pwd) throws LoginException {
        UserDTO userDTO = new UserDTO();
        Optional<User> user = userRepository.findByNameAndPassword(username,pwd);
        if(user.isPresent()){
            String token = getJWTToken(username);
            userDTO.setUser(username);
            userDTO.setToken(token);
            return userDTO;

        }
        throw new LoginException(ResponseCode.UNAUTHORIZED);
    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
